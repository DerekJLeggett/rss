package com.leggett.rss;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.leggett.rss.Feed.Categories;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndCategoryImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@SpringBootApplication
public class RssApplication {

        public static void main(String[] args) {
                SpringApplication.run(RssApplication.class, args);
                List<List<Feed>> feeds = new ArrayList<>();
                List<Feed> entertainmentFeeds = new ArrayList<>();
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://rss.tvguide.com/breakingnews"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.tvguide.com/feed/rss/gallery.xml"));
                entertainmentFeeds.add(
                                new Feed(Arrays.asList(Categories.ENTERTAINMENT), "https://www.etonline.com/news/rss"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.etonline.com/gallery/rss"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.etonline.com/video/rss"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://feeds.npr.org/1008/rss.xml"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.newyorker.com/feed/humor"));
                entertainmentFeeds.add(
                                new Feed(Arrays.asList(Categories.ENTERTAINMENT), "https://feeds.npr.org/13/rss.xml"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://feeds.npr.org/1045/rss.xml"));
                entertainmentFeeds.add(new Feed(Arrays.asList(Categories.ENTERTAINMENT),
                                "https://www.youtube.com/feeds/videos.xml?user=EntertainmentTonight"));
                feeds.add(entertainmentFeeds);

                List<Feed> newsFeeds = new ArrayList<>();
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://feeds.npr.org/1001/rss.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://feeds.npr.org/510318/podcast.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "https://www.huffpost.com/section/front-page/feed?x=1"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "http://www.politico.com/rss/politicopicks.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.yahoo.com/news/rss"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.latimes.com/local/rss2.0.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "http://newsrss.bbc.co.uk/rss/newsonline_world_edition/americas/rss.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://www.vox.com/rss/index.xml"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS),
                                "https://podcastfeeds.nbcnews.com/dateline-nbc"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "http://rss.art19.com/the-daily"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS), "https://feeds.megaphone.fm/WWO8086402096"));
                newsFeeds.add(new Feed(Arrays.asList(Categories.NEWS, Categories.RUSSIA),
                                "https://www.themoscowtimes.com/rss/news"));
                feeds.add(newsFeeds);

                List<Feed> educationFeeds = new ArrayList<>();
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION), "https://www.ed.gov/feed"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION),
                                "https://www2.smartbrief.com/servlet/rss?b=ASCD"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION), "https://feeds.npr.org/1013/rss.xml"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION),
                                "http://blog.discoveryeducation.com/feed/"));
                educationFeeds.add(new Feed(Arrays.asList(Categories.EDUCATION),
                                "https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/learning/rss.xml"));
                feeds.add(educationFeeds);

                List<Feed> technologyFeeds = new ArrayList<>();
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.wired.com/feed"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml"));
                technologyFeeds.add(
                                new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://feeds.npr.org/1019/rss.xml"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.surfnetkids.com/resources/feed/"));
                technologyFeeds.add(
                                new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.macworld.com/index.rss"));
                technologyFeeds.add(
                                new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.pcworld.com/feed"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.engadget.com/rss.xml"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY), "https://www.anandtech.com/rss/"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.tomshardware.com/feeds/all"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "http://rss.slashdot.org/Slashdot/slashdot"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.theverge.com/rss/index.xml"));
                technologyFeeds.add(new Feed(Arrays.asList(Categories.TECHNOLOGY),
                                "https://www.howtogeek.com/feed"));
                feeds.add(technologyFeeds);

                List<Feed> scienceFeeds = new ArrayList<>();
                scienceFeeds.add(new Feed(Arrays.asList(Categories.SCIENCE),
                                "http://feeds.sciencedaily.com/sciencedaily"));
                scienceFeeds.add(new Feed(Arrays.asList(Categories.SCIENCE),
                                "https://www.smithsonianmag.com/rss/latest_articles/"));
                feeds.add(scienceFeeds);

                List<Feed> natureFeeds = new ArrayList<>();
                natureFeeds.add(new Feed(Arrays.asList(Categories.NATURE),
                                "https://www.nature.com/nature.rss"));
                feeds.add(natureFeeds);

                List<Feed> spaceFeeds = new ArrayList<>();
                spaceFeeds.add(new Feed(Arrays.asList(Categories.SPACE),
                                "https://www.nasa.gov/rss/dyn/breaking_news.rss"));
                spaceFeeds.add(new Feed(Arrays.asList(Categories.SPACE),
                                "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss"));
                feeds.add(spaceFeeds);

                List<Feed> pbsFeeds = new ArrayList<>();
                pbsFeeds.add(new Feed(Arrays.asList(Categories.PBS), "https://www.pbs.org/wgbh/nova/rss/all/"));
                feeds.add(pbsFeeds);

                List<Feed> sportsFeeds = new ArrayList<>();
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS),
                                "https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://www.nba.com/jazz/rss.xml"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://www.espn.com/espn/rss/news"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS, Categories.BOXING),
                                "https://www.cbssports.com/rss/headlines/boxing/"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS, Categories.COLLEGE_BASKETBALL),
                                "https://www.cbssports.com/rss/headlines/college-basketball/"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS, Categories.BASEBALL),
                                "https://www.mlb.com/feeds/news/rss.xml"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://www.si.com/.rss/full/"));
                sportsFeeds.add(new Feed(Arrays.asList(Categories.SPORTS), "https://feeds.megaphone.fm/newheights"));
                feeds.add(sportsFeeds);

                List<Feed> celebrityFeeds = new ArrayList<>();
                celebrityFeeds.add(new Feed(Arrays.asList(Categories.CELEBRITY), "https://www.usmagazine.com/feed/"));
                feeds.add(celebrityFeeds);

                List<Feed> photoFeeds = new ArrayList<>();
                photoFeeds.add(new Feed(Arrays.asList(Categories.PHOTOS),
                                "http://davidkphotography.com/index.php?x=rss"));
                feeds.add(photoFeeds);

                List<Feed> musicFeeds = new ArrayList<>();
                musicFeeds.add(new Feed(Arrays.asList(Categories.MUSIC), "https://www.billboard.com/feed/"));
                feeds.add(musicFeeds);

                List<Feed> movieFeeds = new ArrayList<>();
                movieFeeds.add(new Feed(Arrays.asList(Categories.MOVIES), "https://movieweb.com/feed/"));
                feeds.add(movieFeeds);

                List<Feed> gamingFeeds = new ArrayList<>();
                gamingFeeds.add(new Feed(Arrays.asList(Categories.PC_VIDEO_GAMES),
                                "https://store.steampowered.com/feeds/news.xml"));
                feeds.add(gamingFeeds);

                List<Feed> autoFeeds = new ArrayList<>();
                autoFeeds.add(new Feed(Arrays.asList(Categories.AUTOMOTIVE),
                                "https://www.caranddriver.com/rss/all.xml"));
                feeds.add(autoFeeds);

                List<Feed> medicalFeeds = new ArrayList<>();
                medicalFeeds.add(new Feed(Arrays.asList(Categories.MEDICAL),
                                "https://www.medicinenet.com/rss/dailyhealth.xml"));
                medicalFeeds.add(new Feed(Arrays.asList(Categories.MEDICAL),
                                "https://medlineplus.gov/feeds/whatsnew.xml"));
                medicalFeeds.add(new Feed(Arrays.asList(Categories.MEDICAL),
                                "https://tools.cdc.gov/podcasts/feed.asp?feedid=183"));
                feeds.add(medicalFeeds);

                List<Feed> libraryFeeds = new ArrayList<>();
                libraryFeeds.add(new Feed(Arrays.asList(Categories.LIBRARY), "https://www.loc.gov/rss/pao/news.xml"));
                feeds.add(libraryFeeds);

                List<Feed> fashionFeeds = new ArrayList<>();
                fashionFeeds.add(new Feed(Arrays.asList(Categories.FASHION), "https://www.elle.com/rss/all.xml/"));
                fashionFeeds.add(new Feed(Arrays.asList(Categories.FASHION), "https://www.vanityfair.com/feed/rss"));
                feeds.add(fashionFeeds);

                List<Feed> lifestyleFeeds = new ArrayList<>();
                lifestyleFeeds.add(new Feed(Arrays.asList(Categories.LIFESTYLE), "https://lifehacker.com/rss"));
                feeds.add(lifestyleFeeds);

                List<Feed> nationalParkFeeds = new ArrayList<>();
                nationalParkFeeds.add(new Feed(Arrays.asList(Categories.NATIONAL_PARKS),
                                "https://www.nps.gov/feeds/getnewsrss.htm?id=gate"));
                nationalParkFeeds.add(new Feed(Arrays.asList(Categories.NATIONAL_PARKS),
                                "https://www.nps.gov/feeds/getnewsrss.htm?id=grca"));
                feeds.add(nationalParkFeeds);

                List<Feed> webDevFeeds = new ArrayList<>();
                webDevFeeds.add(new Feed(Arrays.asList(Categories.WEB_DEV), "https://www.smashingmagazine.com/feed/"));
                feeds.add(webDevFeeds);

                List<Feed> comedyFeeds = new ArrayList<>();
                comedyFeeds.add(new Feed(Arrays.asList(Categories.COMEDY),
                                "https://rss.art19.com/smartless"));
                feeds.add(comedyFeeds);

                List<Feed> documentaryFeeds = new ArrayList<>();
                documentaryFeeds.add(new Feed(Arrays.asList(Categories.DOCUMENTARY),
                                "https://feeds.simplecast.com/6HzeyO6b"));
                feeds.add(documentaryFeeds);

                List<Feed> raceFeeds = new ArrayList<>();
                raceFeeds.add(new Feed(Arrays.asList(Categories.RACE), "https://feeds.npr.org/510312/podcast.xml"));
                feeds.add(raceFeeds);

                List<Feed> crimeFeeds = new ArrayList<>();
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME), "https://feeds.megaphone.fm/ADL9840290619"));
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME),
                                "https://www.omnycontent.com/d/playlist/aaea4e69-af51-495e-afc9-a9760146922b/44bbf446-4627-4f83-a7fd-ab070007db11/72b96aa8-88bd-480a-87af-ab070007db36/podcast.rss"));
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME), "https://podcastfeeds.nbcnews.com/RPWEjhKq"));
                crimeFeeds.add(new Feed(Arrays.asList(Categories.CRIME), "https://rss.art19.com/-exposed-"));
                feeds.add(crimeFeeds);

                List<Feed> humanityFeeds = new ArrayList<>();
                humanityFeeds.add(new Feed(Arrays.asList(Categories.HUMANITY),
                                "https://feeds.megaphone.fm/unlocking-us"));
                feeds.add(humanityFeeds);

                List<Feed> militaryFeeds = new ArrayList<>();
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY), "https://www.janes.com/feeds/news"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY),
                                "https://www.military.com/rss-feeds/content?keyword=headlines&channel=news&type=news"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.NAVY),
                                "http://feeds.feedburner.com/navy-times/news/your-navy"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.VETERANS),
                                "http://feeds.feedburner.com/military-times/veterans"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.VETERANS),
                                "http://www.va.gov/rss/rss_PressRel.asp"));
                militaryFeeds.add(new Feed(Arrays.asList(Categories.MILITARY, Categories.VETERANS),
                                "https://www.va.gov/health/NewsFeatures/news.xml"));
                feeds.add(militaryFeeds);

                List<Feed> governmentFeeds = new ArrayList<>();
                governmentFeeds.add(new Feed(Arrays.asList(Categories.GOVERNMENT),
                                "https://www.dhs.gov/news_and_updates/rss.xml"));
                governmentFeeds.add(new Feed(Arrays.asList(Categories.GOVERNMENT),
                                "https://www.fbi.gov/feeds/national-press-releases/rss.xml"));
                feeds.add(governmentFeeds);

                boolean ok = false;
                List<String> headLinks = new ArrayList<>();
                List<Element> bodyLinks = new ArrayList<>();
                try {
                        for (List<Feed> feedListByCat : feeds) {
                                SyndFeed feed = new SyndFeedImpl();
                                feed.setFeedType("rss_2.0");
                                String category = feedListByCat.get(0).getCategory().get(0).getCategory();
                                String title = "TheDorey.com - " + category + " Feed";
                                feed.setTitle(title);
                                feed.setDescription(
                                                "An eclectic collection of feeds from around the web.");
                                feed.setAuthor("Derek Leggett");
                                feed.setLink("https://www.thedorey.com/" + category.replace(" ", "_") + ".xml");
                                for (Feed feedByCat : feedListByCat) {
                                        try {
                                                List entries = new ArrayList();
                                                feed.setEntries(entries);
                                                SyndFeedInput input = new SyndFeedInput();
                                                SyndFeed inFeed = input.build(new XmlReader(new URL(feedByCat.url)));
                                                System.out.println(feedByCat.url);
                                                List<SyndEntry> entryList = inFeed.getEntries();
                                                for (SyndEntry entry : entryList) {
                                                        List<SyndCategory> cats = entry.getCategories();
                                                        for (int i = 0; i < feedByCat.categories.size(); i++) {
                                                                SyndCategory syndCategory = new SyndCategoryImpl();
                                                                syndCategory.setName(
                                                                                feedByCat.categories.get(i)
                                                                                                .getCategory());
                                                                cats.add(i, syndCategory);
                                                        }
                                                }
                                                entries.addAll(entryList);
                                        } catch (Exception e) {
                                                System.out.println("ERROR: " + e.getMessage());
                                        }
                                }
                                SyndFeedOutput output = new SyndFeedOutput();
                                String href = category.replace(" ", "_") + ".xml";
                                headLinks.add("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"" + title
                                                + "\" href=\"" + href + "\" />");
                                Element bodyLinkElement = new Element("div").addClass("col")
                                                .appendChild(new Element("a").attr("href", href).text(category)
                                                                .appendChild(new Element("img").attr("src",
                                                                                "Feed-icon.svg")
                                                                                .attr("alt", title)));
                                bodyLinks.add(bodyLinkElement);
                                output.output(feed, new File("./target/" + category.replace(" ", "_") + ".xml"));
                        }
                        Document doc = Jsoup.parse("<html lang=\"en\"></html>");
                        doc.head().append("<meta charset=\"utf-8\">"
                                        + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                                        + "<title>TheDorey</title>"
                                        + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
                        for (String headLink : headLinks) {
                                doc.head().append(headLink);
                        }
                        Element container = new Element("div").addClass("container-fluid text-center");
                        container.appendChild(new Element("h1").text("Aggregated RSS feeds by category")
                                        .addClass("text-center"));
                        Element row = new Element("div").addClass("row");
                        for (Element bodyLink : bodyLinks) {
                                row.appendChild(bodyLink);
                        }
                        container.appendChild(row);
                        doc.body().appendChild(container);
                        File htmlFile = new File("./target/index.html");
                        FileUtils.writeStringToFile(htmlFile, doc.outerHtml(), StandardCharsets.UTF_8);
                        System.out.println(doc.toString());
                        ok = true;
                } catch (Exception ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                }

                if (!ok) {
                        System.out.println();
                        System.out.println("FeedAggregator aggregates different feeds into a single one.");
                        System.out.println("The first parameter must be the feed type for the aggregated feed.");
                        System.out.println(" [valid values are: rss_0.9, rss_0.91U, rss_0.91N, rss_0.92, rss_0.93, ]");
                        System.out.println(" [                  rss_0.94, rss_1.0, rss_2.0 & atom_0.3  ]");
                        System.out.println("The second to last parameters are the URLs of feeds to aggregate.");
                        System.out.println();
                }
        }
}

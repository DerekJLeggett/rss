package com.leggett.rss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

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
        List<Feed> feeds = new ArrayList<>();
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://rss.tvguide.com/breakingnews"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://www.tvguide.com/feed/rss/gallery.xml"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://www.etonline.com/news/rss"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://www.etonline.com/gallery/rss"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://www.etonline.com/video/rss"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://feeds.npr.org/1008/rss.xml"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://www.newyorker.com/feed/humor"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://feeds.npr.org/13/rss.xml"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT), "https://feeds.npr.org/1045/rss.xml"));
        feeds.add(new Feed(List.of(Categories.ENTERTAINMENT),
                "https://www.youtube.com/feeds/videos.xml?user=EntertainmentTonight"));
        feeds.add(new Feed(List.of(Categories.NEWS), "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"));
        feeds.add(new Feed(List.of(Categories.NEWS), "https://feeds.npr.org/1001/rss.xml"));
        feeds.add(new Feed(List.of(Categories.NEWS),
                "http://newsrss.bbc.co.uk/rss/newsonline_world_edition/americas/rss.xml"));
        feeds.add(new Feed(List.of(Categories.NEWS),
                "http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int"));
        feeds.add(new Feed(List.of(Categories.NEWS), "https://www.vox.com/rss/index.xml"));
        feeds.add(new Feed(List.of(Categories.NEWS), "https://podcastfeeds.nbcnews.com/dateline-nbc"));
        // feeds.add(new Feed(Categories.NEWS, "http://rss.art19.com/the-daily"));
        feeds.add(new Feed(List.of(Categories.NEWS), "https://feeds.megaphone.fm/WWO8086402096"));
        feeds.add(new Feed(List.of(Categories.NEWS, Categories.RUSSIA), "https://www.themoscowtimes.com/rss/news"));
        feeds.add(new Feed(List.of(Categories.EDUCATION), "https://www.ed.gov/feed"));
        feeds.add(new Feed(List.of(Categories.EDUCATION), "https://www2.smartbrief.com/servlet/rss?b=ASCD"));
        feeds.add(new Feed(List.of(Categories.EDUCATION), "https://feeds.npr.org/1013/rss.xml"));
        feeds.add(new Feed(List.of(Categories.EDUCATION), "http://blog.discoveryeducation.com/feed/"));
        feeds.add(new Feed(List.of(Categories.EDUCATION),
                "https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/learning/rss.xml"));
        feeds.add(new Feed(List.of(Categories.SCIENCE), "http://feeds.sciencedaily.com/sciencedaily"));
        feeds.add(new Feed(List.of(Categories.SCIENCE), "https://www.smithsonianmag.com/rss/latest_articles/"));
        feeds.add(new Feed(List.of(Categories.NATURE), "http://feeds.nature.com/nature/rss/current"));
        feeds.add(new Feed(List.of(Categories.SPACE), "https://www.nasa.gov/rss/dyn/breaking_news.rss"));
        feeds.add(new Feed(List.of(Categories.SPACE), "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.wired.com/feed"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY),
                "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://feeds.npr.org/1019/rss.xml"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.surfnetkids.com/resources/feed/"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.macworld.com/index.rss"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.pcworld.com/index.rss"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.engadget.com/rss.xml"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.anandtech.com/rss/"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.tomshardware.com/feeds/all"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "http://rss.slashdot.org/Slashdot/slashdot"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://www.theverge.com/rss/index.xml"));
        feeds.add(new Feed(List.of(Categories.TECHNOLOGY), "https://feeds.howtogeek.com/HowToGeek"));
        feeds.add(new Feed(List.of(Categories.PBS), "https://www.pbs.org/wgbh/nova/rss/all/"));
        feeds.add(new Feed(List.of(Categories.SPORTS), "https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml"));
        feeds.add(new Feed(List.of(Categories.SPORTS), "https://www.nba.com/jazz/rss.xml"));
        feeds.add(new Feed(List.of(Categories.SPORTS), "https://www.espn.com/espn/rss/news"));
        feeds.add(new Feed(List.of(Categories.SPORTS, Categories.BOXING),
                "https://www.cbssports.com/rss/headlines/boxing/"));
        feeds.add(new Feed(List.of(Categories.SPORTS, Categories.COLLEGE_BASKETBALL),
                "https://www.cbssports.com/rss/headlines/college-basketball/"));
        feeds.add(new Feed(List.of(Categories.CELEBRITY), "https://www.usmagazine.com/feed/"));
        feeds.add(new Feed(List.of(Categories.PHOTOS), "http://davidkphotography.com/index.php?x=rss"));
        feeds.add(new Feed(List.of(Categories.SPORTS, Categories.BASEBALL), "https://www.mlb.com/feeds/news/rss.xml"));
        feeds.add(new Feed(List.of(Categories.MUSIC), "https://www.billboard.com/feed/"));
        feeds.add(new Feed(List.of(Categories.MOVIES), "https://www.metacritic.com/rss/movies"));
        feeds.add(new Feed(List.of(Categories.MOVIES), "https://movieweb.com/rss/all-news/"));
        feeds.add(new Feed(List.of(Categories.PC_VIDEO_GAMES), "https://www.metacritic.com/rss/games/pc"));
        feeds.add(new Feed(List.of(Categories.PC_VIDEO_GAMES), "https://store.steampowered.com/feeds/news.xml"));
        feeds.add(new Feed(List.of(Categories.AUTOMOTIVE), "https://www.motortrend.com/feed/"));
        feeds.add(new Feed(List.of(Categories.MEDICAL), "https://www.medicinenet.com/rss/dailyhealth.xml"));
        feeds.add(new Feed(List.of(Categories.MEDICAL), "https://medlineplus.gov/feeds/whatsnew.xml"));
        feeds.add(new Feed(List.of(Categories.MEDICAL), "https://tools.cdc.gov/podcasts/feed.asp?feedid=183"));
        feeds.add(new Feed(List.of(Categories.LIBRARY), "https://www.loc.gov/rss/pao/news.xml"));
        feeds.add(new Feed(List.of(Categories.FASHION), "https://www.elle.com/rss/all.xml/"));
        feeds.add(new Feed(List.of(Categories.FASHION), "https://www.vanityfair.com/feed/rss"));
        feeds.add(new Feed(List.of(Categories.LIFESTYLE), "https://lifehacker.com/rss"));
        feeds.add(new Feed(List.of(Categories.NATIONAL_PARKS), "https://www.nps.gov/feeds/getnewsrss.htm?id=gate"));
        feeds.add(new Feed(List.of(Categories.NATIONAL_PARKS), "https://www.nps.gov/feeds/getnewsrss.htm?id=grca"));
        feeds.add(new Feed(List.of(Categories.WEB_DEV), "https://www.smashingmagazine.com/feed/"));
        feeds.add(new Feed(List.of(Categories.COMEDY), "http://joeroganexp.joerogan.libsynpro.com/rss"));
        feeds.add(new Feed(List.of(Categories.DOCUMENTARY), "https://feeds.simplecast.com/6HzeyO6b"));
        feeds.add(new Feed(List.of(Categories.RACE), "https://feeds.npr.org/510312/podcast.xml"));
        feeds.add(new Feed(List.of(Categories.CRIME), "https://feeds.megaphone.fm/ADL9840290619"));
        feeds.add(new Feed(List.of(Categories.CRIME),
                "https://www.omnycontent.com/d/playlist/aaea4e69-af51-495e-afc9-a9760146922b/44bbf446-4627-4f83-a7fd-ab070007db11/72b96aa8-88bd-480a-87af-ab070007db36/podcast.rss"));
        feeds.add(new Feed(List.of(Categories.HUMANITY), "https://feeds.megaphone.fm/unlocking-us"));
        feeds.add(new Feed(List.of(Categories.MILITARY), "https://www.janes.com/feeds/news"));
        feeds.add(new Feed(List.of(Categories.MILITARY),
                "https://www.military.com/rss-feeds/content?keyword=headlines&channel=news&type=news"));
        feeds.add(new Feed(List.of(Categories.MILITARY, Categories.NAVY),
                "http://feeds.feedburner.com/navy-times/news/your-navy"));
        feeds.add(new Feed(List.of(Categories.MILITARY, Categories.VETERANS),
                "http://feeds.feedburner.com/military-times/veterans"));
        feeds.add(
                new Feed(List.of(Categories.MILITARY, Categories.VETERANS), "http://www.va.gov/rss/rss_PressRel.asp"));
        feeds.add(new Feed(List.of(Categories.MILITARY, Categories.VETERANS),
                "https://www.va.gov/health/NewsFeatures/news.xml"));
        feeds.add(new Feed(List.of(Categories.GOVERNMENT), "https://www.dhs.gov/news_and_updates/rss.xml"));
        feeds.add(
                new Feed(List.of(Categories.GOVERNMENT), "https://www.fbi.gov/feeds/national-press-releases/rss.xml"));

        boolean ok = false;
        try {
            SyndFeed feed = new SyndFeedImpl();
            feed.setFeedType("rss_2.0");

            feed.setTitle("TheDorey.com - Aggregated Feed");
            feed.setDescription("An eclectic collection of feeds from around the web.");
            feed.setAuthor("Derek Leggett");
            feed.setLink("https://www.thedorey.com/assets/rss/rss.xml");

            List entries = new ArrayList();
            feed.setEntries(entries);

            for (Feed feedly : feeds) {
                try {
                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed inFeed = input.build(new XmlReader(new URL(feedly.url)));
                    System.out.println(feedly.url);
                    List<SyndEntry> entryList = inFeed.getEntries();
                    for (SyndEntry entry : entryList) {
                        List<SyndCategory> cats = entry.getCategories();
                        for (int i = 0; i < feedly.categories.size(); i++) {
                            SyndCategory syndCategory = new SyndCategoryImpl();
                            syndCategory.setName(feedly.categories.get(i).getCategory());
                            cats.add(i, syndCategory);
                        }
                    }
                    entries.addAll(entryList);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                }

            }

            SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed, new File("rss.xml"));

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

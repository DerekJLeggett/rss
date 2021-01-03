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
        feeds.add(new Feed(Categories.entertainment, "https://rss.tvguide.com/breakingnews      "));
        feeds.add(new Feed(Categories.entertainment, "https://www.tvguide.com/feed/rss/gallery.xml"));
        feeds.add(new Feed(Categories.entertainment, "https://www.etonline.com/news/rss"));
        feeds.add(new Feed(Categories.entertainment, "https://www.etonline.com/gallery/rss"));
        feeds.add(new Feed(Categories.entertainment, "https://www.etonline.com/video/rss"));
        feeds.add(new Feed(Categories.entertainment, "https://feeds.npr.org/1008/rss.xml"));
        feeds.add(new Feed(Categories.entertainment, "https://www.newyorker.com/feed/humor"));
        feeds.add(new Feed(Categories.entertainment, "https://feeds.npr.org/13/rss.xml"));
        feeds.add(new Feed(Categories.entertainment, "https://feeds.npr.org/1045/rss.xml"));
        feeds.add(new Feed(Categories.entertainment, "https://www.youtube.com/feeds/videos.xml?user=EntertainmentTonight"));
        feeds.add(new Feed(Categories.news, "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"));
        feeds.add(new Feed(Categories.news, "https://feeds.npr.org/1001/rss.xml"));
        feeds.add(new Feed(Categories.news, "http://newsrss.bbc.co.uk/rss/newsonline_world_edition/americas/rss.xml"));
        feeds.add(new Feed(Categories.news, "http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int"));
        feeds.add(new Feed(Categories.education, "https://www.ed.gov/feed"));
        feeds.add(new Feed(Categories.education, "https://www2.smartbrief.com/servlet/rss?b=ASCD"));
        feeds.add(new Feed(Categories.education, "https://feeds.npr.org/1013/rss.xml"));
        feeds.add(new Feed(Categories.education, "http://blog.discoveryeducation.com/feed/"));
        feeds.add(new Feed(Categories.education, "https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/learning/rss.xml"));
        feeds.add(new Feed(Categories.science, "http://feeds.sciencedaily.com/sciencedaily"));
        feeds.add(new Feed(Categories.science, "https://www.smithsonianmag.com/rss/latest_articles/"));
        feeds.add(new Feed(Categories.nature, "http://feeds.nature.com/nature/rss/current"));
        feeds.add(new Feed(Categories.space, "https://www.nasa.gov/rss/dyn/breaking_news.rss"));
        feeds.add(new Feed(Categories.space, "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss"));
        feeds.add(new Feed(Categories.technology, "https://www.wired.com/feed"));
        feeds.add(new Feed(Categories.technology, "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml"));
        feeds.add(new Feed(Categories.technology, "https://feeds.npr.org/1019/rss.xml"));
        feeds.add(new Feed(Categories.technology, "https://www.surfnetkids.com/resources/feed/"));
        feeds.add(new Feed(Categories.technology, "https://www.macworld.com/index.rss"));
        feeds.add(new Feed(Categories.technology, "https://www.pcworld.com/index.rss"));
        feeds.add(new Feed(Categories.technology, "https://www.engadget.com/rss.xml"));
        feeds.add(new Feed(Categories.technology, "https://www.anandtech.com/rss/"));
        feeds.add(new Feed(Categories.technology, "https://www.tomshardware.com/feeds/all"));
        feeds.add(new Feed(Categories.pbs, "https://www.pbs.org/wgbh/nova/rss/all/"));
        feeds.add(new Feed(Categories.sports, "https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml"));
        feeds.add(new Feed(Categories.sports, "https://www.nba.com/jazz/rss.xml"));
        feeds.add(new Feed(Categories.sports, "https://www.espn.com/espn/rss/news"));
        feeds.add(new Feed(Categories.boxing, "https://www.cbssports.com/rss/headlines/boxing/"));
        feeds.add(new Feed(Categories.college_basketball, "https://www.cbssports.com/rss/headlines/college-basketball/"));
        feeds.add(new Feed(Categories.celebrity, "https://www.usmagazine.com/feed/"));
        feeds.add(new Feed(Categories.photos, "http://davidkphotography.com/index.php?x=rss"));
        feeds.add(new Feed(Categories.baseball, "https://www.mlb.com/feeds/news/rss.xml"));
        feeds.add(new Feed(Categories.music, "https://www.billboard.com/feed/"));
        feeds.add(new Feed(Categories.movies, "https://www.metacritic.com/rss/movies"));
        feeds.add(new Feed(Categories.movies, "https://movieweb.com/rss/all-news/"));
        feeds.add(new Feed(Categories.pc_video_games, "https://www.metacritic.com/rss/games/pc"));
        feeds.add(new Feed(Categories.automotive, "https://www.motortrend.com/feed/"));
        feeds.add(new Feed(Categories.medical, "https://www.medicinenet.com/rss/dailyhealth.xml"));
        feeds.add(new Feed(Categories.medical, "https://medlineplus.gov/feeds/whatsnew.xml"));
        feeds.add(new Feed(Categories.library, "https://www.loc.gov/rss/pao/news.xml"));
        feeds.add(new Feed(Categories.fashion, "https://www.elle.com/rss/all.xml/"));
        feeds.add(new Feed(Categories.fashion, "https://www.gq.com/feed/style/rss"));
        feeds.add(new Feed(Categories.fashion, "https://www.vanityfair.com/feed/rss"));
        feeds.add(new Feed(Categories.fashion, "https://www.maxim.com/.rss/full/"));
        feeds.add(new Feed(Categories.lifestyle, "https://lifehacker.com/rss"));
        feeds.add(new Feed(Categories.national_parks, "https://www.nps.gov/feeds/getnewsrss.htm?id=gate"));
        feeds.add(new Feed(Categories.national_parks, "https://www.nps.gov/feeds/getnewsrss.htm?id=grca"));

        // List<SyndCategory> categories = new ArrayList<SyndCategory>();
        // SyndCategory category = new SyndCategoryImpl();
        // category.setName(feedly.category.toString());
        // categories.add(category);
        // inFeed.setCategories(categories);

        boolean ok = false;
            try {
                SyndFeed feed = new SyndFeedImpl();
                feed.setFeedType("rss_2.0");

                feed.setTitle("Aggregated Feed");
                feed.setDescription(feed.getTitle());
                feed.setAuthor("Derek Leggett");
                feed.setLink("https://www.thedorey.com/assets/rss/rss.xml");

                List entries = new ArrayList();
                feed.setEntries(entries);

                for (Feed feedly:feeds) {
                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed inFeed = input.build(new XmlReader(new URL(feedly.url)));
                   

                    entries.addAll(inFeed.getEntries());

                }

                SyndFeedOutput output = new SyndFeedOutput();
                output.output(feed,new File("rss.xml"));

                ok = true;
            }
            catch (Exception ex) {
                System.out.println("ERROR: "+ex.getMessage());
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

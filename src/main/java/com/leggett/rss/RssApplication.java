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
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://rss.tvguide.com/breakingnews      "));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://www.tvguide.com/feed/rss/gallery.xml"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://www.etonline.com/news/rss"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://www.etonline.com/gallery/rss"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://www.etonline.com/video/rss"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://feeds.npr.org/1008/rss.xml"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://www.newyorker.com/feed/humor"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://feeds.npr.org/13/rss.xml"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://feeds.npr.org/1045/rss.xml"));
        feeds.add(new Feed(Categories.ENTERTAINMENT, "https://www.youtube.com/feeds/videos.xml?user=EntertainmentTonight"));
        feeds.add(new Feed(Categories.NEWS, "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"));
        feeds.add(new Feed(Categories.NEWS, "https://feeds.npr.org/1001/rss.xml"));
        feeds.add(new Feed(Categories.NEWS, "http://newsrss.bbc.co.uk/rss/newsonline_world_edition/americas/rss.xml"));
        feeds.add(new Feed(Categories.NEWS, "http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml?edition=int"));
        feeds.add(new Feed(Categories.EDUCATION, "https://www.ed.gov/feed"));
        feeds.add(new Feed(Categories.EDUCATION, "https://www2.smartbrief.com/servlet/rss?b=ASCD"));
        feeds.add(new Feed(Categories.EDUCATION, "https://feeds.npr.org/1013/rss.xml"));
        feeds.add(new Feed(Categories.EDUCATION, "http://blog.discoveryeducation.com/feed/"));
        feeds.add(new Feed(Categories.EDUCATION, "https://www.nytimes.com/svc/collections/v1/publish/https://www.nytimes.com/section/learning/rss.xml"));
        feeds.add(new Feed(Categories.SCIENCE, "http://feeds.sciencedaily.com/sciencedaily"));
        feeds.add(new Feed(Categories.SCIENCE, "https://www.smithsonianmag.com/rss/latest_articles/"));
        feeds.add(new Feed(Categories.NATURE, "http://feeds.nature.com/nature/rss/current"));
        feeds.add(new Feed(Categories.SPACE, "https://www.nasa.gov/rss/dyn/breaking_news.rss"));
        feeds.add(new Feed(Categories.SPACE, "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.wired.com/feed"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://feeds.npr.org/1019/rss.xml"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.surfnetkids.com/resources/feed/"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.macworld.com/index.rss"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.pcworld.com/index.rss"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.engadget.com/rss.xml"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.anandtech.com/rss/"));
        feeds.add(new Feed(Categories.TECHNOLOGY, "https://www.tomshardware.com/feeds/all"));
        feeds.add(new Feed(Categories.PBS, "https://www.pbs.org/wgbh/nova/rss/all/"));
        feeds.add(new Feed(Categories.SPORTS, "https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml"));
        feeds.add(new Feed(Categories.SPORTS, "https://www.nba.com/jazz/rss.xml"));
        feeds.add(new Feed(Categories.SPORTS, "https://www.espn.com/espn/rss/news"));
        feeds.add(new Feed(Categories.BOXING, "https://www.cbssports.com/rss/headlines/boxing/"));
        feeds.add(new Feed(Categories.COLLEGE_BASKETBALL, "https://www.cbssports.com/rss/headlines/college-basketball/"));
        feeds.add(new Feed(Categories.CELEBRITY, "https://www.usmagazine.com/feed/"));
        feeds.add(new Feed(Categories.PHOTOS, "http://davidkphotography.com/index.php?x=rss"));
        feeds.add(new Feed(Categories.BASEBALL, "https://www.mlb.com/feeds/news/rss.xml"));
        feeds.add(new Feed(Categories.MUSIC, "https://www.billboard.com/feed/"));
        feeds.add(new Feed(Categories.MOVIES, "https://www.metacritic.com/rss/movies"));
        feeds.add(new Feed(Categories.MOVIES, "https://movieweb.com/rss/all-news/"));
        feeds.add(new Feed(Categories.PC_VIDEO_GAMES, "https://www.metacritic.com/rss/games/pc"));
        feeds.add(new Feed(Categories.PC_VIDEO_GAMES, "https://store.steampowered.com/feeds/news.xml"));
        feeds.add(new Feed(Categories.AUTOMOTIVE, "https://www.motortrend.com/feed/"));
        feeds.add(new Feed(Categories.MEDICAL, "https://www.medicinenet.com/rss/dailyhealth.xml"));
        feeds.add(new Feed(Categories.MEDICAL, "https://medlineplus.gov/feeds/whatsnew.xml"));
        feeds.add(new Feed(Categories.LIBRARY, "https://www.loc.gov/rss/pao/news.xml"));
        feeds.add(new Feed(Categories.FASHION, "https://www.elle.com/rss/all.xml/"));
        feeds.add(new Feed(Categories.FASHION, "https://www.gq.com/feed/style/rss"));
        feeds.add(new Feed(Categories.FASHION, "https://www.vanityfair.com/feed/rss"));
        feeds.add(new Feed(Categories.FASHION, "https://www.maxim.com/.rss/full/"));
        feeds.add(new Feed(Categories.LIFESTYLE, "https://lifehacker.com/rss"));
        feeds.add(new Feed(Categories.NATIONAL_PARKS, "https://www.nps.gov/feeds/getnewsrss.htm?id=gate"));
        feeds.add(new Feed(Categories.NATIONAL_PARKS, "https://www.nps.gov/feeds/getnewsrss.htm?id=grca"));

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

                for (Feed feedly:feeds) {
                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed inFeed = input.build(new XmlReader(new URL(feedly.url)));
                   
                    List<SyndEntry> entryList = inFeed.getEntries();
                    for(SyndEntry entry: entryList){
                        List<SyndCategory> cats = entry.getCategories();
                        SyndCategory syndCategory = new SyndCategoryImpl();
                        syndCategory.setName(feedly.category.getCategory());
                        if(cats.size() > -1){
                            cats.add(0, syndCategory);
                        }else{
                            entry.setCategories(cats);
                        }
                    }
                    entries.addAll(entryList);
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

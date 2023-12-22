package com.leggett.rss;

import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
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
                List<List<Feed>> feeds = new Feeds().getFeeds();
                List<Element> headLinks = new ArrayList<>();
                List<Element> bodyLinks = new ArrayList<>();
                try {
                        for (List<Feed> feedListByCat : feeds) {
                                SyndFeed feed = new SyndFeedImpl();
                                feed.setFeedType("rss_2.0");
                                String category = feedListByCat.get(0).getCategory().get(0).getCategory();
                                String title = "TheDorey.com - " + category + " Feed";
                                feed.setStyleSheet("pretty-feed-v3.xsl");
                                feed.setTitle(title);
                                feed.setDescription(
                                                "An eclectic collection of feeds from around the web.");
                                feed.setAuthor("Derek Leggett");
                                feed.setLink("https://www.thedorey.com/" + category.replace(" ", "_") + ".xml");
                                for (Feed feedByCat : feedListByCat) {
                                        try {
                                                List<SyndEntry> entries = new ArrayList();
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
                                Element headLinkElement = new Element("link").attr("rel", "alternate")
                                                .attr("type", "application/rss+xml").attr("title", title)
                                                .attr("href", href);
                                headLinks.add(headLinkElement);
                                Element bodyLinkElement = new Element("div").addClass("col")
                                                .appendChild(new Element("a").attr("href", href).text(category)
                                                                .appendChild(new Element("img").attr("src",
                                                                                "Feed-icon.svg")
                                                                                .attr("alt", title)));
                                bodyLinks.add(bodyLinkElement);
                                output.output(feed, new File("./target/" + category.replace(" ", "_") + ".xml"));
                        }
                } catch (Exception ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                }
                new Utility().writeIndexHtml(headLinks, bodyLinks);
        }
}

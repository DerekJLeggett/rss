package com.leggett.rss;

import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.feed.synd.SyndImage;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@SpringBootApplication
public class RssApplication {

        public static void main(String[] args) {
                SpringApplication.run(RssApplication.class, args);
                List<List<Feed>> feeds = new Feeds().getFeeds();
                List<Element> headLinks = new ArrayList<>();
                List<Element> indexLinks = new ArrayList<>();
                Utility utility = new Utility();
                try {
                        for (List<Feed> feedListByCat : feeds) {
                                List<Element> categoryElements = new ArrayList<>();
                                SyndFeed feed = new SyndFeedImpl();
                                feed.setFeedType("rss_2.0");
                                String category = feedListByCat.get(0).getCategory().get(0).getCategory();
                                String title = "TheDorey.com - " + category + " Feed";
                                feed.setTitle(title);
                                feed.setDescription(
                                                "An eclectic collection of feeds from around the web for category: "
                                                                + category);
                                feed.setAuthor("Derek Leggett");
                                feed.setLink("https://www.thedorey.com/" + category.replace(" ", "_") + ".xml");
                                for (Feed feedByCat : feedListByCat) {
                                        try {
                                                List<SyndEntry> entries = new ArrayList<SyndEntry>();
                                                feed.setEntries(entries);
                                                SyndFeed inFeed = new SyndFeedInput()
                                                                .build(new XmlReader(new URL(feedByCat.url)));
                                                // Channel title, link, description
                                                categoryElements.add(new Element("a").attr("href", inFeed.getLink())
                                                                .attr("target", "_blank")
                                                                .text("Source: " + inFeed.getTitle()));
                                                categoryElements.add(new Element("h3").text(inFeed.getDescription()));
                                                SyndImage image = inFeed.getImage();
                                                if (image != null) {
                                                        categoryElements.add(new Element("img")
                                                                        .addClass("img-thumbnail").attr("src",
                                                                                        image.getUrl()));
                                                }

                                                System.out.println(feedByCat.url);
                                                List<SyndEntry> entryList = inFeed.getEntries();
                                                for (SyndEntry entry : entryList) {
                                                        categoryElements.add(
                                                                        new Element("a").attr("style", "font-weight:bold").attr("href", entry.getLink())
                                                                                        .attr("target", "_blank")
                                                                                        .text(entry.getTitle()));
                                                        if (entry.getDescription().getType().toString()
                                                                        .contains("html")) {
                                                                categoryElements.add(new Element("h3").html(
                                                                                entry.getDescription().getValue()));
                                                        } else {
                                                                categoryElements.add(new Element("h3").text(
                                                                                entry.getDescription().getValue()));
                                                        }
                                                        List<SyndEnclosure> enclosures = entry.getEnclosures();
                                                        if (enclosures != null) {
                                                                for (SyndEnclosure enclosure : enclosures) {
                                                                        System.out.println(
                                                                                        "Type: " + enclosure.getType());
                                                                        System.out.println(
                                                                                        "URL: " + enclosure.getUrl());
                                                                        String enclosureType = enclosure.getType();
                                                                        String enclosureUrl = enclosure.getUrl();
                                                                        switch (enclosureType) {
                                                                                case "audio/mpeg":
                                                                                        categoryElements.add(
                                                                                                        new Element(
                                                                                                                        "audio")
                                                                                                                        .attr("controls",
                                                                                                                                        "")
                                                                                                                        .attr("type", enclosureType)
                                                                                                                        .attr("src", enclosureUrl));
                                                                                        break;
                                                                                case "image/jpeg":
                                                                                        categoryElements.add(
                                                                                                        new Element(
                                                                                                                        "img")
                                                                                                                        .addClass("img-fluid")
                                                                                                                        .attr("src", enclosureUrl));
                                                                                        break;
                                                                        }
                                                                }

                                                        }
                                                }
                                                entries.addAll(entryList);
                                                utility.writeCategoryHtml(category, categoryElements);
                                        } catch (Exception e) {
                                                System.out.println("ERROR: " + e.getMessage());
                                        }
                                }
                                SyndFeedOutput output = new SyndFeedOutput();
                                String href = category.replace(" ", "_") + ".html";
                                Element headLinkElement = new Element("link").attr("rel", "alternate")
                                                .attr("type", "application/rss+xml").attr("title", title)
                                                .attr("href", href);
                                headLinks.add(headLinkElement);
                                Element indexLinkElement = new Element("div").addClass("col")
                                                .appendChild(new Element("a").attr("style", "font-weight:bold").attr("href", href).text(category));
                                indexLinks.add(indexLinkElement);
                                output.output(feed, new File("./target/" + category.replace(" ", "_") + ".xml"));
                        }
                } catch (Exception ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                }
                utility.writeIndexHtml(headLinks, indexLinks);
        }
}

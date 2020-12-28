package com.leggett.rss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.net.URL;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
@SpringBootApplication
public class RssApplication {

	public static void main(String[] args) {
		SpringApplication.run(RssApplication.class, args);
		boolean ok = false;
        if (args.length>=2) {
            try {
                SyndFeed feed = new SyndFeedImpl();
                feed.setFeedType("rss_2.0");

                feed.setTitle("Aggregated " + StringUtils.capitalize(args[0]) + " Feed");
                feed.setDescription(feed.getTitle());
                feed.setAuthor("Derek Leggett");
                feed.setLink("https://www.thedorey.com/assets/rss/" + args[0] + ".xml");

                List entries = new ArrayList();
                feed.setEntries(entries);

                for (int i=1;i<args.length;i++) {
                    URL inputUrl = new URL(args[i]);

                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed inFeed = input.build(new XmlReader(inputUrl));

                    entries.addAll(inFeed.getEntries());

                }

                SyndFeedOutput output = new SyndFeedOutput();
                output.output(feed,new File(args[0] + ".xml"));

                ok = true;
            }
            catch (Exception ex) {
                System.out.println("ERROR: "+ex.getMessage());
            }
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

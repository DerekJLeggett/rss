package com.leggett.rss;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedOutput;

public class MainFeed {
    private static final DateFormat DATE_PARSER = new SimpleDateFormat("yyyy-MM-dd");

    public static void buildMainFeed() {
        boolean ok = false;
            try {
                SyndFeed feed = new SyndFeedImpl();
                feed.setFeedType("rss_2.0");

                feed.setTitle("Aggredated Feed (created with ROME)");
                feed.setLink("https://www.thedorey.com");
                feed.setDescription("This feed has been created using ROME (Java syndication utilities");

                List entries = new ArrayList();
                SyndEntry entry;
                SyndContent description;
                //Read xml files from the local directory
                // This filter will only include files ending with .xml
                FilenameFilter filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File f, String name) {
                        return name.endsWith(".xml") && !name.startsWith("pom") && !name.startsWith("rss");
                    }
                };
                String[] feedFiles;
                File file = new File(".");
                feedFiles = file.list(filter);
                for(String feedFileName: feedFiles){
                    entry = new SyndEntryImpl();
                    entry.setTitle("Aggregated " + StringUtils.capitalize(feedFileName.replace(",xml", "")) + " Feed");
                    entry.setLink("https://www.thedorey.com/" + feedFileName);
                    entry.setPublishedDate(new Date());
                    description = new SyndContentImpl();
                    description.setType("text/plain");
                    description.setValue(entry.getTitle());
                    entry.setDescription(description);
                    entries.add(entry);
                }

                feed.setEntries(entries);

                Writer writer = new FileWriter("rss.xml");
                SyndFeedOutput output = new SyndFeedOutput();
                output.output(feed,writer);
                writer.close();

                System.out.println("The feed has been written to the file [rss.xml]");

                ok = true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ERROR: "+ex.getMessage());
            }

        if (!ok) {
            System.out.println();
            System.out.println("FeedWriter creates a RSS/Atom feed and writes it to a file.");
            System.out.println("The first parameter must be the syndication format for the feed");
            System.out.println("  (rss_0.90, rss_0.91, rss_0.92, rss_0.93, rss_0.94, rss_1.0 rss_2.0 or atom_0.3)");
            System.out.println("The second parameter must be the file name for the feed");
            System.out.println();
        }
    }
}
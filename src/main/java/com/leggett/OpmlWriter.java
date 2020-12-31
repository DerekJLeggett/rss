package com.leggett;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.rometools.opml.feed.opml.Opml;
import com.rometools.opml.feed.opml.Outline;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.WireFeedInput;

public class OpmlWriter {
    public void writeOpml() throws FileNotFoundException, IllegalArgumentException, IOException, FeedException {
        WireFeedInput input = new WireFeedInput();
        Opml feed = (Opml) input.build( new File("feeds.xml") );
        List<Outline> outlines = (List<Outline>) feed.getOutlines();
    }
}

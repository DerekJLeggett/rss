package com.leggett.rss;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Utility {
    public void writeIndexHtml(List<Element> headLinks, List<Element> bodyLinks) {
        Document doc = Jsoup.parse("<html lang=\"en\"></html>");
        doc.head().append("<meta charset=\"utf-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                + "<title>TheDorey</title>"
                + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
        for (Element headLink : headLinks) {
            doc.head().appendChild(headLink);
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
        try {
            FileUtils.writeStringToFile(htmlFile, doc.outerHtml(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(doc.toString());
    }
}

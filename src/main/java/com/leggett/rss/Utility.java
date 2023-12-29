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
        Element row = new Element("div").addClass("row");
        row.appendChild(new Element("a").text("Open Arena game server hosted on this domain")
                .attr("href", "http://www.openarena.ws/").attr("target", "_blank"));
        row.appendChild(new Element("a").text("You can download the game client here").attr("href",
                "https://thedorey.com/openarena-0.8.8-repack.zip"));
        row.appendChild(new Element("h1").text("Aggregated RSS feeds by category")
                .addClass("text-center"));
        for (Element bodyLink : bodyLinks) {
            row.appendChild(bodyLink);
        }
        container.appendChild(row);
        doc.body().appendChild(container);
        File htmlFile = new File("./target/index.html");
        try {
            FileUtils.writeStringToFile(htmlFile, doc.outerHtml(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void writeCategoryHtml(String category, List<Element> categoryElements) {
        Document doc = Jsoup.parse("<html lang=\"en\"></html>");
        doc.head().append("<meta charset=\"utf-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                + "<title>TheDorey</title>"
                + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
        Element container = new Element("div").addClass("container-fluid text-center");
        Element row = new Element("div").addClass("row");
        row.appendChild(new Element("h1").text(category)
                .addClass("text-center"));
        container.appendChild(row);
        for (Element categoryElement : categoryElements) {
            Element categoryRow = new Element("div").addClass("row").addClass("text-center");
            categoryRow.appendChild(categoryElement.addClass("text-center"));
            container.appendChild(categoryRow);
        }
        doc.body().appendChild(container);
        File htmlFile = new File("./target/" + category.replace(" ", "_") + ".html");
        try {
            FileUtils.writeStringToFile(htmlFile, doc.outerHtml(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

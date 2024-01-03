package com.leggett.rss;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
        container.appendChild(row);
        Collections.sort(bodyLinks, (o1, o2) -> (o1.text().compareTo(o2.text())));
        for (Element bodyLink : bodyLinks) {
            Element indexRow = new Element("div").addClass("row").addClass("text-center");
            indexRow.appendChild(bodyLink.addClass("text-center"));
            container.appendChild(indexRow);
        }

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
                + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">"
                + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>");
        Element container = new Element("div").addClass("container-fluid text-center");
        container.appendChild(new Element("h1").text(category)
                .addClass("text-center"));
        Element accordian = new Element("div").addClass("accordian text-center").id("myAccordian");
        Element accordianItem = null;
        Element accordianBody = null;
        Element accordianCollapse = null;
        for (Element categoryElement : categoryElements) {
            if (categoryElement.hasClass("channel")) {
                String generatedString = RandomStringUtils.random(5, true, false);
                accordianItem = new Element("div").addClass("accordion-item text-center")
                        .appendChild(new Element("h2").addClass("accordion-header text-center")
                                .appendChild(new Element("button").addClass("accordion-button  d-block text-center btn btn-primary btn-lg")
                                        .attr("type", "button")
                                        .attr("data-bs-toggle", "collapse")
                                        .attr("data-bs-target", "#" + generatedString)
                                        .attr("aria-expanded", "true").attr("aria-controls", "collapseOne")
                                        .text(categoryElement.text())));
                accordianCollapse = new Element("div").id(generatedString)
                        .addClass("accordion-collapse collapse").attr("data-bs-parent", "#myAccordian");
                accordianBody = new Element("div").addClass("accordion-body");
                accordianCollapse.appendChild(accordianBody);
                accordianItem.appendChild(accordianCollapse);
            } else {
                accordianBody.appendChild(new Element("div").addClass("row text-center").appendChild(new Element("div")
                        .addClass("col text-center").appendChild(categoryElement).addClass("text-center")));
            }
            accordian.appendChild(accordianItem);
        }

        container.appendChild(accordian);
        doc.body().appendChild(container);
        File htmlFile = new File("./target/" + category.replace(" ", "_") + ".html");
        try {
            FileUtils.writeStringToFile(htmlFile, doc.outerHtml(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

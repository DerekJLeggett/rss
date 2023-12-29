package com.leggett.rss;

import java.util.List;

public class Feed {

    List<Categories> categories;
    String url;

    public enum Categories {
        ENTERTAINMENT("Entertainment"), NEWS("News"), EDUCATION("Education"), SCIENCE("Science"), NATURE("Nature"),
        SPACE("Space"), TECHNOLOGY("Technology"), PBS("PBS"), SPORTS("Sports"), BOXING("Boxing"),
        COLLEGE_BASKETBALL("College Basketball"), BASEBALL("Baseball"), CELEBRITY("Celebrity"), PHOTOS("Photos"),
        MUSIC("Music"), MOVIES("Movies"), PC_VIDEO_GAMES("PC Video Games"), CONSOLE_VIDEO_GAMES("Console Video Games"), AUTOMOTIVE("Automotive"),
        MEDICAL("Medical"), LIBRARY("Library"), FASHION("Fashion"), LIFESTYLE("Lifestyle"),
        NATIONAL_PARKS("National Parks"), WEB_DEV("Web Development"), COMEDY("Comedy"), DOCUMENTARY("Documentary"),
        RACE("Race"), CRIME("Crime"), HUMANITY("Humanity"), MILITARY("Military"), NAVY("Navy"), VETERANS("Veterans"),
        RUSSIA("Russia"), GOVERNMENT("Government"), FITNESS("Fitness"), METAL_FABRICATION("Metal Fabrication"), RECIPES("Recipes"), OUTDOORS("Outdoors");

        private final String name;

        private Categories(String s) {
            name = s;
        }

        public String getCategory() {
            return this.name;
        }
    }

    public Feed(List<Categories> categories, String url) {
        this.categories = categories;
        this.url = url;
    }

    public List<Categories> getCategory() {
        return categories;
    }

    public void setCategory(List<Categories> categories) {
        this.categories = categories;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

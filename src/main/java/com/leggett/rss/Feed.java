package com.leggett.rss;

public class Feed {

    Categories category;
    String url;

    public enum Categories {
        ENTERTAINMENT("Entertainment"), NEWS("News"), EDUCATION("Education"), SCIENCE("Science"), NATURE("Nature"),
        SPACE("Space"), TECHNOLOGY("Technology"), PBS("PBS"), SPORTS("Sports"), BOXING("Boxing"),
        COLLEGE_BASKETBALL("College Basketball"), BASEBALL("Baseball"), CELEBRITY("Celebrity"), PHOTOS("Photos"),
        MUSIC("Music"), MOVIES("Movies"), PC_VIDEO_GAMES("PC Video Games"), AUTOMOTIVE("Automotive"),
        MEDICAL("Medical"), LIBRARY("Library"), FASHION("Fashion"), LIFESTYLE("Lifestyle"),
        NATIONAL_PARKS("National Parks"), WEB_DEV("Web Devlopment"), COMEDY("Comedy"), DOCUMENTARY("Documentary"),
        RACE("Race"), CRIME("Crime"), HUMANITY("Humanity"), MILITARY("Military"), NAVY("Navy"), VETERANS("Veterans"),
        RUSSIA("Russia");

        private final String name;

        private Categories(String s) {
            name = s;
        }

        public String getCategory() {
            return this.name;
        }
    }

    public Feed(Categories category, String url) {
        this.category = category;
        this.url = url;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

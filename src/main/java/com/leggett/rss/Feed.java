package com.leggett.rss;

public class Feed {
    Categories category;
    String url;

    public enum Categories{
        entertainment
        , news
        , education
        , science
        , nature
        , space
        , technology
        , pbs
        , sports
        , boxing
        , college_basketball
        , baseball
        , celebrity
        , photos
        , music
        , movies
        , pc_video_games
        , automotive
        , medical
        , library
        , fashion
        , lifestyle
        , national_parks
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

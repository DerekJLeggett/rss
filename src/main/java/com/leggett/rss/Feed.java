package com.leggett.rss;

public class Feed {
    Categories category;
    String url;

    public enum Categories{
        entertainment
        , news
        , education
        , science
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

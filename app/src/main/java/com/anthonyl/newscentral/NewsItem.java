package com.anthonyl.newscentral;

public class NewsItem {

    private String title;
    private String body;
    private String image;

    public NewsItem(String title, String body, String image) {
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getBodyPreview() {
        if(body.length() > 20)
            return body.substring(0, 100)+"...";
        else
            return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

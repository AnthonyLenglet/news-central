package com.anthonyl.newscentral;

import android.content.Context;

public class NewsItem {

    private Context context;

    private String url;
    private String title;
    private String article_info;
    private String body;
    private String image;

    public NewsItem(Context context, String url, String title, String article_info, String body, String image) {
        this.context = context;
        this.url = url;
        this.title = title;
        this.article_info = article_info;
        this.body = body;
        this.image = image;
    }

    public Context getContext() {
        return context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleInfo() {
        return article_info;
    }

    public void setArticleInfo(String article_info) {
        this.article_info = article_info;
    }

    public String getBody() {
        return body;
    }

    public String getBodyPreview() {
        if(body.length() > 100)
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

package com.codeup.springblog.model;

public class Post {
    private String title;
    private String body;

    public Post() {}

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}

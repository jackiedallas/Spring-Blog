package com.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String body;

    public Post() {}

    public Long getId() {
        return id;
    }

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
    public Post (String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }
}

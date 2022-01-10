package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String body;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    public Post(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setBody(String body) {
        this.body = body;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}

package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(length = 50, nullable = false)
    private String make;

    @Column(length = 50, nullable = false)
    private String model;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

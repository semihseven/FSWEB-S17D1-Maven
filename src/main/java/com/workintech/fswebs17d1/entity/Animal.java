package com.workintech.fswebs17d1.entity;

public class Animal {

    private Integer id;
    private String name;


    public Animal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

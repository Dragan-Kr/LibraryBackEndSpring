package com.example.demo.dto;

import com.example.demo.jpa.Genre;

public class GenreDTO {
    private Integer id;

    private String name;

    public GenreDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name=genre.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

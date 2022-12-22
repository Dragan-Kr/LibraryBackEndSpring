package com.example.demo.dto;

import com.example.demo.jpa.Author;
import com.example.demo.jpa.Book;
import com.example.demo.jpa.Genre;

public class BookDTO {

    private Integer id;

    private String name;

    private Author author;

    private Genre genre;

    public BookDTO(Integer id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public BookDTO(Book book) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

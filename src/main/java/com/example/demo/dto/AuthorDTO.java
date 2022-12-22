package com.example.demo.dto;

import com.example.demo.jpa.Author;

public class AuthorDTO {
    private Integer id;

    private String name;

    private String surname;

    public AuthorDTO(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public  AuthorDTO(){

    }
//    public AuthorDTO(Author author) {
//
//    }


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

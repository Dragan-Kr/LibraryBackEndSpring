package com.example.demo.service;

import com.example.demo.jpa.Author;

import java.util.Collection;

public interface AuthorService {

    Collection<Author> findAllObjects();

    Author getObjectById(Integer id);

    boolean existsObjectById(Integer id);

    void saveObject(Author author);

    void deleteObjectById(Integer id);

    Collection<Author> getObjectByName(String name);

    Collection<Author> getObjectBySurname(String surname);

    Author save(Author author);
}
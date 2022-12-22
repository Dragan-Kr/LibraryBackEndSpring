package com.example.demo.service;

import com.example.demo.jpa.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> findAllObjects();

    Book getObjectById(Integer id);

    Book getObjectByName(String name);

    boolean existsObjectById(Integer id);

    void saveObject(Book book);

    void deleteObjectById(Integer id);

    Book save(Book book);
}

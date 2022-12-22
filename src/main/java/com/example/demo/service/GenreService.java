package com.example.demo.service;

import com.example.demo.jpa.Genre;

import java.util.Collection;

public interface GenreService {
    Collection<Genre> findAllObjects();

    Genre getObjectById(Integer id);

    boolean existsObjectById(Integer id);

    void saveObject(Genre genre);

    void deleteObjectById(Integer id);

    Collection<Genre> getObjectByName(String name);

    Genre save(Genre genre);
}

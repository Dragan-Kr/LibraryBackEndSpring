package com.example.demo.service;

import com.example.demo.jpa.Reader;

import java.math.BigDecimal;
import java.util.Collection;

public interface ReaderService {
    Collection<Reader> findAllObjects();

    Reader getObjectById(Integer id);



    Reader getObjectByContact(BigDecimal contact);

    boolean existsObjectById(Integer id);

    void saveObject(Reader reader);

    void deleteObjectById(Integer id);

    Collection<Reader> getObjectByNameContainingIgnoreCase(String name);

    Collection<Reader> getObjectBySurnameContainingIgnoreCase(String surname);

    Reader save(Reader reader);
}

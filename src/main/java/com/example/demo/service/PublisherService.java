package com.example.demo.service;

import com.example.demo.jpa.Publisher;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

public interface PublisherService {
    Collection<Publisher> findAllObjects();

    Publisher getObjectById(Integer id);

   

    Publisher getObjectByContact(BigDecimal contact);

    boolean existsObjectById(Integer id);

    void saveObject(Publisher publisher);

    void deleteObjectById(Integer id);

    Collection<Publisher> getObjectByAddressContainingIgnoreCase(String address);

    Collection<Publisher> getObjectByName(String name);

    boolean doesExistByContact(Integer contact);
    Optional<Publisher>findByContactOptional(Integer contact);

    Publisher save1(Publisher publisher);
}

package com.example.demo.service;

import com.example.demo.jpa.Rent;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;

public interface RentService {
    Collection<Rent> findAllObjects();

    Rent getObjectById(Integer id);

    boolean existsObjectById(Integer id);

    void saveObject(Rent rent);

    void deleteObjectById(Integer id);

    Rent save1(Rent rent);

    // Collection<Rent> getObjectByRentDate(ZonedDateTime rentdate);
}

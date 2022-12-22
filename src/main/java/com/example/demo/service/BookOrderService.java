package com.example.demo.service;

import com.example.demo.jpa.BookOrder;

import java.util.Collection;
import java.util.Date;

public interface BookOrderService {
    Collection<BookOrder> findAllObjects();

    BookOrder getObjectById(Integer id);

    boolean existsObjectById(Integer id);

    BookOrder saveObject(BookOrder bookOrder);

    void deleteObjectById(Integer id);

    // Collection<BookOrder> getObjectByDat(Date orderdat);
}

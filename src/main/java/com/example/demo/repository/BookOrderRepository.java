package com.example.demo.repository;

import com.example.demo.jpa.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {


    //Collection<BookOrder> getObjectByDat(Date orderdat);
}

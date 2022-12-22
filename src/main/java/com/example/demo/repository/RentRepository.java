package com.example.demo.repository;


import com.example.demo.jpa.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {

    //Collection<Rent> getObjectByRentDateAfter(ZonedDateTime rentdate);
}

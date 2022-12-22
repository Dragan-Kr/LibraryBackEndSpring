package com.example.demo.repository;

import com.example.demo.jpa.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Integer> {


    Reader getObjectByContact(BigDecimal contact);

    Collection<Reader> getObjectByNameContainingIgnoreCase(String name);

    Collection<Reader> getObjectBySurnameContainingIgnoreCase(String surname);
}

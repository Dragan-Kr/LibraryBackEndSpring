package com.example.demo.repository;

import com.example.demo.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
   

    Publisher getObjectByContact(BigDecimal contact);

    Collection<Publisher> getObjectByAddressContainingIgnoreCase(String address);

    Collection<Publisher> getObjectByNameContainingIgnoreCase(String name);

    Optional<Publisher> findAllByContact(Integer contact);
}

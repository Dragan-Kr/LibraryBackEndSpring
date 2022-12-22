package com.example.demo.repository;

import com.example.demo.jpa.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {


    Collection<Author> getObjectByNameContainingIgnoreCase(String name);

    Collection<Author> getObjectBySurnameContainingIgnoreCase(String surname);
}

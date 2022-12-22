package com.example.demo.repository;


import com.example.demo.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book getObjectByNameContainingIgnoreCase(String name);
}

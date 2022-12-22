package com.example.demo.repository;

import com.example.demo.jpa.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Collection<Genre> getObjectByNameContainingIgnoreCase(String name);
}

package com.example.demo.implem;

import com.example.demo.jpa.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthorServiceImplem implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Collection<Author> findAllObjects() {
        return authorRepository.findAll();
    }

    @Override
    public Author getObjectById(Integer id) {
        return authorRepository.getOne(id);
    }



    @Override
    public boolean existsObjectById(Integer id) {
        return authorRepository.existsById(id);
    }

    @Override
    public void saveObject(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteObjectById(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Collection<Author> getObjectByName(String name) {
        return authorRepository.getObjectByNameContainingIgnoreCase(name);
    }

    @Override
    public Collection<Author> getObjectBySurname(String surname) {
        return authorRepository.getObjectBySurnameContainingIgnoreCase(surname);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }


}

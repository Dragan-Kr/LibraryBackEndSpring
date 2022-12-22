package com.example.demo.implem;


import com.example.demo.jpa.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceImplem implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Collection<Book> findAllObjects() {
        return bookRepository.findAll();
    }

    @Override
    public Book getObjectById(Integer id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book getObjectByName(String name) {
        return bookRepository.getObjectByNameContainingIgnoreCase(name);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return bookRepository.existsById(id);
    }

    @Override
    public void saveObject(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteObjectById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}

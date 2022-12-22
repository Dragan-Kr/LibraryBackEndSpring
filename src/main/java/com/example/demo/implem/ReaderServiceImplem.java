package com.example.demo.implem;

import com.example.demo.jpa.Reader;
import com.example.demo.repository.ReaderRepository;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class ReaderServiceImplem implements ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public Collection<Reader> findAllObjects() {
        return readerRepository.findAll();
    }

    @Override
    public Reader getObjectById(Integer id) {
        return readerRepository.getOne(id);
    }


    @Override
    public Reader getObjectByContact(BigDecimal contact) {
        return readerRepository.getObjectByContact(contact);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return readerRepository.existsById(id);
    }

    @Override
    public void saveObject(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public void deleteObjectById(Integer id) {
        readerRepository.deleteById(id);
    }

    @Override
    public Collection<Reader> getObjectByNameContainingIgnoreCase(String name) {
        return readerRepository.getObjectByNameContainingIgnoreCase(name);
    }

    @Override
    public Collection<Reader> getObjectBySurnameContainingIgnoreCase(String surname) {
        return readerRepository.getObjectBySurnameContainingIgnoreCase(surname);
    }

    @Override
    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }
}

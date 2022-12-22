package com.example.demo.implem;

import com.example.demo.jpa.Publisher;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Service
public class PublisherServiceImplem implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Collection<Publisher> findAllObjects() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getObjectById(Integer id) {
        return publisherRepository.getOne(id);
    }



    @Override
    public Publisher getObjectByContact(BigDecimal contact) {
        return publisherRepository.getObjectByContact(contact);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return publisherRepository.existsById(id);
    }

    @Override
    public void saveObject(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void deleteObjectById(Integer id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Collection<Publisher> getObjectByAddressContainingIgnoreCase(String address) {
        return publisherRepository.getObjectByAddressContainingIgnoreCase(address);
    }

    @Override
    public Collection<Publisher> getObjectByName(String name) {
        return publisherRepository.getObjectByNameContainingIgnoreCase(name);
    }

    @Override
    public boolean doesExistByContact(Integer contact) {
        return findByContactOptional(contact).isPresent();
    }

    @Override
    public Optional<Publisher> findByContactOptional(Integer contact) {
        return publisherRepository.findAllByContact(contact);
    }

    @Override
    public Publisher save1(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}

package com.example.demo.ctrs;


import com.example.demo.dto.PublisherDTO;
import com.example.demo.jpa.Publisher;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class  PublisherRestController {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("publisher")
    public Collection<Publisher>getPublishers(){
        return publisherService.findAllObjects();
    }

    @GetMapping("publisher/{id}")
    public Publisher getPublisherById(@PathVariable("id") Integer id){
        return publisherService.getObjectById(id);
    }

    @GetMapping("publiser/address/{address}")
    public Collection<Publisher> getPublisherByAdress(@PathVariable("address") String address){
        return publisherService.getObjectByAddressContainingIgnoreCase(address);
    }

    @GetMapping("publisher/name/{name}")
    public Collection<Publisher> getPublisherByName(@PathVariable("name") String name){
        return publisherService.getObjectByName(name);
    }


    @GetMapping("publisher/contact/{contact}")
    public Publisher getPublisherByContact(@PathVariable("contact") BigDecimal contact){
        return publisherService.getObjectByContact(contact);
    }

    @PostMapping("publisher")
    public ResponseEntity<Publisher> insertPublisher(@RequestBody PublisherDTO publisherDTO){
        Publisher publisher =new Publisher();

        publisher.setId(publisherDTO.getId());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setContact(publisherDTO.getContact());
        publisher.setName(publisherDTO.getName());

        publisherService.saveObject(publisher);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @PutMapping("publisher/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Integer id,@RequestBody PublisherDTO publisherDTO){
       Publisher publisher = publisherService.getObjectById(id);

//        publisher.setId(publisherDTO.getId());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setContact(publisherDTO.getContact());
        publisher.setName(publisherDTO.getName());

        Publisher updated = publisherService.save1(publisher);
        return ResponseEntity.ok(updated);

    }

    @Transactional
    @DeleteMapping("publisher/{id}")
    public ResponseEntity<Publisher> deletePublisher(@PathVariable("id") Integer id){
        if(!publisherService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete from book_order where publisherid =" +id);
            publisherService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}

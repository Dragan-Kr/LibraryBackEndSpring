package com.example.demo.ctrs;

import com.example.demo.dto.ReaderDTO;
import com.example.demo.jpa.Reader;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReaderRestController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("reader")
    public Collection<Reader> getReaders(){
        return readerService.findAllObjects();
    }

    @GetMapping("reader/{id}")
    public Reader getReaderById(@PathVariable("id") Integer id){
        return readerService.getObjectById(id);
    }

    @GetMapping("reader/name/{name}")
    public Collection<Reader> getReaderByName(@PathVariable("name") String name){
        return readerService.getObjectByNameContainingIgnoreCase(name);
    }

    @GetMapping("reader/surname/{surname}")
    public Collection<Reader> getReaderBySurname(@PathVariable("surname") String surname){
        return readerService.getObjectBySurnameContainingIgnoreCase(surname);
    }


    @GetMapping("reader/contact/{contact}")
    public Reader getReaderByContact(@PathVariable("contact") BigDecimal contact){
        return readerService.getObjectByContact(contact);
    }

    /*@PostMapping("reader")
    public ResponseEntity<Reader>  insertReader(@RequestBody Reader reader){
        if(!readerService.existsObjectById(reader.getId())){
            readerService.saveObject(reader);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
    }

     */


    @PostMapping("reader")
    public ResponseEntity<ReaderDTO>addReader(@RequestBody ReaderDTO readerDTO){
        Reader reader = new Reader();
        reader.setId(readerDTO.getId());
        reader.setName(readerDTO.getName());
//        try {
//            if (readerDTO.getName() == null) {
//                throw new NullPointerException("please insert name");
//            } else {
//                reader.setName(readerDTO.getName());
//            }
//        }
//        catch (NullPointerException e){
//            e.printStackTrace();
//
//        }
        reader.setSurname(readerDTO.getSurname());
        reader.setJmbg(readerDTO.getJmbg());
        reader.setAddress(readerDTO.getAddress());
        reader.setContact(readerDTO.getContact());

        reader = readerService.save(reader);
        return new ResponseEntity<>(new ReaderDTO(reader),HttpStatus.CREATED);
    }

    @PutMapping("reader/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable("id") Integer id,@RequestBody ReaderDTO readerDTO){
        Reader reader = readerService.getObjectById(id);

        reader.setName(readerDTO.getName());
        reader.setSurname(readerDTO.getSurname());
        reader.setJmbg(readerDTO.getJmbg());
        reader.setAddress(readerDTO.getAddress());
        reader.setContact(readerDTO.getContact());

        Reader updated = readerService.save(reader);
        return ResponseEntity.ok(updated);

    }
    @Transactional
    @DeleteMapping("reader/{id}")
    public ResponseEntity<Reader> deleteReader(@PathVariable("id") Integer id){
        if(!readerService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            jdbcTemplate.execute("delete from membership_card where readerid =" + id);
            readerService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}

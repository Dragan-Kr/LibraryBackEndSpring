package com.example.demo.ctrs;

import com.example.demo.dto.RentDTO;
import com.example.demo.jpa.Rent;
import com.example.demo.repository.RentRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.MembershipCardService;
import com.example.demo.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RentRestController {

    @Autowired
    private RentService rentService;


    @Autowired
    private BookService bookService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MembershipCardService membershipCardService;


    @GetMapping("rent")
    public Collection<Rent> getRents(){
        return rentService.findAllObjects();
    }

    @GetMapping("rent/{id}")
    public Rent getRentById(@PathVariable("id") Integer id){
        return rentService.getObjectById(id);
    }
    /*
    @GetMapping("rent/rentdate/{rentdate}")
    public Collection<Rent> getRentByDateA(@PathVariable("rentdate") ZonedDateTime rentdate){
        return rentService.getObjectByRentDate(rentdate);
    }

     */


    @PostMapping("rent")
    public ResponseEntity<Rent> insertRent(@RequestBody RentDTO rentDTO){
        Rent rent = new Rent();

        rent.setId(rentDTO.getId());
        rent.setRentdate(rentDTO.getRentdate());
        rent.setReturndate(rentDTO.getReturndate());
        rent.setBook(bookService.getObjectById(rentDTO.getBookid()));
        rent.setEmployee(employeeService.getObjectById(rentDTO.getEmpid()));
        rent.setMembershipCard(membershipCardService.getObjectById(rentDTO.getMemcardid()));

        rentService.saveObject(rent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("rent/{id}")
    public ResponseEntity<Rent>updateRent(@PathVariable("id") Integer id,@RequestBody RentDTO rentDTO){
       Rent rent = rentService.getObjectById(id);

//        rent.setId(rentDTO.getId());
        rent.setRentdate(rentDTO.getRentdate());
        rent.setReturndate(rentDTO.getReturndate());
        rent.setBook(bookService.getObjectById(rentDTO.getBookid()));
        rent.setEmployee(employeeService.getObjectById(rentDTO.getEmpid()));
        rent.setMembershipCard(membershipCardService.getObjectById(rentDTO.getMemcardid()));

        Rent updated = rentService.save1(rent);
        return ResponseEntity.ok(updated);

    }
    @DeleteMapping("rent/{id}")
    public ResponseEntity<Rent>deleteRent(@PathVariable("id") Integer id){
        if(!rentService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            rentService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}

package com.example.demo.ctrs;

import com.example.demo.dto.BookOrderPostDTO;
import com.example.demo.jpa.BookOrder;
import com.example.demo.jpa.Publisher;
import com.example.demo.service.BookOrderService;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookOrderRestController {
    @Autowired
    private BookOrderService bookOrderService;

    @Autowired
    private BookService bookService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PublisherService publisherService;


    @GetMapping("bookOrder")
    public Collection<BookOrder> getBookOrders(){
        return bookOrderService.findAllObjects();
    }

    @GetMapping("bookOrder/{id}")
    public BookOrder getBookOrderById(@PathVariable("id") Integer id){
        return bookOrderService.getObjectById(id);
    }

    /*@GetMapping("bookOrder/orderdat/{orderdat}")
    public Collection<BookOrder> getBookOrdersByDat(@PathVariable("orderdat") Date orderdat){
        return bookOrderService.getObjectByDat(orderdat);
    }
*/


    @PostMapping("bookOrder")
    public ResponseEntity insertBookOrder(@RequestBody BookOrderPostDTO bookOrderPostDTO){
        BookOrder bookOrder = new BookOrder();

        bookOrder.setId(bookOrderPostDTO.getId());
        bookOrder.setBooknum(bookOrderPostDTO.getBooknum());
        bookOrder.setOrderdat(bookOrderPostDTO.getOrderdat());
        bookOrder.setPaymenttype(bookOrderPostDTO.getPaymenttype());
        bookOrder.setBook(bookService.getObjectById(bookOrderPostDTO.getBookid()));
        bookOrder.setEmployee(employeeService.getObjectById(bookOrderPostDTO.getEmployeeid()));
        bookOrder.setPublisher(publisherService.getObjectById(bookOrderPostDTO.getPublisherid()));
        bookOrderService.saveObject(bookOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @PutMapping("bookOrder/{id}")
    public ResponseEntity<BookOrder> updateBookOrder(@PathVariable("id") Integer id,@RequestBody BookOrderPostDTO bookOrderPostDTO){
        BookOrder bookOrder = bookOrderService.getObjectById(id);
//        bookOrder.setId(bookOrderPostDTO.getId());
        bookOrder.setBooknum(bookOrderPostDTO.getBooknum());
        bookOrder.setOrderdat(bookOrderPostDTO.getOrderdat());
        bookOrder.setPaymenttype(bookOrderPostDTO.getPaymenttype());
        bookOrder.setBook(bookService.getObjectById(bookOrderPostDTO.getBookid()));
        bookOrder.setEmployee(employeeService.getObjectById(bookOrderPostDTO.getEmployeeid()));
        bookOrder.setPublisher(publisherService.getObjectById(bookOrderPostDTO.getPublisherid()));
        BookOrder updatedBookOrder = bookOrderService.saveObject(bookOrder);
        return ResponseEntity.ok(updatedBookOrder);
    }

    @DeleteMapping("bookOrder/{id}")
    public ResponseEntity<BookOrder> deleteBookOrder(@PathVariable("id") Integer id){
        if(!bookOrderService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            bookOrderService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}

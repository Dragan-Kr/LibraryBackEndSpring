package com.example.demo.ctrs;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.jpa.Employee;
import com.example.demo.jpa.Payment;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.MembershipCardService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaymentRestController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MembershipCardService membershipCardService;


    @GetMapping("payment")
    public Collection<Payment> getPayments(){
        return paymentService.findAllObjects();
    }

    @GetMapping("payment/{id}")
    public Payment getPaymentById(@PathVariable("id") Integer id){
        return paymentService.getObjectById(id);
    }

    @GetMapping("payment/amount/{amount}")
    public Collection<Payment> getPaymentByAmount(@PathVariable("amount") Integer amount){
        return paymentService.getObjectByAmount(amount);
    }

    @PostMapping("payment")
    public ResponseEntity<Payment> insertPayment(@RequestBody PaymentDTO paymentDTO){
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaydate(paymentDTO.getPaydate());
        payment.setEmployee(employeeService.getObjectById(paymentDTO.getEmployeeid()));
        payment.setMembershipCard(membershipCardService.getObjectById(paymentDTO.getMemcardid()));
        paymentService.saveObject(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("payment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") Integer id,@RequestBody PaymentDTO paymentDTO){
        Payment payment = paymentService.getObjectById(id);

        payment.setAmount(paymentDTO.getAmount());
        payment.setPaydate(paymentDTO.getPaydate());
        payment.setEmployee(employeeService.getObjectById(paymentDTO.getEmployeeid()));
        payment.setMembershipCard(membershipCardService.getObjectById(paymentDTO.getMemcardid()));

        Payment updated = paymentService.save1(payment);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("payment/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable("id") Integer id){
        if(!paymentService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            paymentService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

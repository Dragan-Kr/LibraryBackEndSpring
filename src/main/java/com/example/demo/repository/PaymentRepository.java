package com.example.demo.repository;


import com.example.demo.jpa.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Collection<Payment> getObjectByAmount(Integer amount);
}

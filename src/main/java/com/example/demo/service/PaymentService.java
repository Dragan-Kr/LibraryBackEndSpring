package com.example.demo.service;

import com.example.demo.jpa.Payment;

import java.util.Collection;

public interface PaymentService {
    Collection<Payment> findAllObjects();

    Payment getObjectById(Integer id);

    Collection<Payment> getObjectByAmount(Integer amount);

    boolean existsObjectById(Integer id);

    void saveObject(Payment payment);

    void deleteObjectById(Integer id);

    Payment save1(Payment payment);
}

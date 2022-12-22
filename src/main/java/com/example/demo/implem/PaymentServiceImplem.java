package com.example.demo.implem;

import com.example.demo.jpa.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PaymentServiceImplem implements PaymentService {


    @Autowired
    private  PaymentRepository paymentRepository;

    @Override
    public Collection<Payment> findAllObjects() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getObjectById(Integer id) {
        return paymentRepository.getOne(id);
    }

    @Override
    public Collection<Payment> getObjectByAmount(Integer amount) {
        return paymentRepository.getObjectByAmount(amount);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return paymentRepository.existsById(id);
    }

    @Override
    public void saveObject(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deleteObjectById(Integer id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment save1(Payment payment) {
        return paymentRepository.save(payment);
    }

}

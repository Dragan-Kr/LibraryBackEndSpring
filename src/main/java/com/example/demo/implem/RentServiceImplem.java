package com.example.demo.implem;

import com.example.demo.jpa.Rent;
import com.example.demo.repository.RentRepository;
import com.example.demo.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;

@Service
public class RentServiceImplem implements RentService {
    @Autowired
    private RentRepository rentRepository;

    @Override
    public Collection<Rent> findAllObjects() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getObjectById(Integer id) {
        return rentRepository.getOne(id);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return rentRepository.existsById(id);
    }

    @Override
    public void saveObject(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public void deleteObjectById(Integer id) {
        rentRepository.deleteById(id);
    }

    @Override
    public Rent save1(Rent rent) {
        return rentRepository.save(rent);
    }

   /* @Override
    public Collection<Rent> getObjectByRentDate(ZonedDateTime rentdate) {
        return rentRepository.getObjectByRentDateAfter(rentdate);
    }

    */
}

package com.example.demo.implem;

import com.example.demo.jpa.Employee;
import com.example.demo.repository.EmployeeCrudRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeServiceImplem  implements EmployeeService {

    @Autowired
    private EmployeeCrudRepository employeeRepository;

    @Autowired
    private  EmployeeRepository repository;
//
//    @Override
//    public Collection<Employee> findAllObjects() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee getObjectById(Integer id) {
//        return employeeRepository.getOne(id);
//    }
//
//    @Override
//    public Collection<Employee> getObjectByName(String name) {
//        return employeeRepository.getObjectByNameContainingIgnoreCase(name);
//    }

//    @Override
//    public Collection<Employee> getObjectBySurname(String surname) {
//        return employeeRepository.getObjectBySurnameContainingIgnoreCase(surname);
//    }
//
//    @Override
//    public Employee getObjectByContact(BigDecimal contact) {
//        return employeeRepository.getObjectByContact(contact);
//    }

//    @Override
//    public boolean existsObjectById(Integer id) {
//        return employeeRepository.existsById(id);
//    }

//    @Override
//    public void saveObject(Employee employee) {
//        employeeRepository.save(employee);
//    }

//    @Override
//    public void deleteObjectId(Integer id) {
//        employeeRepository.deleteById(id);
//    }
//
//    @Override
//    public   Optional<Employee> findByEmail(String name) {
//        return employeeRepository.findByEmail(name);
//    }
//
//    @Override
//    public Employee getByEmail(String name) {
//        return employeeRepository.getByEmail(name);
//    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

//    @Override
//    public Collection<Object> findByRole(String role) {
//        return employeeRepository.findByRole(role);
//    }

//    @Override
//    public Employee getPersonByUsername(String username) {
//        return employeeRepository.getUserByUsername(username);
//    }

//    @Override
//    public Employee save1(Employee employee) {
//        return employeeRepository.save(employee);
//    }


    @Override
    public Employee getPersonByUsername(String username) {
        return employeeRepository.getUserByUsername(username);
    }

    @Override
    public Employee getObjectById(Integer employeeid) {
        return employeeRepository.getObjectById(employeeid);
    }

    @Override
    public Employee saveObject(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Collection<Employee> findAllObjects() {
        return repository.findAll();
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteObjectById(Integer id) {
        repository.deleteById(id);
    }


}

package com.example.demo.service;

import com.example.demo.jpa.Employee;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
//    Collection<Employee> findAllObjects();
//
//    Employee getObjectById(Integer id);
//
//    Collection<Employee> getObjectByName(String name);
//
//    Collection<Employee> getObjectBySurname(String surname);
//
//    Employee getObjectByContact(BigDecimal contact);
//
//    boolean existsObjectById(Integer id);
//
//    void saveObject(Employee employee);
//
//    void deleteObjectId(Integer id);
//
//    Optional<Employee> findByEmail(String name);
//    Employee getByEmail(String name);

    void save(Employee employee);

//    Collection<Object> findByRole(String role);
//
    Employee getPersonByUsername(String username);

    Employee getObjectById(Integer employeeid);

    Employee saveObject(Employee employee);

    Collection<Employee> findAllObjects();

    boolean existsObjectById(Integer id);

    void deleteObjectById(Integer id);

//    Employee save1(Employee employee);

}

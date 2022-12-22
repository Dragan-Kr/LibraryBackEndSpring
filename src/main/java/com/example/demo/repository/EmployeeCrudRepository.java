package com.example.demo.repository;

import com.example.demo.jpa.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer>{

    @Query("SELECT e FROM Employee e WHERE e.username = :username")
    public Employee getUserByUsername(@Param("username") String username);

    Employee getObjectById(Integer employeeid);
}

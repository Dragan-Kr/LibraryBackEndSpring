package com.example.demo.repository;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Employee v SET v.enabled = true WHERE v.id = :id")
    void enable(@Param("id") Integer id);



    @Query("SELECT e FROM Employee e WHERE e.username = :username")
    public Employee getUserByUsername(@Param("username") String username);

    Employee getObjectByContact(BigDecimal contact);

    Collection<Employee> getObjectByNameContainingIgnoreCase(String name);

    Collection<Employee> getObjectBySurnameContainingIgnoreCase(String surname);

   // List<Employee> findAllByRole(String role);

    Optional<Employee> findByEmail(String email);

   // Collection<Object> findByRole(String role);

    Optional<Employee> findByVerificationCode(String code);

    Employee getByEmail(String name);


    boolean existsByEmail(String email);
}
    //  Collection<Object> findByRole(String role);
   // @Query("SELECT u FROM Employee u WHERE u.email = ?1")
  //  public Employee findByEmail(String email);}

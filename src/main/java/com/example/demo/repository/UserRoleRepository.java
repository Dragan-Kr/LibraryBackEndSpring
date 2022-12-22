package com.example.demo.repository;

import com.example.demo.jpa.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UsersRole,Integer> {
}

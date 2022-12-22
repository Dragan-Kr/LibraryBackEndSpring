package com.example.demo.service;

import com.example.demo.jpa.Employee;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface EmployeeDetails {
    Collection<? extends GrantedAuthority> getAuthorities();
    String getPassword();
    String getUsername();
    boolean isAccountNonExpired();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();
    String getFullName();
}

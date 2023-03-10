package com.example.demo.security;

import com.example.demo.jpa.Employee;
import com.example.demo.jpa.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {
    private Employee employee;

    public MyUserDetails(Employee employee){
        this.employee=employee;
    }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<com.example.demo.jpa.Role> roles = employee.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return null;
    }

    @Override
    public String getPassword() {

        return employee.getPassword();
    }

    @Override
    public String getUsername() {

        return employee.getUsername();    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        return employee.isEnabled();
    }
}

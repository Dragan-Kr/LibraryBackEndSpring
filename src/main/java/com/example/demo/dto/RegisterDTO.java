package com.example.demo.dto;

import java.math.BigDecimal;

public class RegisterDTO {

    private Integer id;

    private String address;

    private BigDecimal contact;

    private BigDecimal jbmg;

    private String name;

    private String password;

    private String surname;

    private String username;
    private String verificationCode;

    public RegisterDTO() {
    }

    private boolean enabled;


    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getContact() {
        return contact;
    }

    public void setContact(BigDecimal contact) {
        this.contact = contact;
    }

    public BigDecimal getJbmg() {
        return jbmg;
    }

    public void setJbmg(BigDecimal jbmg) {
        this.jbmg = jbmg;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.demo.dto;

import com.example.demo.jpa.Employee;

import java.math.BigDecimal;

public class EmployeeDTO {

    private Integer id;

    private String address;

    private BigDecimal contact;

    private BigDecimal jbmg;

    private String name;

    private String password;

    private String surname;

    private String username;

   // private String role;
    private Boolean enabled;

  //  private boolean firstLogin;
    private String email;
    private  String verificationCode;
    private Employee employee;

    public EmployeeDTO(Integer id, String address, BigDecimal contact, BigDecimal jbmg, String name, String password, String surname, String username, String email, String verificationCode) {
        this.id = id;
        this.address = address;
        this.contact = contact;
        this.jbmg = jbmg;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.username = username;

        //this.firstLogin = firstLogin;
        this.email=email;
        this.verificationCode=verificationCode;
        this.enabled = enabled;
    }

    public EmployeeDTO(Employee employee){
        this.id = employee.getId();
        this.address = employee.getAddress();
        this.contact = employee.getContact();
        this.jbmg = employee.getJbmg();
        this.name = employee.getName();
        this.password = employee.getPassword();
        this.surname = employee.getSurname();
        this.username = employee.getUsername();
//       // this.firstLogin = employee.isFirstLogin();
        this.email=employee.getEmail();
        this.verificationCode=employee.getVerificationCode();
        this.enabled = employee.isEnabled();
    }

    public EmployeeDTO(Object o) {
    }

    public EmployeeDTO() {

    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getContact() {
        return contact;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

}

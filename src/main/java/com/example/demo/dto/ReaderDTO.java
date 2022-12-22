package com.example.demo.dto;

import com.example.demo.jpa.Reader;

import java.math.BigDecimal;

public class ReaderDTO {

    private Integer id;

    private String address;

    private BigDecimal contact;

    private BigDecimal jmbg;

    private String name;

    private String surname;


    public ReaderDTO(Integer id, String address, BigDecimal contact, BigDecimal jmbg, String name, String surname) {
        this.id = id;
        this.address = address;
        this.contact = contact;
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
    }

    public ReaderDTO(Reader reader) {
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

    public BigDecimal getContact() {
        return contact;
    }

    public void setContact(BigDecimal contact) {
        this.contact = contact;
    }

    public BigDecimal getJmbg() {
        return jmbg;
    }

    public void setJmbg(BigDecimal jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

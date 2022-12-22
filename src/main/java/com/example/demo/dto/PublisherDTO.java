package com.example.demo.dto;

public class PublisherDTO {
    private Integer id;

    private String address;

    private Integer contact;

    private String name;


    public  PublisherDTO(){

    }

    public PublisherDTO(Integer id,String address,Integer contact,String name){
        this.id = id;
        this.address = address;
        this.contact = contact;
        this.name=name;
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

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

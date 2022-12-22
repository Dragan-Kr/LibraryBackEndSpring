package com.example.demo.dto;

import com.example.demo.jpa.Book;

import java.util.Date;

public class RentDTO {
    private Integer id;
    private Date rentdate;
    private Date returndate;
    private Integer bookid;
    private Integer empid;
    private Integer memcardid;


    public RentDTO(){

    }


    public RentDTO(Integer id,Date rentdate,Date returndate,Integer bookid,Integer empid,Integer memcardid){
        this.id=id;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.bookid = bookid;
        this.empid = empid;
        this.memcardid = memcardid;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRentdate() {
        return rentdate;
    }

    public void setRentdate(Date rentdate) {
        this.rentdate = rentdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getMemcardid() {
        return memcardid;
    }

    public void setMemcardid(Integer memcardid) {
        this.memcardid = memcardid;
    }
}

package com.example.demo.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class BookOrderPostDTO {

    private Integer id;

    private Integer booknum;

    private Date orderdat;

    private String paymenttype;

    private Integer bookid;
    private  Integer employeeid;
    private Integer publisherid;

    public BookOrderPostDTO(){

    }

    public BookOrderPostDTO(Integer id,Integer booknum,Date orderdat,String paymenttype,Integer bookid,Integer employeeid,Integer publisherid){
     this.id=id;
     this.booknum = booknum;
     this.orderdat = orderdat;
     this.paymenttype=paymenttype;
     this.bookid=bookid;
     this.employeeid=employeeid;
     this.publisherid = publisherid;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBooknum() {
        return booknum;
    }

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }

    public Date getOrderdat() {
        return orderdat;
    }

    public void setOrderdat(Date orderdat) {
        this.orderdat = orderdat;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }
}

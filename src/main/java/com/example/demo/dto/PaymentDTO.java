package com.example.demo.dto;

import java.util.Date;

public class PaymentDTO {

    private Integer id;

    private Integer amount;
    private Date paydate;
    private Integer employeeid;
    private Integer memcardid;


    public PaymentDTO(){

    }

    public PaymentDTO(Integer amount,Date paydate,Integer employeeid,Integer memcardid){
        this.amount = amount;
        this.paydate = paydate;
        this.employeeid = employeeid;
        this.memcardid = memcardid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getMemcardid() {
        return memcardid;
    }

    public void setMemcardid(Integer memcardid) {
        this.memcardid = memcardid;
    }
}

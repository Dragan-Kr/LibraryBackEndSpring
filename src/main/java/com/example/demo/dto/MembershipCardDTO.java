package com.example.demo.dto;

import java.util.Date;

public class MembershipCardDTO {

    private Integer id;
    private Date dateofissue;
    private Integer duration;
    private Integer employeeid;
    private Integer readerid;

    public MembershipCardDTO(){

    }
    public MembershipCardDTO(Integer id,Date dateofissue,Integer duration,Integer employeeid,Integer readerid){
     this.id = id;
     this.dateofissue = dateofissue;
     this.duration = duration;
     this.employeeid = employeeid;
     this.readerid = readerid;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(Date dateofissue) {
        this.dateofissue = dateofissue;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }
}

package com.cen.dubboapi.entity;

import java.io.Serializable;
import java.util.Date;

public class CreateFormCode implements Serializable {
    private int id;
    private String formtype;
    private String dept;
    private String serial;
    private int codeno;
    private Date datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormtype() {
        return formtype;
    }

    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getCodeno() {
        return codeno;
    }

    public void setCodeno(int codeno) {
        this.codeno = codeno;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}

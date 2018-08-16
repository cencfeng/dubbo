package com.cen.dubboapi.entity;

import java.io.Serializable;

public class Signorder implements Serializable {
    private int id;
    private String formtype;
    private String dept;
    private int signorder;
    private String signname;
    private String account;
    private String username;
    private char require;

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

    public int getSignorder() {
        return signorder;
    }

    public void setSignorder(int signorder) {
        this.signorder = signorder;
    }

    public String getSignname() {
        return signname;
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getRequire() {
        return require;
    }

    public void setRequire(char require) {
        this.require = require;
    }
}

package com.cen.dubboapi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Costform implements Serializable {
    private int id;
    private String formcode;
    private String dept;
    private String supplier;
    private String attn;
    private String delivery;
    private String originator;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creatime;
    private char signflag;
    private float totalprice;
    private String attaurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormcode() {
        return formcode;
    }

    public void setFormcode(String formcode) {
        this.formcode = formcode;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAttn() {
        return attn;
    }

    public void setAttn(String attn) {
        this.attn = attn;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public char getSignflag() {
        return signflag;
    }

    public void setSignflag(char signflag) {
        this.signflag = signflag;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public String getAttaurl() {
        return attaurl;
    }

    public void setAttaurl(String attaurl) {
        this.attaurl = attaurl;
    }
}

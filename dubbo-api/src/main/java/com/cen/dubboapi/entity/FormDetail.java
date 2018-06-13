package com.cen.dubboapi.entity;

import java.io.Serializable;

public class FormDetail implements Serializable {
    private int id;
    private String formcode;
    private int partno;
    private String description;
    private String quantity;
    private String unitprice;
    private String total;
    private String attourl;

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

    public int getPartno() {
        return partno;
    }

    public void setPartno(int partno) {
        this.partno = partno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAttourl() {
        return attourl;
    }

    public void setAttourl(String attourl) {
        this.attourl = attourl;
    }
}

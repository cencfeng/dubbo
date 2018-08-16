package com.cen.dubboapi.entity;

import java.io.Serializable;

public class Atta implements Serializable {
    private int id;
    private String formcode;
    private String attaname;
    private String attaurl;
    private int flag;
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

    public String getAttaname() {
        return attaname;
    }

    public void setAttaname(String attaname) {
        this.attaname = attaname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getAttaurl() {
        return attaurl;
    }

    public void setAttaurl(String attaurl) {
        this.attaurl = attaurl;
    }
}

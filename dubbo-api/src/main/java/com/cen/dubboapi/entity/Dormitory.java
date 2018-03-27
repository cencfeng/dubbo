package com.cen.dubboapi.entity;

import java.io.Serializable;
import java.util.Date;

public class Dormitory implements Serializable {
    private int id;
    private String dormitory_name;
    private int floor;
    private String room;
    private int sumbed;
    private int leftbed;
    private String dormitorytype;

    public String getDormitorytype() {
        return dormitorytype;
    }

    public void setDormitorytype(String dormitorytype) {
        this.dormitorytype = dormitorytype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDormitory_name() {
        return dormitory_name;
    }

    public void setDormitory_name(String dormitory_name) {
        this.dormitory_name = dormitory_name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getSumbed() {
        return sumbed;
    }

    public void setSumbed(int sumbed) {
        this.sumbed = sumbed;
    }

    public int getLeftbed() {
        return leftbed;
    }

    public void setLeftbed(int leftbed) {
        this.leftbed = leftbed;
    }
}

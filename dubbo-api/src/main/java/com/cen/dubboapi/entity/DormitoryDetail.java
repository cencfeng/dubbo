package com.cen.dubboapi.entity;

import java.io.Serializable;
import java.util.Date;

public class DormitoryDetail implements Serializable {
    private int dormitoryid;
    private Date recorddate;
    private float water;
    private float gas;
    private float electricity;
    private float waterrate;
    private float gasrate;
    private float electricityrate;
    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(int dormitoryid) {
        this.dormitoryid = dormitoryid;
    }
    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getGas() {
        return gas;
    }

    public void setGas(float gas) {
        this.gas = gas;
    }

    public float getElectricity() {
        return electricity;
    }

    public void setElectricity(float electricity) {
        this.electricity = electricity;
    }

    public float getWaterrate() {
        return waterrate;
    }

    public void setWaterrate(float waterrate) {
        this.waterrate = waterrate;
    }

    public float getGasrate() {
        return gasrate;
    }

    public void setGasrate(float gasrate) {
        this.gasrate = gasrate;
    }

    public float getElectricityrate() {
        return electricityrate;
    }

    public void setElectricityrate(float electricityrate) {
        this.electricityrate = electricityrate;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }
}

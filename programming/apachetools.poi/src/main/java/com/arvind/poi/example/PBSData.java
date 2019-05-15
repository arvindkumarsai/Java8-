package com.arvind.poi.example;

public class PBSData {

    String RPTType;
    String PBS_CODE;
    String month;
    String state;
    Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getPBS_CODE() {
        return PBS_CODE;
    }

    public void setPBS_CODE(String PBS_CODE) {
        this.PBS_CODE = PBS_CODE;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRPTType() {
        return RPTType;
    }

    public void setRPTType(String RPTType) {
        this.RPTType = RPTType;
    }

    @Override
    public String toString() {
        return "PBSData{" +
                "RPTType='" + RPTType + '\'' +
                ", PBS_CODE='" + PBS_CODE + '\'' +
                ", month='" + month + '\'' +
                ", state='" + state + '\'' +
                ", value=" + value +
                '}';
    }
}

package com.example.ictproject;

public class CompanyUpload {
    private String cName;
    private String cPhone;

    public CompanyUpload() {
        //empty constructor needed
    }

    public CompanyUpload(String name, String phone) {
        cName = name;
        cPhone = phone;
    }
    public String getCName() {
        return cName;
    }
    public void setCName(String name) {
        cName = name;
    }
    public String getCPhone() {
        return cPhone;
    }
    public void setCPhone(String phone) {
        cPhone = phone;
    }
}

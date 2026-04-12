package com.OOPs.practice;

public class Address {
    private String doorNo;
    private String street;
    private String city;
    private int zipcode;
    public Address(String doorNo,String street,String city,int zipcode) {
        this.doorNo=doorNo;
        this.street=street;
        this.city=city;
        this.zipcode=zipcode;
    }
    public String getDoorNo() {
        return doorNo;
    }
    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getZipcode() {
        return zipcode;
    }
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}

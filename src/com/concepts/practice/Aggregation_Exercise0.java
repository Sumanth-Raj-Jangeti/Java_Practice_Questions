package com.concepts.practice;

class Customer_C1{
    private String customerId;
    private String customerName;
    private long contactNumber;
    private Address address;  // Aggregation with Address
    private static int counter;
    static {
        counter = 100;
    }
    public Customer_C1(String customerName,long contactNumber,Address address) {
        this.customerId="CUS@"+ ++Customer_C1.counter;
        this.customerName=customerName;
        this.contactNumber=contactNumber;
        this.address=address;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public long getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayCustomerDetails() {
        System.out.println("Displaying customer details\n***************");
        System.out.println("Customer Id: " + this.customerId);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Address: " + getAddress().getDoorNo()+","+getAddress().getStreet()+","+getAddress().getCity()+"-"+getAddress().getZipcode());
        System.out.println();
    }

    public double payBill(double totalPrice) {
        double discountPercentage = 5;
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        return priceAfterDiscount;
    }
}
class Address {
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
public class Aggregation_Exercise0 {
    public static void main(String[] args) {
        Address address = new Address("112-45/95C","Carolina Street","SpringFeild,USA",723498);
        Customer_C1 c = new Customer_C1("John",8273987128L,address);
        c.displayCustomerDetails();


        Address address1 = new Address("3-4-1/10/C","Balaji Nagar","Hyderabad",500013);
        Customer_C1 c1 = new Customer_C1("Sumanth Raj Jangeti",7897123987L,address1);
        c1.displayCustomerDetails();

    }
}
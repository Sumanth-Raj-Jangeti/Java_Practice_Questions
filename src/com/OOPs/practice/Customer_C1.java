package com.OOPs.practice;

public class Customer_C1{
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

    //Method overloading
    public void updateDetails(String customerName) {
        this.setCustomerName(customerName);
        System.out.println("Updated Customer Details:");
        displayCustomerDetails();
    }
    public void updateDetails(long contactNumber) {
        this.setContactNumber(contactNumber);
        System.out.println("Updated Customer Details:");
        displayCustomerDetails();
    }
    public void updateDetails(Address address) {
        this.setAddress(address);
        System.out.println("Updated Customer Details:");
        displayCustomerDetails();
    }
    public void displayCustomerDetails() {
        System.out.println("Displaying customer details\n***************");
        System.out.println("Customer Id: " + this.customerId);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Address: " + getAddress().getDoorNo()+","+getAddress().getStreet()+","+getAddress().getCity()+"-"+getAddress().getZipcode());
    }
    public double payBill(double totalPrice) {
        return totalPrice;
    }
}
class Guest extends Customer_C1{
    private float deliveryCharge;
    public Guest(String name,long mobileNo,Address address){
        super(name,mobileNo,address);
        this.deliveryCharge=2f;
    }
    @Override
    public double payBill(double totalPrice) {
        double discountPercentage = 0;//Guest customer
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        double finalBillAmount = priceAfterDiscount + deliveryCharge;
        return finalBillAmount;
    }
}
class RegularCustomer extends Customer_C1 {
    private float discountPercentage;
    public float getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(float discountPercentage) { this.discountPercentage = discountPercentage; }
    public RegularCustomer(String name, long mobileNo, Address address) {
        super(name, mobileNo, address);
        this.discountPercentage = 5.0f;
    }
    @Override
    public double payBill(double totalPrice) {
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        return priceAfterDiscount;
    }
}
class premiumCustomer extends Customer_C1 {
    private float discountPercentage;
    public float getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(float discountPercentage) { this.discountPercentage = discountPercentage; }
    public premiumCustomer(String name, long mobileNo, Address address) {
        super(name, mobileNo, address);
        this.discountPercentage = 8.0f;
    }
    @Override
    public double payBill(double totalPrice) {
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        return priceAfterDiscount;
    }
}
class Test{
    public static void main(String[] args) {
        Guest g = new Guest("Hemanth",7702701839L,new Address("DN010","Ramanthapur","HYD",500013));
        System.out.println(g.payBill(200));
        RegularCustomer rc = new RegularCustomer("Sumanth",9872782889L,new Address("DNO031","Uppal","HYD",830498));
        System.out.println(rc.payBill(200));
    }
}


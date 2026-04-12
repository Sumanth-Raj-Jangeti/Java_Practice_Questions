package com.OOPs.practice;

class Customer {
    private String customerId;
    private String customerName;
    private long contactNumber;
    private String address;
    private static float deliveryCharge;
    private static int counter;
    static {
        deliveryCharge = 1.5f;
        counter = 100;
    }
    public Customer(String customerName, long contactNumber, String address) {
        this.customerId = "C"+ ++Customer.counter; //Initializing customerId & pre-incrementing counter
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.address = address;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public static float getDeliveryCharge() {
        return deliveryCharge;
    }
    public static void setDeliveryCharge(float deliveryCharge) {
        Customer.deliveryCharge = deliveryCharge;
    }

    public void displayCustomerDetails() {
        System.out.println("\nDisplaying customer details:");
        System.out.println("Customer Id: " + this.customerId);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Address: " + this.address);
        System.out.println();
    }
    public double payBill(double totalPrice) {
        double discountPercentage = 0;//Guest customer
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        double finalBillAmount = priceAfterDiscount + Customer.deliveryCharge;
        return finalBillAmount;
    }
}

public class StaticKeyword {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Sam", 9945000009L, "Carolina Street, Springfield, 62702");
        Customer.setDeliveryCharge(2f);
        System.out.println("Delivery Charge for the customers are: " + Customer.getDeliveryCharge());
        customer1.displayCustomerDetails();
        System.out.println("Final amount to be paid: $" + customer1.payBill(20));

        Customer customer2 = new Customer("John", 9645000009L, "Carolina Street, Springfield, 62708");
        customer2.displayCustomerDetails();
        System.out.println("Final amount to be paid: $" + customer2.payBill(15));
    }
}

package com.concepts.practice;

class Customer1 {
    private String customerId;
    private String customerName;
    public Customer1(){
        System.out.println("Default constructor");
    }
    public Customer1(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }
    public void displayCustomerDetails() {
        System.out.println("Displaying customer details \n***************************");
        System.out.println("Customer Id : " + this.customerId);
        System.out.println("Customer Name : " + this.customerName);
        System.out.println();
    }
}
class RegularCustomer extends Customer1 {
    private float discount;
    public RegularCustomer(String customerId, String customerName) {
        super(customerId,customerName);
        this.discount = 5.0f;
        System.out.println("Child Constructor");
    }
    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
public class Inheritance{
    public static void main (String[] args) {
        RegularCustomer rc = new RegularCustomer("CUS@100","John");
        rc.displayCustomerDetails();
    }
}


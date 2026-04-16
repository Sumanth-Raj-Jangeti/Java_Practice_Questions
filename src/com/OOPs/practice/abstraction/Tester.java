package com.OOPs.practice.abstraction;

import com.OOPs.practice.Address;
//Creating an interface...
interface PremiumCards {
    //By default, constants are (public static final)
    int WELCOME_POINTS = 100;
    //By default, methods are (public abstract)
    double redeemPoints(double totalPrice);
    void addPoints(double money);
}
abstract class Customer {
    private String customerId;
    private String customerName;
    private long contactNumber;
    private Address address;  // Aggregation with TYPE-Address
    private static int counter;
    static {
        counter = 100;
    }
    public Customer(String customerName,long contactNumber,Address address) {
        this.customerId="CUS@"+ ++Customer.counter;//Concatenating string & pre-incrementing counter value.
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

    //Method overloading...
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
    public abstract double payBill(double totalPrice);
}
class RegularCustomer extends Customer {
    float discountPercentage;
    public float getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(float discountPercentage) { this.discountPercentage = discountPercentage; }
    public RegularCustomer(String customerName, long mobileNo, Address address) {
        super(customerName, mobileNo, address);
        this.discountPercentage = 5.0f;
    }
    @Override
    public double payBill(double totalPrice) {
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        return priceAfterDiscount;
    }
}
class PremiumCustomer extends RegularCustomer implements PremiumCards {
    private int rewardPoints = WELCOME_POINTS;
    public PremiumCustomer(String customerName, long mobileNo,Address address) {
        super(customerName, mobileNo, address);
        this.discountPercentage = 8.0f;
    }
    @Override
    public double redeemPoints(double totalPrice) {
        double amountDeducted = checkAvailablePoints(totalPrice) ? totalPrice : this.rewardPoints;
        this.rewardPoints = this.rewardPoints - (int) Math.round(amountDeducted);
        System.out.println("₹"+(int) Math.round(amountDeducted) + " points deducted for paying the bill...");
        System.out.println("₹"+this.rewardPoints + " points remaining");
        return amountDeducted;
    }
    @Override
    public void addPoints(double amountSpent) {
        int pointsAdded = (int) amountSpent / 10;
        this.rewardPoints += pointsAdded;
        System.out.println("You have got ₹"+pointsAdded + " for your recent payment");
        System.out.println("₹"+this.rewardPoints + " points remaining");
    }
    @Override
    public double payBill(double totalPrice) {
        double priceAfterDiscount = super.payBill(totalPrice);
        System.out.println("Total cost after discount: ₹" + priceAfterDiscount);
        addPoints(priceAfterDiscount);
        totalPrice = priceAfterDiscount - redeemPoints(priceAfterDiscount);
        return totalPrice;
    }
    public boolean checkAvailablePoints(double amountToBePaid) {
        return this.rewardPoints >= Math.round(amountToBePaid);
    }
    public int getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
public class Tester {
    public static void main(String[] args) {
        Address custAddress = new Address("D089", "St. Louis Street", "Springfield", 62729);
        Customer premiumCustomer = new PremiumCustomer("Stephen Abram", 7856341287L, custAddress);
        premiumCustomer.displayCustomerDetails();
        double RemainingAmount = premiumCustomer.payBill(140);
        System.out.println("Final amount to be paid : ₹" + Math.round(RemainingAmount*100.0)/100.0);
    }
}



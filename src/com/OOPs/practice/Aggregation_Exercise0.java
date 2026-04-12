package com.OOPs.practice;

import java.util.*;

//I have used Customer_C1.java & Address.java

public class Aggregation_Exercise0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Address address0 = new Address("112-45/95C","Carolina Street","Spring Field, USA",723498);
        Customer_C1 c0 = new Customer_C1("John",8273987128L,address0);
        Address address1 = new Address("3-4-1/10/C","Balaji Nagar","Hyderabad",500013);
        Customer_C1 c1 = new Customer_C1("Sam",7897123987L,address1);

        List<Customer_C1> customers = new ArrayList<>();
        customers.add(c0);
        customers.add(c1);
        // Show all customers
        for(Customer_C1 customer : customers){
            customer.displayCustomerDetails();
        }

        System.out.println("Enter Customer ID:");
        String id = sc.nextLine();
        Customer_C1 selectedCustomer = findCustomerById(customers, id); // it stores the object of Customer_C1
        if (selectedCustomer != null) {
            System.out.println("1. Update Name");
            System.out.println("2. Update Contact");
            System.out.println("3. Update Address");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    /*
                       Scanner.nextInt() reads only the integer but leaves the newline character in the buffer.
                       When nextLine() is called next, it reads that leftover newline instead of actual input.
                       the problem is - it doesn't even allow us to input data...
                       So we use an extra nextLine() to consume the newline before reading the actual string.
                    */
                    sc.nextLine();
                    System.out.println("Enter new name:");
                    String name = sc.nextLine();
                    selectedCustomer.updateDetails(name);
                    break;
                case 2:
                    System.out.println("Enter new contact:");
                    long contact = sc.nextLong();
                    selectedCustomer.updateDetails(contact);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Door No:");
                    String door = sc.nextLine();
                    System.out.println("Enter Street:");
                    String street = sc.nextLine();
                    System.out.println("Enter City:");
                    String city = sc.nextLine();
                    System.out.println("Enter Zipcode:");
                    int zip = sc.nextInt();
                    Address a = new Address(door, street, city, zip);
                    selectedCustomer.updateDetails(a);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Customer not found!");
        }
        sc.close();
    }
    //This method returns Customer_C1 object if a match is found; otherwise null
    public static Customer_C1 findCustomerById(List<Customer_C1> customers, String id) {
        for (Customer_C1 customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
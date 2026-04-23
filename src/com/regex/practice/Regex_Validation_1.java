package com.regex.practice;

class Shipment{
    public boolean checkProductNameValidity(String productName) {
       String regex="^[a-zA-Z]{1,15}\\s[a-zA-Z]{1,15}(?:\\s[a-zA-Z]{1,15})?$";
       return productName.matches(regex);
    }
    public boolean checkProductIdValidity(String productId) {
        String regex="[\\w]{2,20}";
        return productId.matches(regex);
    }
    public boolean checkTrackerIdValidity(String trackerId) {
        String regex= "^[A-Z]{1}[:]{1}[A-Z]{4}[:][a-z]{3}[:][0-9]{2}$";
        return trackerId.matches(regex);
    }
}
public class Regex_Validation_1 {
    public static void main(String[] args) {
        Shipment shipment = new Shipment();
        //Change the values for testing your code with different values
        String productName = "Digital Camera";
        System.out.println("The product name is "+ (shipment.checkProductNameValidity(productName) ? "valid!" : "invalid!"));
        String productId = "DC1911";
        System.out.println("The product Id is "+ (shipment.checkProductIdValidity(productId) ? "valid!" : "invalid!"));
        String trackerId = "D:CMDC:cmd:23";
        System.out.println("The tracker Id is "+ (shipment.checkTrackerIdValidity(trackerId) ? "valid!" : "invalid!"));
    }
}








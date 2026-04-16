package com.OOPs.practice.abstraction;

abstract class Payment{
    //Implement your code here
    private int customerId;
    protected String paymentId;
    protected double serviceTaxPercentage;
    public Payment(int customerId){
        this.customerId=customerId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {this.paymentId = paymentId;}
    public double getServiceTaxPercentage() {
        return serviceTaxPercentage;
    }
    public void setServiceTaxPercentage(double serviceTaxPercentage) { this.serviceTaxPercentage = serviceTaxPercentage;}
    abstract public double payBill(double amount);
}
class DebitCardPayment extends Payment{
    //Implement your code here
    private static int counter;
    private double discountPercentage;
    static{
        counter=1000;
    }
    public DebitCardPayment(int customerId){
         super(customerId);
         paymentId="D"+ ++DebitCardPayment.counter;
        //setPaymentId("D"+ ++counter);
    }
    public double payBill(double amount) {
        //1. Initialize the serviceTaxPercentage and calculate serviceTaxAmount
        double serviceTaxAmount=0,discountAmount=0;
        if(amount<=500) serviceTaxPercentage=2.5;
        else if(amount>500 && amount<=1000) serviceTaxPercentage=4;
        else if(amount>1000) serviceTaxPercentage=5;
        serviceTaxAmount=amount*serviceTaxPercentage/100;
        //2. Initialize the discountPercentage and calculate discountAmount
        if(amount<=500) discountPercentage=1;
        else if(amount<=1000) discountPercentage=2;
        else discountPercentage=3;
        discountAmount=amount*discountPercentage/100;
        //3. Final bill amount
        return amount + serviceTaxAmount - discountAmount;
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        DebitCardPayment.counter = counter;
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
class CreditCardPayment extends Payment{
    //Implement your code here
    private static int counter;
    static{
        counter=1000;
    }
    public CreditCardPayment(int customerId){
        super(customerId);
        paymentId="C"+ ++counter;
    }
    public double payBill(double amount) {
        double serviceTaxAmount=0;
        if(amount<=500) serviceTaxPercentage=3;
        else if(amount<=1000) serviceTaxPercentage=5;
        else serviceTaxPercentage=6;

        serviceTaxAmount=amount*serviceTaxPercentage/100;
        return amount+serviceTaxAmount;
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        CreditCardPayment.counter = counter;
    }
}
public class AbstractAssignment1 {
    public static void main(String[] args){
        DebitCardPayment debitCardPayment = new DebitCardPayment(101);
        double billAmount=Math.round(debitCardPayment.payBill(500)*100)/100.0;
        System.out.println("Customer Id: " + debitCardPayment.getCustomerId());
        System.out.println("Payment Id: " + debitCardPayment.getPaymentId());
        System.out.println("Service tax percentage: " + debitCardPayment.getServiceTaxPercentage());
        System.out.println("Discount percentage: " + debitCardPayment.getDiscountPercentage());
        System.out.println("Total bill amount: " + billAmount);

        CreditCardPayment creditCardPayment = new CreditCardPayment(102);
        billAmount=Math.round(creditCardPayment.payBill(1000)*100)/100.0;
        System.out.println("Customer Id: " + creditCardPayment.getCustomerId());
        System.out.println("Payment Id: " + creditCardPayment.getPaymentId());
        System.out.println("Service tax percentage: " + creditCardPayment.getServiceTaxPercentage());
        System.out.println("Total bill amount: " + billAmount);
    }
}

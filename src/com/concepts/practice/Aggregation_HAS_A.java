package com.concepts.practice;

class Order {
    private static int orderIDCounter;
    private int orderId;
    private Customer_C1 customer;//phase 2:(Order has a Customer_C1) Aggregation with Customer_C1 class
    private Food[] orderedFoods; //phase 1:(Order has a Food) Aggregation with Food class
    private double totalPrice;
    private String status;
    static {
        orderIDCounter = 100;
    }
    public Order(){
        this.status="Ordered";
    }
    public Order(Food[] orderedFoods) {
        this.orderId =++Order.orderIDCounter;
        this.orderedFoods = orderedFoods;
        this.status = "Ordered";
    }
    public int getTotalNoOfOrders() {
        return Order.orderIDCounter - 100;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Food[] getOrderedFoods() {
        return orderedFoods;
    }
    public void setOrderedFoods(Food[] orderedFoods) {
        this.orderedFoods = orderedFoods;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Customer_C1 getCustomer() { return customer; }
    public void setCustomer(Customer_C1 customer) {
        this.customer = customer;
    }

    public double calculateTotalPrice(String paymentMode) {
        double foodPrice = 0;
        double finalPrice = 0;
        float serviceCharge = 0f;
        for (Food food : orderedFoods) {
            foodPrice+=food.getUnitPrice();
        }
        if (paymentMode.equals("Credit Card") || paymentMode.equals("Debit Card")) {
            serviceCharge = 2.9f;
        }
        else if (paymentMode.equals("UPI")) {
            serviceCharge = 2.0f;
        }
        finalPrice = foodPrice+foodPrice*(serviceCharge/100);
        this.setTotalPrice(finalPrice);
        return finalPrice;
    }
}
class Food {
    private String foodName;
    private String cuisine;
    private String foodType;
    private int quantityAvailable;
    private double unitPrice;

    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getCuisine() {
        return cuisine;
    }
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
    public String getFoodType() {
        return foodType;
    }
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    public int getQuantityAvailable() {
        return quantityAvailable;
    }
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
class Bill{
    private static int counter;
    private String billId;
    private String paymentMode;
    static {
        counter = 5000;
    }
    public Bill(String paymentMode) {
        this.paymentMode = paymentMode;
        this.billId = "B" + ++Bill.counter;
    }
    //getter & setter
    public static int getCounter() {
        return Bill.counter;
    }
    public String getBillId() {
        return billId;
    }
    public void setBillId(String billId) {
        this.billId = billId;
    }
    public String getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void generateBill(Order order) {
        System.out.println("Bill details \n***********");
        System.out.println("Bill Id : " + this.getBillId());
        System.out.println("Items ordered : ");
        for (Food food : order.getOrderedFoods()) {
            System.out.println(food.getFoodName() + " ("+ food.getFoodType() + ")"  +  " - ₹" + food.getUnitPrice());
        }
        double payableAmount = order.calculateTotalPrice(this.getPaymentMode());
        System.out.println("Food Price  ₹"+payableAmount);
    }

}
public class Aggregation_HAS_A {
    public static void main(String[] args) {
        //Creating food objects.
        Food f1 = new Food();
        f1.setFoodName("Pizza");
        f1.setCuisine("Italian");
        f1.setFoodType("Veg");
        f1.setQuantityAvailable(10);
        f1.setUnitPrice(122.0);

        Food f2 = new Food();
        f2.setFoodName("Burger");
        f2.setCuisine("American");
        f2.setFoodType("Non-Veg");
        f2.setQuantityAvailable(1);
        f2.setUnitPrice(131.45);

        // Step 2: Store in array
        Food[] food = {f1, f2};

        // Step 3: Pass to Order (Aggregation)
        Order order = new Order(food);

        Bill bill1 = new Bill("UPI");
        bill1.generateBill(order); //(Association)
    }
}

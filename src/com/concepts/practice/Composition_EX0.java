package com.concepts.practice;

class Engine {
    private String type;
    public Engine(String type){
        this.type=type;
    }
    public void start(){
        System.out.println("Engine of type"+type+"is starting...");
    }
}
class Car{
    private Engine engine;
    public Car(){
        //Creating engine object
        engine=new Engine("Petrol");
    }
    public void startCar(){
        engine.start();
        System.out.println("Car Started");
    }
}
public class Composition_EX0 {
    public static void main(String[] args) {
        Car c = new Car();
        c.startCar();
    }
}

package com.OOPs.practice.abstraction;

abstract class TV {
    //Defining abstract methods...
    abstract void turnON();
    abstract void  turnOFF();
    void display() {
        System.out.println("****Show started****");
    }
}
class TVRemote extends TV {

    @Override
    void turnON() {
        System.out.println("TV is turned on...");
    }

    @Override
    void turnOFF() {
        System.out.println("TV is turned off...");
    }
}
public class AbstractClass_Ex0 {
    public static void main(String[] args) {
        TV remote = new TVRemote();
        remote.turnON();
        remote.display();
        remote.turnOFF();
    }
}

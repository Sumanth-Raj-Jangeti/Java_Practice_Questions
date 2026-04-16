package com.OOPs.practice.abstraction;

interface DemoOne {
    int number = 5;
}
interface DemoTwo extends DemoOne{
    void display();
}
class DemoClassOne implements DemoTwo {
    public void display() {
        System.out.println(number);
    }
}
public class Interfaces_Ex0 {
    public static void main(String[] args) {
        DemoTwo obj = new DemoClassOne();
        obj.display();
    }
}

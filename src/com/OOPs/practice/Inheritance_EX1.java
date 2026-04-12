package com.OOPs.practice;

/* The super keyword can be used to access members of a super class*/

class X{
    int x;
    public void show() {
        System.out.println("SUPER CLASS method");
    }
}
class Y extends X{
    int x; //since, member names of subclass hides the member of super class
    public Y(int a,int b) {
        super.x=a;
        x=b;
    }

    @Override
    public void show() {
        System.out.println("x in super class:"+super.x);
        System.out.println("x in sub class:"+x);
    }
}
public class Inheritance_EX1 {
    public static void main(String[] args) {
        Y y = new Y(10,20);
        y.show();
    }
}

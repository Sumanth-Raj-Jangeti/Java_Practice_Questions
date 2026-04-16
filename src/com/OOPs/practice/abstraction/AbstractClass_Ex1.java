package com.OOPs.practice.abstraction;

abstract class Shape{
    String color;
    //Defining abstract methods...
    abstract double area();
    abstract double perimeter();
    public Shape(String color){
        this.color = color;
    }
    //Concrete Method
    public String getColor(){
        return color;
    }
}
class Circle extends Shape{
    double radius;
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    @Override double area(){
        double area = Math.PI * Math.pow(radius, 2);
        return Math.round(area*100.0)/100.0;
    }
    @Override
    double perimeter() {
        return Math.round((2 * Math.PI * radius)*100.0)/100.0;
    }

}
class Rectangle extends Shape{
    double length;
    double width;
    public Rectangle(String color, double length, double width)
    {
        // calling Shape constructor
        super(color);
        this.length = length;
        this.width = width;
    }
    @Override double area() {
        double area = length * width;
        return Math.round(area*100.0)/100.0;
    }
    @Override
    double perimeter() {
        double perimeter = 2 * (length + width);
        return Math.round(perimeter*100.0)/100.0;
    }
}
public class AbstractClass_Ex1 {
    public static void main(String[] args) {
        Shape s1 = new Circle("Red", 2.2);
        Shape s2 = new Rectangle("Yellow", 2, 4);

        System.out.println("Area of Circle:"+s1.area()+
                "\nPerimeter of Circle:"+s1.perimeter()+
                "\nArea of Rectangle:"+s2.area()+
                "\nPerimeter of Rectangle:"+s2.perimeter());

    }
}

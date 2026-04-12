package com.OOPs.practice;

class Triangle{
    private Point point1;
    private Point point2;
    private Point point3;
    /*
       Initialize the instance variables point1, point2 and point3 with the following coordinate values
       point1 - 0, 0
       point2 - 1, 1
       point3 - 2, 5
    */
    public Triangle(){
        this.point1=new Point(0,0);
        this.point2=new Point(1,1);
        this.point3=new Point(2,5);
    }
    /*
       Initialize the instance variables point1, point2 and point3 with the following coordinate values
       point1 - point1XCoordinate, point1YCoordinate
       point2 - point2XCoordinate, point2YCoordinate
       point3 - point3XCoordinate, point3YCoordinate
    */
    public Triangle(double point1XCoordinate,double point1YCoordinate,
                    double point2XCoordinate,double point2YCoordinate,
                    double point3XCoordinate,double point3YCoordinate){
        this.point1=new Point(point1XCoordinate,point1YCoordinate);
        this.point2=new Point(point2XCoordinate,point2YCoordinate);
        this.point3=new Point(point3XCoordinate,point3YCoordinate);
    }
    //Initialize the instance variables point1, point2 and point3 appropriately with the values passed to the constructor
    public Triangle(Point point1,Point point2,Point point3){
        this.point1=point1;
        this.point2=point2;
        this.point3=point3;
    }
    //Including necessary setter & getter methods.
    public Point getPoint1() {
        return point1;
    }
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }
    public Point getPoint2() {
        return point2;
    }
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
    public Point getPoint3() {
        return point3;
    }
    public void setPoint3(Point point3) {
        this.point3 = point3;
    }
    public double calculatePerimeter(){
        double a = point1.calculateDistance(point2);
        double b = point2.calculateDistance(point3);
        double c = point3.calculateDistance(point1);
        double perimeter = a + b + c;
        return Math.round(perimeter*100.0)/100.0;
    }
    public double calculateArea(){
        double a = point1.calculateDistance(point2);
        double b = point2.calculateDistance(point3);
        double c = point3.calculateDistance(point1);
        double side = (a + b + c)/2;
        double area = Math.sqrt(side * (side-a)*(side-b)*(side-c));
        return Math.round(area*100.0)/100.0;
    }
}
public class MethodOverloading_EX2 {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle(1, 2, 6, 5, 5, 1);

        Point point1 = new Point(2, 1);
        Point point2 = new Point(4, 4);
        Point point3 = new Point(9, 1);
        Triangle triangle3 = new Triangle(point1, point2, point3);

        System.out.println("Perimeter of triangle1 is "+triangle1.calculatePerimeter());
        System.out.println("Area of triangle1 is "+triangle1.calculateArea());

        System.out.println("Perimeter of triangle2 is "+triangle2.calculatePerimeter());
        System.out.println("Area of triangle2 is "+triangle2.calculateArea());

        System.out.println("Perimeter of triangle3 is "+triangle3.calculatePerimeter());
        System.out.println("Area of triangle3 is "+triangle3.calculateArea());
    }
}

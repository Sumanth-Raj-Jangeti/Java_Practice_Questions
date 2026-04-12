package com.OOPs.practice;

class Point {
    private double xCoordinate;
    private double yCoordinate;
    public Point(double xCoordinate,double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public double getXCoordinate() { return xCoordinate; }
    public void setXCoordinate(double xCoordinate) { this.xCoordinate = xCoordinate; }
    public double getYCoordinate() { return yCoordinate; }
    public void setYCoordinate(double yCoordinate) { this.yCoordinate = yCoordinate; }
    //Method Overloading
    public double calculateDistance()
    {
        double distance = Math.sqrt(getXCoordinate()*getXCoordinate() + getYCoordinate()*getYCoordinate());
        return Math.round(distance*100.0)/100.0;
    }
    public double calculateDistance(Point point)
    {
        double xDiff = xCoordinate - point.getXCoordinate();
        double yDiff = yCoordinate - point.getYCoordinate();
        double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        return Math.round(distance * 100.0)/100.0;
    }
}
class MethodOverloading_EX0 {
    public static void main(String[] args) {
        Point point1 = new Point(3.5, 1.5);
        Point point2 = new Point(6, 4);
        System.out.println("Distance of point1 from origin is "+point1.calculateDistance());
        System.out.println("Distance of point2 from origin is "+point2.calculateDistance());
        System.out.println("Distance of point1 from point2 is "+point1.calculateDistance(point2));
    }
}
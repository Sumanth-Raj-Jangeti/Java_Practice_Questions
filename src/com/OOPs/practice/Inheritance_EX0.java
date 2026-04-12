package com.OOPs.practice;

class Employee {
    public int employeeId;
    public String employeeName;
    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
    public void display() {
        System.out.println("Employee details");
        System.out.println("Id: " + employeeId);
        System.out.println("Name of the Employee: " + employeeName);
    }
}
class Manager extends Employee {
    public String designation;
    public float avgRating;
    public Manager(int employeeId, String employeeName, String designation,float avgRating) {
        super(employeeId, employeeName);
        this.designation = designation;
        this.avgRating=avgRating;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Designation:"+this.designation);
        System.out.println("Average Rating:"+this.avgRating);
    }
}
public class Inheritance_EX0 {
    public static void main(String[] args) {
        Manager obj = new Manager(2545, "John", "Java Developer",4.1f);
        obj.display();
    }
}


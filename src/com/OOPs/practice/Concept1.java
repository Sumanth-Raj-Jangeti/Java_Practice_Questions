package com.OOPs.practice;

class Lecturer {
    //Declaring instance var's.
    private String teacherName;
    private String subject;
    private double salary;

    //Creating a constructor.
    public Lecturer(String teacherName, String subject, double salary){
        this.teacherName=teacherName;
        this.subject=subject;
        this.salary=salary;
    }

    //getter & setter methods.
    public String getTeacherName(){
        return teacherName;
    }
    public void setTeacherName(String teacherName){
        this.teacherName=teacherName;
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        this.subject=subject;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
}
public class Concept1 {
    public static void main(String[] args) {
        Lecturer t1 = new Lecturer("Alex","Java Fundamental",1200.0);
        Lecturer t2 = new Lecturer("John","RDBMS",800.0);
        Lecturer t3 = new Lecturer("Sam","Networking",900.0);
        Lecturer t4 = new Lecturer("Maria","Python",900.0);

        //Create an array of type Teacher
        Lecturer[] t = new Lecturer[]{t1,t2,t3,t4};

        //Displaying teachers...
        for(int i=0;i<t.length;i++)
        {
            System.out.println("Name : "+t[i].getTeacherName()+", Subject : "+t[i].getSubject()+", Salary : "+t[i].getSalary());
        }
    }
}
/*
     It’s technically possible to use multiple arrays to store related data like names, subjects,
     and salaries, it’s not a good design choice because the data becomes scattered and tightly dependent on index positions,
     which increases the risk of errors and makes the code hard to maintain.Instead,
     I prefer using a class like Teacher because it follows object-oriented principles, especially encapsulation,
     where all related attributes are bundled into a single unit.This makes the code more readable, scalable,
     and closer to real-world modeling.For example, each Teacher object represents a complete entity,
     and adding new properties or behaviors becomes much easier without affecting the overall structure.
     So, using classes improves code organization, maintainability, and robustness compared to using separate arrays.
*/


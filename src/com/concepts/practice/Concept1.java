package com.concepts.practice;

class Teacher {
    //Declaring instance var's.
    private String teacherName;
    private String subject;
    private double salary;

    //Creating a constructor.
    public Teacher(String teacherName,String subject,double salary){
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
        Teacher t1 = new Teacher("Alex","Java Fundamental",1200.0);
        Teacher t2 = new Teacher("John","RDBMS",800.0);
        Teacher t3 = new Teacher("Sam","Networking",900.0);
        Teacher t4 = new Teacher("Maria","Python",900.0);

        //Create an array of type Teacher
        Teacher[] t = new Teacher[]{t1,t2,t3,t4};

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


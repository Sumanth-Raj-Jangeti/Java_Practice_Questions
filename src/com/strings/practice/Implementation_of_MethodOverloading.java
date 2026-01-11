package com.strings.practice;

import java.util.Scanner;

public class Implementation_of_MethodOverloading {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 3 values:");
        int num1=sc.nextInt();
        int num2 =sc.nextInt();
        int num3=sc.nextInt();
        System.out.println("Addition of "+num1+" and "+num2+" is:"+findsum(10,20));       //Method Call
        System.out.println("Addition of "+num1+","+num2+" and "+num3+" is:"+findsum(10,20,30)); //Method Call
        System.out.println("Difference of "+num1+" and "+num2+" is:"+findsub(10,20));       //Method Call
        System.out.println("Difference of "+num1+","+num2+" and "+num3+" is:"+findsub(10,20,30)); //Method Call
    }
    public static int findsum(int num1,int num2)
    {
        return num1+num2;
    }
    public static int findsum(int num1,int num2,int num3)
    {
        return num1+num2+num3;
    }
    public static int findsub(int num1,int num2)
    {
        return num1-num2;
    }
    public static int findsub(int num1,int num2,int num3)
    {
        return num1-num2-num3;
    }
}

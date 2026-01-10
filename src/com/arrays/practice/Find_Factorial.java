package com.arrays.practice;

import java.util.Scanner;

public class Find_Factorial {
    public static void main(String[] args) {
        //A program to find the factorial of a number using recursion.
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number:");
        int num=sc.nextInt();
        System.out.println("Factorial of "+num+" is:"+factorial(num)); //Method Call
    }
    public static int factorial(int n)
    {
        if(n==0 || n==1)
            return 1;
        else
            return n * factorial(n-1);  // Method Call
    }
}

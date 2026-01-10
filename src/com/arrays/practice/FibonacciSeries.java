package com.arrays.practice;

import java.util.Scanner;

//Fibonacci Series: A series of numbers in which each number is the sum of 2 preceding numbers.
//it is given by: 0 1 1 2 3 5 8 13 21 34 and so on.

public class FibonacciSeries {
    public static void main(String[] args) {
        //Fibonacci numbers...
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a UpperLimit:");
        int n=sc.nextInt();
        printFibonacci(n); //Method Call to print 'n' Fibonacci numbers...
        System.out.println("\nEnter Start and End Values:");
        int start=sc.nextInt();
        int end=sc.nextInt();
        rangeOfFibonacci(start,end);//Method Call to print a range of Fibonacci numbers...
        System.out.println("\nFibonacci Series with Recursion:");
        System.out.println("Enter a Number:");
        int num=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.print(getFibonacci(i)+" ");//Method Call to print Fibonacci numbers using recursion...
        }
    }
    public static void printFibonacci(int n) // TC:O(n) & SC:O(1)
    {
        int n1=0,n2=1,sum;
        System.out.println("Fibonacci Series:");
        System.out.print(n1+" "+n2);
        int i=2;//Because, we already printed 2 values...
        while (i<n)
        {
            sum=n1+n2;
            System.out.print(" "+sum);
            //InterChange the values...
            n1=n2;
            n2=sum;
            i++;
        }
    }
    public static void rangeOfFibonacci(int start,int end)
    {
        int n1=0,n2=1,sum=0;
        while(n1<=end)
        {
            if(n1>=start)
            {
                System.out.print(n1+" ");
            }
            sum=n1+n2;
            n1=n2;
            n2=sum;
        }
    }
    public static int getFibonacci(int n)
    {
        //A recursive approach -> TC:O(2^N) & SC:O(n)
        if(n==0) return 0;
        if(n==1) return 1;
        return getFibonacci(n-1)+getFibonacci(n-2);
    }
}

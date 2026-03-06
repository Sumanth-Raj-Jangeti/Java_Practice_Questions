package com.arrays.practice;

public class Find_GCD_LCM_EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.println("*****GCD & LCM*****");
        System.out.println("\nGCD of 2No.s:"+gcd(24,36));
        System.out.println("LCM of 2No.s:"+lcm(24,36));
        System.out.println("\nGCD of 3No.s:"+gcd(gcd(10,20),30));
        System.out.println("LCM of 3No.s:"+lcm(lcm(10,20),30));

        System.out.println("\nGCD_By_Recursion:"+recursive_GCD(1025,45));
        System.out.println("LCM:"+lcm(1025,45));
    }
    public static int gcd(int a,int b)
    {
        while(b!=0)
        {
            //Swapping Logic
            int temp = b;
            b = a % b; //By using Euclidean Algorithm
            a = temp;
        }
        return a;
    }
    public static int lcm(int a,int b)
    {
        return (a * b)/gcd(a,b);
    }
    public static int recursive_GCD(int a,int b) {
        if (b == 0) {
            return a;
        }
        return recursive_GCD(b, a % b); //A recursive call
    }
}

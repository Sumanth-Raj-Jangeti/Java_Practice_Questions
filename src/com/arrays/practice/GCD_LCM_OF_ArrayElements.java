package com.arrays.practice;

public class GCD_LCM_OF_ArrayElements {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        System.out.println("\nGCD & LCM of Entire Array:");
        //Let us Consider
        int GCD=arr[0],LCM=arr[0];
        for (int j : arr) {
            GCD = gcd(GCD, j);
            LCM = lcm(LCM, j);
        }
        System.out.println("GCD of given array:"+GCD);
        System.out.println("LCM of given array:"+LCM);
    }
    public static int gcd(int a,int b)
    {
        while(b!=0)
        {
            //Swapping Logic
            int temp=b;
            b=a % b;
            a=temp;
        }
        return a;
    }
    public static int lcm(int a,int b)
    {
        return (a*b)/gcd(a,b);
    }
}

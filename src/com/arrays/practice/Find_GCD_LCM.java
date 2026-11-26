package com.arrays.practice;

public class Find_GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(12,36));
    }
    /**Listing out all the common factors. TC: O(min(a,b)) & SC: O(1)*/
    public static int gcd(int a,int b){
        //1. Determining the min of 2 numbers - because gcd of 2 numbers can never be greater than the smaller number.
        int min = Math.min(a,b);
        int gcd = 1;//Every pair of positive integers shares 1 as a common divisor.
        for(int i=1;i<=min;i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
}

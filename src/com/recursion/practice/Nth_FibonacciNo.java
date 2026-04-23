package com.recursion.practice;

public class Nth_FibonacciNo {
    static int[] memo = new int[100];
    public static int findFibonacci(int n) {
        //early exit...
        if(n==1) return 0;
        if(n==2) return 1;
        // check if already computed...
        if (memo[n] != 0)
            return memo[n];
        // store result.
        memo[n] = findFibonacci(n - 1) + findFibonacci(n - 2);
        return memo[n];
    }
    public static void main(String[] args) {
        int n = 10;
        if(n!=0)
            System.out.println(findFibonacci(n));
        else
            System.out.println("Please enter a valid value for n");
    }
}

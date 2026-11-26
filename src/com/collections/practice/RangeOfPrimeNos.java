package com.collections.practice;

import java.util.*;

public class RangeOfPrimeNos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a & b values:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> results = rangePrime(a,b);
        System.out.println("Range of Prime No.s"+results);
        System.out.println("Total no of primes no.s"+results.size());
    }
    /*For every number in the range, I check divisibility only till its square root because factors occur in pairs.
    If no factor exists till √n, then the number is prime. This reduces complexity from O(n²) to O(n√n).*/
    public static List<Integer> rangePrime(int a,int b){
        List<Integer> prime = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (i < 2) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime.add(i);
            }
        }
        return prime;
    }
}

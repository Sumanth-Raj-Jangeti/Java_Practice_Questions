package com.recursion.practice;

public class Sum_of_HP {
    public static double findHPSum(int num) {
        /*int[] arr = new int[num];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        double[] reciprocal = new double[arr.length];
        double sum=0;
        for(int i=0;i<arr.length;i++){
            reciprocal[i]=1.0/arr[i];
            sum+=reciprocal[i];
        }
        return sum;*/

        // base case
        if (num == 1) {
            return 1.0;
        }

        // recursive case
        return (1.0 / num) + findHPSum(num - 1);
    }
    public static void main(String[] args) {
        System.out.println(findHPSum(3));
    }
}


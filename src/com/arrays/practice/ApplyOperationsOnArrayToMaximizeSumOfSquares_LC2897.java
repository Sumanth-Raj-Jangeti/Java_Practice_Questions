package com.arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class ApplyOperationsOnArrayToMaximizeSumOfSquares_LC2897 {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2,6,5,8));
        System.out.println(maxSum(list,2));
    }
    public static int maxSum(List<Integer> nums, int k) {
        int[] setBitsPerPosition = new int[32];
        for(int num: nums){
            for(int bitPos = 0; bitPos <32; bitPos++){
                  if((num & (1<< bitPos)) != 0){
                    setBitsPerPosition[bitPos]++;
                }
            }
        }
        long result=0;
        while(k-- > 0){//I only need k elements.
            long curr = 0;
            for(int bitPos = 0; bitPos <32; bitPos++){
                if(setBitsPerPosition[bitPos] > 0){
                    setBitsPerPosition[bitPos]--;
                    curr = curr | (1<<bitPos);
                }
            }
            result = (result + (curr * curr)) % MOD;
        }
        return (int) result;
    }
}
/*
The code does not count the total number of set bits per number.
Instead, it tracks how many times a '1' appears at each specific bit position across the entire list.
*count[0] stores how many numbers have a 1 in the 0th bit position, count[1] stores how many have a 1 in the 1st bit position, and so on.
*/
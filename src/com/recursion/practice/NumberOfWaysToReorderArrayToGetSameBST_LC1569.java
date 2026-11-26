package com.recursion.practice;

import java.util.*;

public class NumberOfWaysToReorderArrayToGetSameBST_LC1569 {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        System.out.println(numOfWays(new int[]{3,4,5,1,2}));
    }
    public static int numOfWays(int[] nums) {
        int n = nums.length;
        int[][] table = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
             table[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j] + table[i - 1][j-1]) % MOD;
            }
        }
        List<Integer> temp = new ArrayList<>(n);
        for(int num:nums){
            temp.add(num);
        }
        return (int)(solve(temp,table) - 1) % MOD;
    }
    private static long solve(List<Integer> nums,int[][] table){
        int n = nums.size();
        if(n < 3) return 1;//base case
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        int root = nums.getFirst();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long leftWays = solve(leftNodes,table) % MOD;
        long rightWays = solve(rightNodes,table) % MOD;
        // Keep intermediate multiplication as long to prevent overflow
        long totalWays = (leftWays * rightWays) % MOD;
        return (totalWays * table[n - 1][leftNodes.size()]) % MOD;
    }
}

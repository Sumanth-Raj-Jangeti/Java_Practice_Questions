package com.recursion.practice;

import java.util.Arrays;

public class LC115_MemoizationTopDown {
    public static void main(String[] args) {
        String s="rabbbit",t="rabbit";
        int m = s.length(), n = t.length();
        int[][] memo = new int[m + 1][n + 1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        int distinctSubSequences = solve(s, t, m, n, memo);
        System.out.println(distinctSubSequences);
    }
    public static int solve(String s, String t, int m, int n, int[][] memo) {
        // Base cases
        if (n == 0) return 1;
        if (m == 0) return 0;
        // 1. If we've solved this exact state before, return it immediately.
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // 2. Instead of just returning, save the result to the mem table first.
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            memo[m][n] = solve(s, t, m - 1, n - 1, memo) + solve(s, t, m - 1, n, memo);
        } else {
            memo[m][n] = solve(s, t, m - 1, n, memo);
        }
        return memo[m][n];
    }
}

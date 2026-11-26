package com.recursion.practice;

import java.util.Arrays;

public class ClimbingStairs_LC3693 {
    public static void main(String[] args) {
        int n = 4;
        int[] costs = {1, 2, 3, 4};
        System.out.println("Minimum total cost to reach step " + n + ": " + climbStairs(n, costs));
    }

    public static int climbStairs(int n, int[] costs) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(0, n, costs, memo);
    }

    private static int solve(int i, int n, int[] costs, int[] memo) {
        //Base case.
        if (i == n) return 0;
        if (memo[i] != -1) return memo[i];
        int cost = Integer.MAX_VALUE;
        int j = i + 1;
        if (j <= n) cost = solve(j, n, costs, memo) + costs[j - 1] + (j - i) * (j - i);
        j = i + 2;
        if (j <= n) cost = Math.min(cost, solve(j, n, costs, memo) + costs[j - 1] + (j - i) * (j - i));
        j = i + 3;
        if (j <= n) cost = Math.min(cost, solve(j, n, costs, memo) + costs[j - 1] + (j - i) * (j - i));
        return memo[i] = cost;
    }
}

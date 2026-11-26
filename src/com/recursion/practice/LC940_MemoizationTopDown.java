package com.recursion.practice;

import java.util.Arrays;

public class LC940_MemoizationTopDown {
    public static void main(String[] args) {
        String s="aba";
        int distinctSubSequences = distinctSubseqII(s);
        System.out.println(distinctSubSequences);
    }
    public static int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] prev = new int[n + 1];
        int[] lastSeen = new int[26];
        for(int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        // Pass dp and prev into the helper method
        return (solve(n, dp, prev) - 1);//-1 for "" string
    }
    private static int solve(int n, int[] dp, int[] prev) {
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        int total = (2 * solve(n - 1, dp, prev));
        if (prev[n] != 0) {
            int duplicates = solve(prev[n] - 1, dp, prev);
            total = (total - duplicates);
        }
        return dp[n] = total;
    }
}
//Refer LC940(for this optimization) the answer may be very large, return it modulo 10^9 + 7.
package com.recursion.practice;

public class LC115_BottomUp {
    public static void main(String[] args) {
        String s="babgbag",t="bag";
        int distinctSubSequences = numDistinct(s,t);
        System.out.println(distinctSubSequences);
    }
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // 1. Create the DP table.
        int[][] dp = new int[m + 1][n + 1];
        // 2. Initialize Base Cases.
        // If t is empty (n=0)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        // If s is empty (m=0)
        for(int j = 1; j <= n; j++){
            dp[0][j] = 0;
        }
        // 3. Build the table Bottom-Up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];// The final answer is stored in the very last cell
    }
}

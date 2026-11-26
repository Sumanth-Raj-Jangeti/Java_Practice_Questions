package com.recursion.practice;

import java.util.Arrays;

public class LC2472_TopDownMemoization {
    public static void main(String[] args) {
        int result = maxPalindromes("abaccdbbd",3);
        System.out.println("Maximum no.of non-overlapping palindrome substrings:"+result);
    }
    public static int maxPalindromes(String s, int k) {
        int n = s.length();
        //Precomputing all palindromes
        boolean[][] isPalindrome = new boolean[n+1][n+1];
        for(int L=1 ;L<=n; L++){
            for(int i=0; i+L<=n; i++){
                int j = i+L-1;
                if(i==j){
                    //1 length string is always palindrome.
                    isPalindrome[i][j] = true;
                }else if(i+1 == j){
                    //when length is 2
                    isPalindrome[i][j] = (s.charAt(i)==s.charAt(j));
                }else{
                    isPalindrome[i][j] = (s.charAt(i)==s.charAt(j)) && isPalindrome[i+1][j-1];
                }
            }
        }
        int[][] memo = new int[n+1][n+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        if(k==1) return n;//Every single character is a palindrome, so the maximum number is exactly:n
        return solve(s,k,0,k-1,memo,isPalindrome);
    }
    private static int solve(String s,int k,int i,int j,int[][] memo,boolean[][] isPalindrome){
        int n = s.length();
        //Base case.
        if(i>=n || j>=n) return 0;
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(isPalindrome[i][j]){
            int take = 1 + solve(s,k,j+1,j+k,memo,isPalindrome);
            int grow = solve(s,k,i,j+1,memo,isPalindrome);
            int slide = solve(s,k,i+1,j+1,memo,isPalindrome);
            return memo[i][j] = Math.max(Math.max(take,grow),slide);
        }
        int grow = solve(s,k,i,j+1,memo,isPalindrome);
        int slide = solve(s,k,i+1,j+1,memo,isPalindrome);
        return memo[i][j] = Math.max(grow,slide);
    }
}
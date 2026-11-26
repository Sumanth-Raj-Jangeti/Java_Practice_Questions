package com.recursion.practice;

public class LC115_Recursion {
    public static void main(String[] args) {
        String s="rabbbit",t="rabbit";
        int distinctSubSequences = solve(s,t,s.length(),t.length());
        System.out.println(distinctSubSequences);
    }
    public static int solve(String s,String t,int m,int n){
        //Base case.
        if(n==0) return 1;
        if(m==0) return 0;
        //Chars match.
        if(s.charAt(m-1)==t.charAt(n-1)){
            return solve(s,t,m-1,n-1) + solve(s,t,m-1,n);
        }
        //chars don't match.
        return solve(s,t,m-1,n);
    }
}
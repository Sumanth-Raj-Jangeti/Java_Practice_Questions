package com.recursion.practice;

import java.util.HashSet;
import java.util.Set;

public class LC940_BruteForce {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String s="abc";
        int distinctSubSequences = distinctSubseqII(s);
        System.out.println(distinctSubSequences);
    }
    public static int distinctSubseqII(String s) {
        StringBuilder curr = new StringBuilder();
        solve(s,curr,0);
        return set.size();
    }
    public static void solve(String s,StringBuilder curr,int i){
        int n = s.length();
        //base case.
        if(i==n){
            if(!curr.isEmpty()){
                set.add(curr.toString());
            }
            return;
        }
        // Choice 1: PICK the current character
        curr.append(s.charAt(i));
        solve(s, curr, i + 1);
        // 4. BACKTRACK: Remove the character we just added so the "Don't Pick" branch starts clean
        curr.deleteCharAt(curr.length() - 1);
        // Choice 2: DON'T PICK the current character
        solve(s, curr, i + 1);
    }
}
/*
Base Case: If i reaches n, we have evaluated every character in the string. The curr variable now holds one fully formed subsequence.
 */
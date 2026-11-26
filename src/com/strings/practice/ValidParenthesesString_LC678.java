package com.strings.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParenthesesString_LC678 {
    public static void main(String[] args) {
        String s = "*(())(*";
        //System.out.println(checkValidStringI(s));
        System.out.println(checkValidStringII(s));
    }
    public static boolean checkValidStringI(String s) {
        int n = s.length();
        int[][] memo = new int[n+1][n+1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,s,n,memo);
    }
    private static boolean solve(int index,int openCount,String s,int n,int[][] memo){
        //Base case
        if(index == n) return openCount == 0;
        //look inside memo to avoid re-computation.
        if(memo[index][openCount] != -1) return memo[index][openCount] == 1;
        boolean isValid = false;
        char curr = s.charAt(index);
        if(curr == '*'){
            isValid |= solve(index+1,openCount+1,s,n,memo);//treating * as single left parentheses.
            isValid |= solve(index+1,openCount,s,n,memo);//treating * as empty string.
            if(openCount > 0){
                isValid |= solve(index+1,openCount-1,s,n,memo);//treating * as single right parentheses.
            }
        }else if(curr == '('){
            isValid |= solve(index+1,openCount+1,s,n,memo);
        }else if(openCount > 0){
            //If it is not * or '(' then it is ')' for sure.
            isValid |= solve(index+1,openCount-1,s,n,memo);
        }
        // Save result in memo (1 for true, 0 for false)
        memo[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }
    //Using stack
    public static boolean checkValidStringII(String s) {
        int n = s.length();
        Deque<Integer> openStack = new ArrayDeque<>();
        Deque<Integer> asterisk = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openStack.push(i);
            }else if(ch == '*'){
                asterisk.push(i);
            }else{
                //If it is a ')'
                if(!openStack.isEmpty()){
                    openStack.pop();
                }else if(!asterisk.isEmpty()){
                    asterisk.pop();
                }
            }
        }
        //if String s = "*(())(*"
        while(!openStack.isEmpty() && !asterisk.isEmpty()){
            if(openStack.peek() > asterisk.peek()){
                return false;
            }
            openStack.pop();
            asterisk.pop();
        }
        return openStack.isEmpty();
    }
}

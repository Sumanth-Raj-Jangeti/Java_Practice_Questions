package com.strings.practice;

import java.util.*;

public class GenerateParentheses_LC22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(new StringBuilder(),n,result);
        return result;
    }
    private static void solve(StringBuilder curr,int n,List<String> result){
        //Base case
        if(curr.length() == 2*n){
            if(isValid(curr)){
                result.add(curr.toString());
            }
            return;
        }
        //Append Open parentheses.
        curr.append("(");
        solve(curr,n,result);
        curr.deleteCharAt(curr.length() - 1);//Backtracking
        //Append close parentheses.
        curr.append(")");
        solve(curr,n,result);
        curr.deleteCharAt(curr.length() - 1);//Backtracking
    }
    private static boolean isValid(StringBuilder sbl){
        int count = 0;
        for(int i=0;i<sbl.length();i++){
            char ch = sbl.charAt(i);
            if(ch == '(') count++;
            else count--;
            //handles the case where we encounter a closing bracket, but there is no corresponding opening bracket available. ex: "())("
            if(count < 0) return false;
        }
        return (count == 0);
    }
}
//Refer optimal solution on LC.
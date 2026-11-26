package com.strings.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses_LC20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid2(s));
    }
    public static boolean isValid1(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();//Creating a stack using Deque interface.
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(ch == ')' && top != '(') return false;
                if(ch == '}' && top != '{') return false;
                if(ch == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValid2(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.peek() != ch){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

package com.strings.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumInsertionsToBalanceParenthesesString_LC1541 {
    public static void main(String[] args) {
        String s = "))())(";
        System.out.println(minInsertions2(s));
    }
    public static int minInsertions1(String s) {//TC: O(n) & SC: O(n)
        Deque<Character> stack = new ArrayDeque<>();
        int insertions=0,n=s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                // We found ')' & checking whether next character available in string.
                if (i + 1 < n && s.charAt(i + 1) == ')') {// Found a pair of closing brackets
                    i++;
                } else {
                    // Insert one ')' to complete the pair
                    insertions++;
                }
                if (!stack.isEmpty()) {//for Strings like s = '))'
                    stack.pop();
                } else {
                    // Insert '(' to match the closing pair
                    insertions++;
                }
            }
        }
        // Each leftover '(' on the stack needs two ')'
        insertions += stack.size() * 2;
        return insertions;
    }
    public static int minInsertions2(String s) {//TC: O(n) & SC: O(1)
        int n = s.length(), openBrackets = 0, insertions = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBrackets++;
            } else {// We found ')' & checking whether next character available in string.
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert one ')' to complete the pair.
                    insertions++;
                }
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    // Insert one '(' to match these closing brackets.
                    insertions++;
                }
            }
        }
        // Each remaining '(' requires two closing brackets.
        insertions += openBrackets * 2;
        return insertions;
    }
}

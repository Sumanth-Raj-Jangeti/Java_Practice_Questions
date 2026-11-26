package com.strings.practice;

import java.util.ArrayList;
import java.util.List;

public class ScoreOfParentheses_LC856 {
    public static void main(String[] args) {
        String s = "(((())))()(())";
        int score = scoreOfParentheses(s);
        System.out.println(score);
    }
    public static int scoreOfParentheses(String s) {
        int n = s.length(),score = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                list.add(score);
                score = 0;
            }else{ //char at current index is ')', then check its previous char...
                if(s.charAt(i-1) == '('){//This is the case: "()" has score 1.
                    score = list.getLast() + 1;
                }else{//if previous char is not '(' then it is nested for sure.
                    score = list.getLast() + (2 * score);
                }
                list.remove(list.size() - 1);
            }
        }
        return score;
    }
}

package com.strings.practice;

public class CalculateDigitSum_of_a_string {
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223",3));
    }
    public static String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder result = new StringBuilder();
            for(int start=0; start<s.length(); start+=k){
                int end = Math.min(start+k,s.length());
                String group = s.substring(start,end);
                int digitSum = 0;
                for(int i=0;i<group.length();i++){
                    digitSum += group.charAt(i) - '0';// Subtracting '0' (ASCII 48) yields the exact numeric digit
                }
                result.append(digitSum);//appending to the result.
            }
            s = result.toString();//updating s with
        }
        return s;
    }
}

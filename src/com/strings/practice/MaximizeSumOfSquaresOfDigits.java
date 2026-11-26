package com.strings.practice;

public class MaximizeSumOfSquaresOfDigits {
    public static void main(String[] args) {
        System.out.println(maxSumOfSquares2(2,3));
    }
    public static String maxSumOfSquares1(int num, int sum) {
        if(sum > num * 9) return "";
        int totalPossibleNines = sum / 9, remains = sum % 9;
        StringBuilder result = new StringBuilder();
        //filling left most digits with 9s.
        for(int i=0;i<totalPossibleNines;i++){
            result.append('9');
        }
        //filling remains...
        if(remains > 0){
            result.append(remains);
        }
        //filling remaining digit positions with 0s.
        while(result.length() < num){
            result.append('0');
        }
        return result.toString();
    }
    public static String maxSumOfSquares2(int num, int sum) {
        if(sum > num * 9) return "";
        int totalPossibleNines = sum / 9, remains = sum % 9;
        StringBuilder result = new StringBuilder();
        //filling left most digits with 9s.
        result.repeat("9",totalPossibleNines);
        //filling remains...
        if(remains > 0) result.append(remains);
        //filling remaining digit positions with 0s.
        result.repeat("0", num - result.length());
        return result.toString();
    }
}
//The if block checks if the required sum is impossible to achieve given the constraint on the total number of digits (num).
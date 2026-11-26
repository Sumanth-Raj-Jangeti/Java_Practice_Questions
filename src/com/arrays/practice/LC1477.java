package com.arrays.practice;

import java.util.Arrays;

public class LC1477 {
    private static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] arr = {7,3,4,7};
        int target = 7;
        System.out.println(minSumOfLengths(arr,target));
    }
    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length,i=0,j=0;
        int[] minLenSubArrBefore_i = new int[n];
        Arrays.fill(minLenSubArrBefore_i,MAX);
        int currSum = 0,bestMinLen = MAX,result = MAX;
        while(j<n){
            currSum += arr[j];
            while(i<j && currSum > target){
                currSum -= arr[i++];
            }
            if(currSum == target){
                int len = j-i+1;//currSubArrLength
                if(i>0 && minLenSubArrBefore_i[i-1]!=MAX){
                    result = Math.min(result,len + minLenSubArrBefore_i[i-1]);
                }
                bestMinLen = Math.min(bestMinLen,len);
            }
            minLenSubArrBefore_i[j] = bestMinLen;
            j++;
        }
        return (result == MAX) ? -1 : result;
    }
}

package com.arrays.practice;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1,0,0,0,0,1,1,1,1};
        System.out.println("Max Consecutive Ones:"+findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] arr)
    {
        //Declare & Initialize 2 var's.
        int maxConsecutives=0,curr_count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                curr_count++;
            }
            else{
                maxConsecutives=Math.max(maxConsecutives,curr_count);
                curr_count=0;
            }
        }
        return Math.max(maxConsecutives,curr_count);
    }
}

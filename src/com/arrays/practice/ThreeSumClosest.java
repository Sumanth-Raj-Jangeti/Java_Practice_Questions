package com.arrays.practice;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr={-1,2,1,-4};
        int target=1;
        int result = threeSumClosest(arr, target);
        System.out.println("Closest sum to target is: " + result);
    }
    public static int threeSumClosest(int[] arr,int target)
    {
        //By Using Sorting + Two Pointers --> TC:O(n^2) & SC:O(1)
        //Sort the given array.
        Arrays.sort(arr);
        int closestSum=arr[0]+arr[1]+arr[2];
        int minDifference=Integer.MAX_VALUE; //Largest possible int value i.e 2147483647
        //we need to iterate over the given array.
        for(int i=0;i<arr.length-2;i++)
        {
            //Declare & Initialize 2 pointers.
            int left=i+1;
            int right=arr.length-1;
            while(left<right)
            {
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==target) return sum; //Early Exit
                int diffToTarget=Math.abs(sum-target);
                if(diffToTarget < minDifference)
                {
                    //Update the closestSum
                    closestSum=sum;
                    minDifference=diffToTarget;
                }
                //Move pointers...
                if(sum<target)
                {
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return closestSum;
    }
}

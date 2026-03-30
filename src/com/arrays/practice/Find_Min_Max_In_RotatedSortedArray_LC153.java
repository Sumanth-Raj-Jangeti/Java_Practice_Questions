package com.arrays.practice;

public class Find_Min_Max_In_RotatedSortedArray_LC153 {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println("Minimum:"+findMin(nums));
        System.out.println("Maximum:"+findMax(nums));
    }
    public static int findMin(int[] nums)
    {
        //TC:O(log n) & SC:O(1)
        //Declare & initialize var's
        int low=0,high=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //Check which part of the array is sorted --> is it left/right ??
            if(nums[low]<=nums[mid])
            {
                //left part is sorted.
                //Find the min element from this part & store it.
                min=Math.min(min,nums[low]);
                low=mid+1; //removing left half
            }
            else
            {
                //right part is sorted.
                //Find the min element from this part & store it.
                min=Math.min(min,nums[mid]);
                high=mid-1;
            }
        }
        return min;
    }
    public static int findMax(int[] nums)
    {
        //TC:O(log n) & SC:O(1)
        //Declare & initialize var's
        int low=0,high=nums.length-1;
        int max =Integer.MIN_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //Check which part of the array is sorted --> is it left/right ??
            if(nums[low]<=nums[mid])
            {
                //left part is sorted.
                //Find the max element from this part & store it.
                max =Math.max(max,nums[mid]);
                low=mid+1; //removing left half
            }
            else
            {
                //right part is sorted.
                //Find the max element from this part & store it.
                max =Math.max(max,nums[high]);
                high=mid-1;
            }
        }
        return max;
    }
}

package com.arrays.practice;

import java.util.Arrays;

public class FindOut_HowManyTimesArrayHasRotated {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int[] res=findRotations(arr);
        System.out.println("Minimum Element:"+res[0]+"\nNo.of.Rotations:"+res[1]);
    }
    public static int[] findRotations(int[] nums)
    {
        //TC:O(log n) & SC:O(1)
        //Declare & initialize var's
        int low=0,high=nums.length-1;
        int min=Integer.MAX_VALUE;
        int index=-1; //Counts how many times array has rotated
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //Check which part of the array is sorted --> is it left/right ??
            if(nums[low]<=nums[mid])
            {
                //left part is sorted.
                //Find the min element from this part & store it.
                if(nums[low]<min)
                {
                    min=nums[low];
                    index=low;
                }
                low=mid+1; //removing left half
            }
            else
            {
                //right part is sorted.
                //Find the min element from this part & store it.
                if(nums[mid]<min)
                {
                    min=nums[mid];
                    index=mid;
                }
                high=mid-1;
            }
        }
        return new int[]{min,index};
    }
}

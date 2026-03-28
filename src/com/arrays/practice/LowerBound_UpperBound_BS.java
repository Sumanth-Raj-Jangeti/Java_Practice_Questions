package com.arrays.practice;

public class LowerBound_UpperBound_BS {
    public static void main(String[] args) {
        int[] arr={5,6,6,7,7,8,8,8,9};
        int target=8;
        System.out.println("Lower Bound:"+lowerBound(arr,target));
        System.out.println("Upper Bound:"+upperBound(arr,target));
    }
    public static int lowerBound(int[] arr,int target)
    {
        //Declare & initialize 2 var's.
        int low=0,high=arr.length-1;
        int lb=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target)
            {
                lb=mid;
                //Look for more small index on left part
                high=mid-1;
            }
            else{
                //look on right part
                low=mid+1;
            }
        }
        return lb;
    }
    public static int upperBound(int[] arr,int target)
    {
        //Declare & initialize 2 var's.
        int low=0,high=arr.length-1;
        int ub=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target)
            {
                ub=mid;
                //Look for more small index on left part
                high=mid-1;
            }
            else{
                //look on right part
                low=mid+1;
            }
        }
        return ub;
    }
}

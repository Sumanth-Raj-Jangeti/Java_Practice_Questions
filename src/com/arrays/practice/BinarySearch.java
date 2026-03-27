package com.arrays.practice;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={-1,0,3,5,9,12};
        int target=9;
        System.out.println("Element Found at index:"+search(arr,target));
    }
    public static int search(int[] arr,int target)
    {
        //Declare & Initialize 2 var's.
        int low=0,high=arr.length-1;
        while(low <= high)
        {
            //Compute mid value...
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}

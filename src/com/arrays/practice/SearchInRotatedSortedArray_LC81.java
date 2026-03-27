package com.arrays.practice;

public class SearchInRotatedSortedArray_LC81 {
    public static void main(String[] args) {
        int[] arr={2,5,6,0,0,1,3};
        int target=0;
        System.out.println("target is in arr? "+search(arr,target));
    }
    public static boolean search(int[] arr,int target)
    {
        //Declare & initialize 2 var's.
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
                return true;
            //To avoid duplicates --> we just shrink the array...
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            //Now,we'll check which part of the array is sorted.
            if(arr[low]<=arr[mid]) //left part
            {
                //check if target falls in left part or not.
                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}

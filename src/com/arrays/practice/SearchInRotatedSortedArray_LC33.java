package com.arrays.practice;

public class SearchInRotatedSortedArray_LC33 {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int target=0;
        System.out.println("Element found at index:"+search(arr,target));
    }
    public static int search(int[] arr,int target)
    {
        //Declare & initialize 2 var's
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
                return mid;
            //Now, we'll check which part of the array is sorted...
            if(arr[low]<=arr[mid])//left is sorted.
            {
                //Check whether target falls in this part or not.
                if(arr[low]<=target && target<=arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else
            {
                //Check whether target falls in this part or not.
                if(arr[mid]<=target && target<=arr[high])
                    low=mid+1;
                else
                    high=mid+1;
            }
        }
        return -1;
    }
}

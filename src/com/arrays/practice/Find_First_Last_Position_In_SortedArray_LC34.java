package com.arrays.practice;

import java.util.Arrays;

public class Find_First_Last_Position_In_SortedArray_LC34 {
    public static void main(String[] args) {
        int[] arr={5,6,6,7,7,8,8,8,8,8,9};
        int target=8;
        int[] result=searchRange(arr,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] searchRange(int[] arr, int target) {
        int first=findFirst(arr,target);
        if(first==-1) return new int[]{-1,-1};
        int last=findLast(arr,target);
        return new int[]{first,last};
    }
    public static int findFirst(int[] arr,int target){
        int low=0,high=arr.length-1;
        int first=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                first=mid;
                //Since we are finding 1st occurrence --> mostly this shd be in left part.
                high=mid-1;
            }
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return first;
    }
    public static int findLast(int[] arr,int target){
        int low=0,high=arr.length-1;
        int last=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                last=mid;
                //Since we are finding last occurrence --> mostly this shd be in right part.
                low=mid+1;
            }
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return last;
    }
}

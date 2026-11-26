package com.sorting.practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,2,1,7,2,1,2};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    /**
     Conceptually, a merge sort works as follows:
     Divide the unsorted list into n sub-lists, each containing one element (a list of one element is considered sorted).
     Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.
     Merge sort is efficient because merging and sorting two sublists can be performed in linear time, provided that the sublists are already sorted.*/
    public static void sort(int[] arr, int low, int high){
        if(low>=high) return;//"If this part has one element or no elements, stop recursion."
        int mid = low + (high - low) / 2;
        sort(arr,low,mid);
        sort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private static void merge(int[] arr,int low,int mid,int high){
        //Creating temp[].
        int[] temp = new int[high - low + 1];
        int k=0;//A new index to overwrite array elements.
        int left=low,right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left] <= arr[right]){
                temp[k++] = arr[left++];
            }else{
                temp[k++] = arr[right++];
            }
        }
        //Handling left over elements.
        while(left<=mid){
            temp[k++] = arr[left++];
        }
        while(right<=high){
            temp[k++] = arr[right++];
        }
        //Overwriting original array elements with temp elements.
        for(int i=0;i<temp.length;i++){
            arr[low+i] = temp[i];
        }
        //System.arraycopy(temp, 0, arr, low, temp.length);
    }
}

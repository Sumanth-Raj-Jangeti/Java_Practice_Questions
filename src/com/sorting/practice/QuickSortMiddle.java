package com.sorting.practice;

import java.util.Arrays;

public class QuickSortMiddle {
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,2,1,7,2,1,2};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int low, int high) {
        // Base case: if the array is empty, null, or fully partitioned
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }
        // 1. Use pivot as Middle element
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        // 2. Set up pointers for partitioning
        int i = low;
        int j = high;
        while (i <= j) {
            //i walks forward looking for an element GREATER than the pivot
            while (arr[i] < pivot) {
                i++;
            }
            //j walks forward looking for an element LESSER than/equal to the pivot
            while (arr[j] > pivot) {
                j--;
            }
            // Swap the elements and move the pointers inward
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // 3. Recursively sort the left and right sub-arrays
        if (low < j) {
            sort(arr, low, j);
        }
        if (high > i) {
            sort(arr, i, high);
        }
    }
}

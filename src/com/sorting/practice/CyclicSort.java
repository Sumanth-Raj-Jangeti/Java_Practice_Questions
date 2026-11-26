package com.sorting.practice;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,3,1,4,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int i = 0;
        while (i < arr.length) {
            // Find the targeted correct index for the current value
            int correctIdx = arr[i] - 1;
            // Swap if the element is not at its correct position
            if (arr[i] != arr[correctIdx]) {
                swap(arr, i, correctIdx);
            } else {
                i++; // Only move forward if the correct element is in place
            }
        }
    }
    public static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

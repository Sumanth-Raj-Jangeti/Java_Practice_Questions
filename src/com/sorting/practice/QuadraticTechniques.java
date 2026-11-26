package com.sorting.practice;

import java.util.Arrays;

public class QuadraticTechniques {
    /*
    * Outer loop: “i represents the current position where the next smallest element should be placed. After each iteration, positions 0 to i become sorted.”
    * Inner loop: “I scan the remaining unsorted elements from i+1 to n-1. Whenever I find a smaller element, I update minIndex. At the end of this loop, minIndex stores the index of the smallest element in the unsorted part.”
    * “I swap the smallest element with the element at position i, so the smallest unsorted element moves to its correct sorted position.”*/
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;//Initially I assume the current element is the minimum.
            //Find the minimum
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    /*
     * “Outer loop controls the number of passes. In the worst case we need n - 1 passes to sort n elements.”
     * “I used a swapped flag to detect whether any swap happened during the current pass. If no swap happens, the array is already sorted, so we can stop early.”
     * “The inner loop compares adjacent elements. I use n - 1 - i because after each pass the last i elements are already in their correct positions, so I avoid unnecessary comparisons.”
     * “If the current element is greater than the next element, they are in the wrong order for ascending sorting, so I swap them. After swapping, I set swapped = true.”
     * “If no swap occurred in the entire pass, the array is already sorted, so I break out of the loop. This improves the best-case time complexity.”
     * */
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swap occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
    public static void insertionSortUsingSwapping(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            //Repeatedly swap the element with its left neighbor
            //as long as the left neighbor is larger.
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void insertionSortUsingShifting(int[] arr){
        //Start with the second element.
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void insertionSortRecursive(int[] arr,int n){
        if(n<=1) return;
        insertionSortRecursive(arr,n-1);
        // Insert last element
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6};
        System.out.println(Arrays.toString(arr));
    }
}
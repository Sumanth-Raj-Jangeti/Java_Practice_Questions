package com.collections.practice;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        sortArray(arr);
        System.out.println("Maximum Sum for m=4: " + findMaxSum(arr, 4));
        System.out.println("Minimum Sum for m=3: " + findMinSum(arr, 3));
    }
    public static void sortArray(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    //Swapping
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static int findMaxSum(int[] arr, int m) {
        // Correct condition
        if (arr.length < m) {
            return 0;
        } else {
            int sum = 0;
            // Take last m elements
            for (int i = arr.length - 1; i >= arr.length - m; i--) {
                sum += arr[i];
            }
            return sum;
        }
    }
    public static int findMinSum(int[] arr, int m) {
        if (arr.length < m) {
            return 0;
        } else {
            int sum = 0;
            // Take first m elements
            for (int i = 0; i < m; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }
}



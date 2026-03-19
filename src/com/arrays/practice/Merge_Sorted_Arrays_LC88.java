package com.arrays.practice;

import java.util.Arrays;

public class Merge_Sorted_Arrays_LC88 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        int m=3;
        int n=3;
        merge(arr1,arr2,m,n);
        System.out.println(Arrays.toString(arr1));
        //merge(new int[]{0},new int[]{1},0,1);
    }
    public static void merge(int[] arr1,int[] arr2,int m,int n)
    {
        //Declare and Initialize 3 variables.
        int i=m-1;
        int j=n-1;
        int k=m+n-1; //This is our write --> we insert elements using this variable
        while(i>=0 && j>=0)
        {
            if(arr1[i] > arr2[j])
            {
                arr1[k--]=arr1[i--];
            }
            else{
                arr1[k--]=arr2[j--];
            }
        }
        while(j>=0)
        {
            arr1[k--]=arr2[j--];
        }
    }
}

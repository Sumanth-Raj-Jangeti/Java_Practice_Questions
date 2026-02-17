package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr1={10,20,30,-30,40,50};
        int[] arr2={10,20,30,-30,40,-30,50}; // {10,20,30,40,50}
        int elementToBeDeleted=-30;
        delete(arr1,elementToBeDeleted);
        deleteAll(arr2,elementToBeDeleted);
    }
    public static void delete(int[] arr,int elementToBeDeleted)
    {
        //Method 1. Here will be shifting elements to left & we'll skip the last element...
        //Limitations: If "elementTobeDeleted" value occurs more than once, then only the 1st repeated is deleted.
        System.out.println("\nDELETE ELEMENT:");
        boolean ele_Found=false;//To handle edge case.

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==elementToBeDeleted)
            {
                for(int j=i;j<arr.length-1;j++)
                {
                    //Shift elements to left...
                    arr[j]=arr[j+1]; // Therefore given array is modified to {10,20,30,40,50,50}
                }
                ele_Found=true;
                break;
            }
        }
        if(!ele_Found){
            System.out.println("Element Not Found");
            return; //control exits from the user-defined method.
        }
        System.out.println("Element Deleted Successfully");
        for(int i=0;i<arr.length-1;i++)//We're skipping the last element.
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void deleteAll(int[] arr,int elementToBeDeleted)
    {
        //Method 2. Here we'll delete all occurrences for "elementToBeDeleted"
        System.out.println("\n\nDELETE ALL OCCURRENCES:");
        int k=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=elementToBeDeleted)
            {
                arr[k]=arr[i];
                k++;
            }
        }
        if(k==arr.length)
        {
            System.out.println("Element Not Found");
            return;
        }
        System.out.println("Element deleted successfully");
        for(int i=0;i<k;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}

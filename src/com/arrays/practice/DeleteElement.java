package com.arrays.practice;

import java.util.Arrays;
import java.util.HashSet;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr1={10,20,30,-30,40,50};
        int[] arr2={10,20,30,-30,40,-30,50}; // {10,20,30,40,50}
        int elementToBeDeleted=-30;
        delete(arr1,elementToBeDeleted);
        deleteAll(arr2,elementToBeDeleted);
        deleteElement(new int[]{10,20,30,-30,40,-30,50},elementToBeDeleted);
        deleteMultipleElements_directValues(new int[]{1,2,2,3,4,5,2,2,6,6},new int[]{2,6,3});
        deleteMultipleElements_Indexes(new int[]{10,20,30,40,50,60},new int[]{1,3});
        deletion(new int[]{10,20,30,40,50},new int[]{3,1});
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
        //Method 2. Here we'll delete all occurrences for "elementToBeDeleted" --> TC:O(n) & SC:O(1)
        System.out.println("\n\nDELETE ALL OCCURRENCES:");
        int k=0; //new index for overwriting array elements.
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
    public static void deleteElement(int[] arr,int elementToBeDeleted)
    {
        //TC:O(n) & SC:O(n)
        System.out.println("\n\nCreating a new Array --> (Not-in-place)");
        //Creating a new array - Store only remaining elements
        int[] newArr=new int[arr.length - 1]; //We need to delete one element
        for(int i=0,j=0;i<arr.length;i++)
        {
            if(arr[i]!=elementToBeDeleted)
            {
                newArr[j++]=arr[i];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
    public static void deleteMultipleElements_directValues(int[] arr, int[] elementsToBeDeleted)
    {
        //Here, we'll delete multiple elements from the array with respect to the given values...
        System.out.println("\nAfter Deleting Multiple Elements:");
        int k=0;//new index for overwriting array elements.
        for(int i=0;i<arr.length;i++)
        {
            boolean isEqual=false;
            for(int j=0;j<elementsToBeDeleted.length;j++)
            {
                if(arr[i]==elementsToBeDeleted[j])
                {
                    isEqual=true;
                    break;
                }
            }
            if(!isEqual)
            {
                arr[k++]=arr[i];
            }
        }
        for(int i=0;i<k;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void deleteMultipleElements_Indexes(int[] arr,int[] elementsToBeDeleted)
    {
        //Here, we'll delete multiple elements from the array with respect to the given indexes...
        System.out.println("\nAfter Deleting Multiple Elements:");
        HashSet<Integer> set = new HashSet<>();
        // Store indexes to delete
        for (int i = 0; i < elementsToBeDeleted.length; i++) {
            set.add(elementsToBeDeleted[i]);
        }
        int newSize = 0;
        // One single pass
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(i)) {
                arr[newSize++] = arr[i];
            }
        }
        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void deletion(int[] arr,int[] deleteIndex)
    {
        System.out.println("\n\nHASHSET APPROACH:");
        HashSet<Integer> set = new HashSet<>();
        //Store indexes to delete.
        for(int num:deleteIndex)
        {
            set.add(num);
        }
        int k=0;//new index
        for(int i=0;i<arr.length;i++)
        {
            if(!set.contains(i))
            {
                arr[k++]=arr[i];
            }
        }
        //display
        for(int i=0;i<k;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}

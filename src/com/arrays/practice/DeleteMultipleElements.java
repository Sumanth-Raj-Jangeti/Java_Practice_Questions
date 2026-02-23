package com.arrays.practice;

import java.util.HashSet;

public class DeleteMultipleElements {
    public static void main(String[] args) {
        deleteMultipleElements_directValues(new int[]{1,2,2,3,4,5,2,2,6,6},new int[]{2,6,3});
        deleteMultipleElements_Indexes(new int[]{10,20,30,40,50,60},new int[]{1,3});
        deletion(new int[]{10,20,30,40,50},new int[]{3,1});
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

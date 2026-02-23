package com.arrays.practice;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, -30, 40, 50};
        int[] arr2 = {10, 20, 30, -30, 40, -30, 50}; // {10,20,30,40,50}
        int elementToBeDeleted = -30;
        delete(arr1, elementToBeDeleted);
        deleteAllOccOfSingleElement(arr2, elementToBeDeleted);
        deleteAllOccOfMultipleElements(new int[]{10, 20, 30, -30, 40, -30, 50, 20}, new int[]{20, -30});
        deletion(new int[]{10, 20, 30, -30, 40, -30, 50, 20}, new int[]{20, -30});
    }

    public static void delete(int[] arr, int elementToBeDeleted) {
        //Method 1. Here we'll be shifting elements to left & we'll skip the last element...
        //Limitations: If "elementTobeDeleted" value occurs more than once, then only the 1st occurrence is deleted.
        //This is a basic approach.
        System.out.println("\nDELETE ELEMENT:");
        boolean ele_Found = false;//To handle edge case.

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementToBeDeleted) {
                for (int j = i; j < arr.length - 1; j++) {
                    //Shift elements to left...
                    arr[j] = arr[j + 1]; // Therefore given array is modified to {10,20,30,40,50,50}
                }
                ele_Found = true;
                break;
            }
        }
        if (!ele_Found) {
            System.out.println("Element Not Found");
            return; //control exits from the user-defined method.
        }
        System.out.println("Element Deleted Successfully");
        for (int i = 0; i < arr.length - 1; i++)//We're skipping the last element.
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static void deleteAllOccOfSingleElement(int[] arr, int elementToBeDeleted) {
        //Method 2. Here we'll delete all occurrences for "elementToBeDeleted" --> TC:O(n) & SC:O(1)
        System.out.println("\n\nDELETE ALL OCCURRENCES(for single element):");
        int k = 0; //new index for overwriting array elements.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != elementToBeDeleted) {
                arr[k] = arr[i];
                k++;
            }
        }
        System.out.println("Elements deleted successfully");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void deleteAllOccOfMultipleElements(int[] arr, int[] elementsToBeDeleted) {
        //TC:O(n*m) & SC:O(1)
        System.out.println("\n\nDELETE ALL OCCURRENCES(for multiple elements):");
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < elementsToBeDeleted.length; j++) {
                if (arr[i] == elementsToBeDeleted[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                arr[k] = arr[i];
                k++;
            }
        }
        System.out.println("Elements deleted successfully");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        /*
            A HashSet Approach:
            HashSet<Integer> set = new HashSet<>();
            for(int num:elementsToBeDeleted)
            {
                set.add(num);
            }
            int k=0;
            for(int i=0;i<arr.length;i++)
            {
                if(!set.contains(arr[i])
                {
                    arr[k]=arr[i];
                    k++;
                }
            }
            for(int i=0;i<k;i++)
            {
                 print(arr[i]+" ");
            }
        */
    }

    public static void deletion(int[] arr, int[] delete) {
        //A program to delete the first occurrence of a given element & also delete all occurrences of other element in the array.
        System.out.println("\n\nDELETE 1ST OCCURRENCE OF 1ST GIVEN ELEMENT & ALL OCCURRENCES OF 2ND GIVEN ELEMENT:");
        int k = 0;
        boolean deleteFirst20 = false;
        //we need to iterate over the given array.
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            //delete only first 20.
            if (arr[i] == delete[0] && !deleteFirst20) {
                deleteFirst20 = true;
                found = true;
            }
            //delete all occurrences of -30.
            if (arr[i] == delete[1]) {
                found = true;
            }
            if (!found) {
                arr[k] = arr[i];
                k++;
            }
        }
        //fill remaining elements with 0
        while (k < arr.length) {
            arr[k] = 0;
            k++;
        }
        System.out.println("Elements deleted successfully");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

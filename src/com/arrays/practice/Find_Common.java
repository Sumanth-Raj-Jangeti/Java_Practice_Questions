package com.arrays.practice;

import java.util.Arrays;
import java.util.HashSet;

public class Find_Common {
    public static void main(String[] args) {
        //A program to find the common elements in 2 arrays...
        int[] a = {1, 4, 6, 5, 2, 1, 7, 2, 1, 2};
        int[] b = {2, 2, 4, 4, 5, 5};
        commonEle(a, b); //Method Call
        commonUniqueEle(a, b);//Method Call
        System.out.println("\nCommon Elements(using Sorting + 2 pointers):");
        findCommonEle(a, b);//Method Call
        int[] c = {1, 4, 6, 5, 2, 1, 7, 2, 1, 2};
        int[] d = {2, 2, 4, 4, 5, 5};
        System.out.println("\nUnique Common Elements(using Sorting + 2 pointers):");
        findUniqueCommonEle(c, d);//Method Call
        int[] e={1,4,6,5,2,1,7,2,1,2};
        int[] f={2,2,4,4,5,5};
        System.out.println("\nCommon Elements(using HashSet):");
        getCommonEle(e,f);//Method Call
    }

    public static void commonEle(int[] arr1, int[] arr2) {
        //1. Nested Approach --> TC:O(n * m) & SC:O(1) - This approach also prints duplicates.
        System.out.println("Common Elements(Nested Loops):");
        for (int x : arr1) {
            for (int y : arr2) {
                if (x == y) {
                    System.out.print(x + " ");
                    break;
                }
            }
        }
    }

    public static void commonUniqueEle(int[] arr1, int[] arr2) {
        //2. Nested Approach --> TC:O(n * m) & SC:O(1) - This method avoids printing the same duplicates again.
        System.out.println("\nCommon Elements(Nested Loops with a feature):");
        for (int i = 0; i < arr1.length; i++) //TC:O(n)
        {
            boolean alreadyChecked = false;
            //Check if arr1[i] has appeared before.
            for (int k = 0; k < i; k++)      //TC:O(n)
            {
                if (arr1[k] == arr1[i]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked)
                continue;
            for (int j = 0; j < arr2.length; j++)  //TC:O(m)
            {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
    }

    public static void findCommonEle(int[] arr1, int[] arr2) {
        //3. Using Sorting + 2 Pointers --> TC:O(n log n + m log m) & SC:O(1) - This approach also prints duplicates...
        //Step-1 Sort the arrays
        Arrays.sort(arr1); //TC:O(n log n)
        Arrays.sort(arr2); //TC:O(m log m)
        //Step-2 Declare & initialize 2 vars...
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) //TC:O(n+m)
        {                                           //So, the exact TC is:O(n log n) + O(m log m) + O(n+m)
            if (arr1[i] == arr2[j])                 //when simplifying TC always keep the term that grows the
            {                                       //fastest and drop the rest.
                System.out.print(arr1[i] + " ");    //Overall TC : O(n log n + m log m)
                i++;                                //Note: After execution of this method original arrays are modified
                j++;                                // So it'll better if start working on new arrays.
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }

    public static void findUniqueCommonEle(int[] arr1, int[] arr2) {
        //4. Using Sorting + 2 Pointers --> TC:O(n log n + m log m) & SC:O(1) - This approach also avoids duplicates...
        //Step-1 Sort the arrays
        Arrays.sort(arr1); //TC:O(n log n)
        Arrays.sort(arr2); //TC:O(m log m)
        //Step-2 Declare & initialize 2 vars...
        int i = 0, j = 0;
        Integer lastprinted = null; //This is a wrapper class for primitive type -> int
        //Here, null means "no value yet"
        while (i < arr1.length && j < arr2.length)
        {
            if(arr1[i]==arr2[j])
            {
                if(lastprinted==null||arr1[i]!=lastprinted)
                {
                    System.out.print(arr1[i]+" ");
                    lastprinted=arr1[i];
                }
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j])
            {
                i++;
            }
            else {
                j++;
            }
        }
    }
    public static void getCommonEle(int[] arr1,int[] arr2)
    {
        HashSet<Integer> set = new HashSet<>();
        //Adding arr1 elements in set.
        for(int num:arr1)
        {
            set.add(num);
        }
        for(int num:arr2)
        {
            if(set.contains(num))  //Check if number present in arr1 -> If yes, it is a common element then print it...
            {
                System.out.print(num+" ");
                set.remove(num); //Avoids printing duplicates
            }
        }
    }
}

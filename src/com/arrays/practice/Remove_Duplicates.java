package com.arrays.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Remove_Duplicates {
    public static void main(String[] args) {
        //A program to remove duplicates from an array...
        int[] arr={1,4,6,5,2,1,7,2,1,2}; // Unsorted Array
        int[] arr2={1,4,6,5,2,1,7,2,1,2};
        int[] uniqueArr= removeDuplicates(arr);    //Method Call - Nested Approach
        System.out.println("Array after removing duplicates(NESTED LOOPS):"+Arrays.toString(uniqueArr));
        deleteDuplicates(arr);       //Method Call - Sorting+scan
        uniqueElements(arr2);        //Method Call - HashSet Approach
        uniqueEle(arr2);             //Method Call - HashMap Approach
        findUniqueElements(arr2);    //Method Call - Freq[] Approach
        clearDuplicates(arr);       //Method Call - Index Marking Approach
    }
    public static int[] removeDuplicates(int[] arr) //By using Nested Loops
    {                                               //TC:O(n^2) & SC:O(n)
                                                    //Can also be done in O(1) SC.
       //Creating a temp[] to store unique elements...
        int[] temp=new int[arr.length];
        int uniqueCount=0;
        for (int k : arr) {
            boolean isDuplicate = false;
            //Check if the current element already exists in temp[].
            for (int j = 0; j < uniqueCount; j++) {
                if (k == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            //If it is not a duplicate then add it to temp[].
            if (!isDuplicate) {
                temp[uniqueCount++] = k;
            }
        }
        return Arrays.copyOf(temp,uniqueCount);
    }
    public static void deleteDuplicates(int[] arr)
    {
        //By using sorting+scan approach...
        //TC:O(n log n) & SC:O(1)
        //A better approach-when compared with Nested Loops.
        //But original order is not maintained.
        Arrays.sort(arr); //Sort the given array->By default Dual Pivot QuickSort is performed.
        int j=0;
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i]!=arr[j])
            {
                arr[++j]=arr[i];
            }
        }
        System.out.println("\nArray after removing duplicates(SORTING+SUM):");
        for (int i = 0; i <=j; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void uniqueElements(int[] arr)
    {
        //A HashSet approach-> TC:O(n) & SC:O(n)
        //By default HashSet doesn't preserve insertion order. To preserve insertion order then we need to LinkedHashSet.
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        for(int numbers:arr)
        {
            set.add(numbers);
        }
        System.out.print("\nArray after removing duplicates(HASHSET):"+set);
    }
    public static void uniqueEle(int[] arr)
    {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int num:arr)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        System.out.println("\nafter duplicates removal(HASHMAP):");
        for(int key: map.keySet())
        {
            System.out.print(key+" ");
        }
    }
    public static void findUniqueElements(int[] arr)
    {
        //By using freq[]. TC:O(n) & SC:O(n)
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        //Creating a freq[]
        int[] freq=new int[max+1];
        //Storing freq's of each element in freq[].
        for(int i=0;i< arr.length;i++)
        {
            freq[arr[i]]++;
        }
        System.out.println("\nfreq[]:"+Arrays.toString(freq));
        System.out.println("Array after removing duplicates(FREQ ARRAY):");
       /* for(int i=0;i< freq.length;i++) //It doesn't preserve the original order
        {
            if(freq[i]>0)
            {
                System.out.print(i+" ");
            }
        }*/
        for(int i=0;i<arr.length;i++) //Preserves the original order
        {
            if(freq[arr[i]]>0)
            {
                System.out.print(arr[i]+" ");
                freq[arr[i]]=0; //Avoid printing the same duplicates again
            }
        }
    }
    public static void clearDuplicates(int[] arr)
    {
        //By using Index Marking -> TC:O(n) & SC:O(1)
        //index marking only works if :
        //all elements are +ves.
        //all elements shd be strictly less than the array's length.
        //Insertion order is not preserved.
        System.out.println("\nArray after removing duplicates(Index Marking):");
        for(int i=0;i< arr.length;i++)
        {
            int index=Math.abs(arr[i]);
            if(index< arr.length && arr[index]>0)
            {
                System.out.print(index+" ");
                arr[index]=-arr[index];
            }
        }
    }
}

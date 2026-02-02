package com.arrays.practice;

import java.util.*;

public class Find_Frequency_intArr {
    public static void main(String[] args) {
        int[] arr1={1,4,6,5,2,1,7,2,1,2};
        freq(arr1);
        int[] temp={1,4,6,5,2,1,7,2,1,2};
        frequency(temp);
        int[] arr2={1,4,6,5,2,1,7,2,1,2,-1,-1,-1,-2,-2,-3};
        getFrequencies(arr2);
        findFrequencies(arr2);
        printFrequencies(arr2);
    }
    public static void freq(int[] arr)
    {
        //Method 1. Using Nested Loops --> TC:O(n^2) & SC:O(1)
        //--> This method works for both +ve and -ve no.s.
        //--> It maintains/displays freq of elements in the insertion order.
        System.out.println("Frequencies:Nested Loops");
        for(int i=0;i<arr.length;i++) //TC:O(n)
        {
            boolean alreadyCounted=false;
            //Check if arr[i] has already counted before or not.
            for(int k=0;k<i;k++) //TC:O(i) if i=n then O(n)
            {
                if(arr[k]==arr[i])
                {
                    alreadyCounted=true;
                    break;
                }
            }
            if(alreadyCounted)  continue;;
            //Count the frequencies
            int count=1;
            for(int j=i+1;j<arr.length;j++) //TC:O(n)
            {
                if(arr[i]==arr[j])
                {
                    count++;
                }
            }
            System.out.println(arr[i]+" occurs "+count+" times.");
        }
    }
    public static void frequency(int[] arr)
    {
        /*
            Method 2. Sorting Approach --> A better approach when compared with nested loop.
            TC:O(n log n) & SC:O(1)
            For suppose if the given array is by default sorted then it is the most optimized approach.
            This method has limitations like:
             --> original array is modified.
             --> maintains no insertion order.
         */
        System.out.println("\nFrequencies:Sorting");
        //1. Sort the given array
        Arrays.sort(arr);
        //2. Declare and initialize count variable with 1.
        int count=1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
            {
                count++;
            }
            else {
                System.out.println(arr[i-1]+" occurs "+count+" times.");
                count=1;
            }
        }
        System.out.println(arr[arr.length-1]+" occurs "+count+" times.");
    }
    public static void getFrequencies(int[] arr)
    {
        //Method 3. Using a freq[] --> TC:O(n) & SC:O(size)
        //This method preserves insertion order, This method works for both +ve & -ve no.s
        //with minimal changes.
        //Finally, if the array elements are small then this approach is the best.
        //1. Find max and min values to close the range...
        System.out.println("\nFrequencies:Freq[]");
        int max=arr[0];
        int min=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
            if(arr[i]<min) min=arr[i];
        }
        //Determine the size
        int size=max-min+1;
        //Creating a freq[]
        int[] freq=new int[size];
        //Store freq's of each & every element in freq[].
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]-min]++; //we are shifting the indexes becoz we have -ve no.s.
        }
        //Print elements along with their frequencies - Also preserve their order.
        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]-min]>0)
            {
                System.out.println(arr[i]+" occurs "+freq[arr[i]-min]+" times.");
                freq[arr[i]-min]=0; //To avoid printing the same duplicates again
            }
        }
    }
    public static void findFrequencies(int[] arr)
    {
        //Method 4: A HashMap Approach --> TC:O(n) & SC:O(n)
        //To preserve insertion order use LinkedHashMap...
        System.out.println("\nFrequencies:HashMap");
        //Creating a HashMap
        Map<Integer,Integer> map = new LinkedHashMap<>();
        //Next put all array elements along with their frequencies in a map.
        for(int num:arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //Print elements along with their frequencies...
        for(int key:map.keySet())
        {
            System.out.println(key+" occurs "+map.get(key)+" times.");
        }
    }
    public static void printFrequencies(int[] arr)
    {
        //Method 5: A HashSet Approach --> TC:O(n^2) & SC:O(n)
        //Creating a HashSet
        System.out.println("\nFrequencies:HashSet");
        Set<Integer> set = new LinkedHashSet<>();
        //Adding arr elements in set.
        for(int num:arr)
        {
            set.add(num);
        }
        //Count frequency of each unique element
        for (int element : set) {
            int count = 0;
            for (int num : arr) {
                if (num == element) {
                    count++;
                }
            }
            System.out.println(element+" occurs "+count+" times.");
        }
    }
}

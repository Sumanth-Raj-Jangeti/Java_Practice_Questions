package com.arrays.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Find_1st_Repeated_NonRepeated {
    public static void main(String[] args) {

        System.out.println("\n***FIRST REPEATED & NON-REPEATED ELEMENT***");
        int[] arr1={1,4,6,5,2,1,7,2,1,2};
        findFirstRepeatedNonRepeated(arr1);
        getFirstRepeatedNonRepeated(arr1);
        printFirstRepeatedNonRepeated(arr1);
    }
    public static void findFirstRepeatedNonRepeated(int[] arr)
    {
        //Method 1: Nested Loop Approach --> TC:O(n^2 + n^2) = O(n^2) & SC:O(1)
        System.out.println("NESTED LOOP APPROACH:");
        int firstRepeated=-1;
        int firstNonRepeated=-1;
        //Logic to find the 1st Repeated Element in the given array...
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    firstRepeated=arr[i];
                    break;//As soon as when we find the firstRepeated element we break for(j).
                }
            }
            if(firstRepeated!=-1) // This check is mandatory otherwise firstRepeated value will be updated
            {                     // to some other value.
                break; //Breaks outer loop - for(i)
            }
        }
        System.out.println("First Repeated:"+(firstRepeated==-1?" Element Not Found":firstRepeated));
        //Logic to find the 1st Non-Repeated Element in the given array...
        for(int i=0;i<arr.length;i++)
        {
            boolean isRepeated=false;
            //Check if arr[i] is repeated or not...
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j && arr[i]==arr[j])
                {
                    isRepeated=true;
                    break;// when isRepeated is true then immediately break for(j)
                }
            }
            if(!isRepeated)
            {
                firstNonRepeated=arr[i];
                break; //breaks outer loop - for(i)
            }
        }
        System.out.println("First Non-Repeated:"+(firstNonRepeated==-1?"Element Not Found":firstNonRepeated));
    }
    public static void getFirstRepeatedNonRepeated(int[] arr)
    {
        //Method 2. Using Freq[] --> TC:O(n) & SC:O(size)
        System.out.println("\nFreq[]:");
        //Find max element.
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        //2. Determine the size
        int size=max+1;
        //3. Creating a freq[]
        int[] freq=new int[size];
        //4. store freq's of each & every element in freq[].
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        //5. Logic to find the first repeated element in the array.
        System.out.println("First Repeated:");
        for(int i=0;i<arr.length;i++) //To preserve insertion order loop through the given array.
        {
            if(freq[arr[i]]>1)
            {
                System.out.print(arr[i]+" ");
                break; //After finding the element --> immediately break for(i)
            }
        }
        //6. Logic to find the first non-repeated element in the array.
        System.out.println("\nFirst Non-Repeated:");
        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]]==1)
            {
                System.out.print(arr[i]+" ");
                break; //After finding the element --> immediately break for(i)
            }
        }
    }
    public static void printFirstRepeatedNonRepeated(int[] arr)
    {
        //Method 3. Using LinkedHashMap --> TC:O(n) & SC:O(n)
        System.out.println("\n\nLinkedHashMap:");
        //1. Creating a LinkedHashMap
        Map<Integer,Integer> map = new LinkedHashMap<>(); //SC:O(n)
        //2. Count & store frequencies
        // of each element in map.
        for(int num:arr)
        {
           map.put(num,map.getOrDefault(num,0)+1);
        }
        //3. Declare & initialize 2 var's.
        Integer firstRepeated = null;
        Integer firstNonRepeated = null;
        //4. iterate over the map for DISTINCT elements:
        /*
            We iterate over the LinkedHashMap because it stores only distinct elements with their frequencies
            while preserving insertion order, thus avoiding redundant checks on duplicate elements
            and giving an optimal O(n) solution.
         */
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (firstRepeated == null && entry.getValue() > 1)
                firstRepeated = entry.getKey();

            if (firstNonRepeated == null && entry.getValue() == 1)
                firstNonRepeated = entry.getKey();

            if (firstRepeated != null && firstNonRepeated != null)
                break;
        }
        System.out.println("First Repeated:"+(firstRepeated == null ? " Element Not Found" : firstRepeated));
        System.out.println("First Non-Repeated:"+(firstNonRepeated == null ? " Element Not Found" : firstNonRepeated));
    }
}

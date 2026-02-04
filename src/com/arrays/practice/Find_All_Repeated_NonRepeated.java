package com.arrays.practice;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Find_All_Repeated_NonRepeated {
    public static void main(String[] args) {
        System.out.println("\n*****ALL REPEATED & NON-REPEATED:*****");
        int[] arr1={1,4,6,5,2,1,7,2,1,2};
        allRepeatedNonRepeated(arr1);
        int[] temp={1,4,6,5,2,1,7,2,1,2};
        findAllRepeatedNonRepeated(temp);
        getAllRepeatedNonRepeated(arr1);
        printAllRepeatedNonRepeated(arr1);
        displayAllRepeatedNonRepeated(arr1);
    }
    public static void allRepeatedNonRepeated(int[] arr)
    {
        //Method 1. Using Nested Loops --> TC:O(n^2) & SC:O(1)
        System.out.println("\n***Nested Loop Approach***");
        System.out.println("Repeated Elements:");
        for(int i=0;i<arr.length;i++) //TC:O(n) runs n times.
        {
            boolean alreadyChecked=false;
            //Check if arr[i] has appeared before.
            for(int k=0;k<i;k++) //TC:O(n) runs up to n times.
            {
                if(arr[k]==arr[i])
                {
                    alreadyChecked=true;
                    break;
                }
            }
            if(alreadyChecked) continue;
            int r_count =0;
            for(int j=0;j<arr.length;j++) //TC:O(n) runs n times.
            {
                if(arr[i]==arr[j])
                {
                    r_count++;
                }
            }
            if(r_count >1)
            {
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println("\nNon-Repeated Elements:");
        for(int i=0;i<arr.length;i++) //TC:O(n) runs n times.
        {
            int nr_count =0;
            for(int j=0;j<arr.length;j++) //TC:O(n) runs n times.
            {
                if(arr[i]==arr[j])
                {
                    nr_count++;
                }
            }
            if(nr_count ==1)
            {
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void findAllRepeatedNonRepeated(int[] arr)
    {
        //Method 2. Using Sorting Approach --> TC:O(n log n) & SC:O(1)
        //For suppose if the given array is by default sorted then, this is the most optimized approach.
        /*
            This method has limitations like:
             --> original array is modified.
             --> maintains no insertion order.
         */
        System.out.println("\n\n***Sorting Approach:***");
        //Sort the given array.
        Arrays.sort(arr); //TC:O(n log n)
        System.out.println("Repeated Elements:");
        for(int i=1;i<arr.length;i++)
        {
                if (arr[i] == arr[i - 1]) {
                    System.out.print(arr[i] + " ");
                    while (i < arr.length-1 && arr[i] == arr[i + 1]) //Avoids printing the same duplicates again.
                    {
                        i++;
                    }
                }
        }
        System.out.println("\nNon-Repeated Elements:");
        for(int i=0;i<arr.length;i++)
        {
            boolean isUnique=true;
            //If same as previous element → not unique
            if(i>0 && arr[i]==arr[i-1]) isUnique=false;
            //If same as next element → not unique
            if(i<arr.length-1 && arr[i]==arr[i+1]) isUnique=false;
            //Printing only unique
            if(isUnique)
                System.out.print(arr[i]+" ");
        }
    }
    public static void getAllRepeatedNonRepeated(int[] arr)
    {
        //Method 3. Using freq[] --> TC:O(n) & SC:O(n)
        //This method preserves insertion order, This method works for both +ve & -ve no.s
        //with minimal changes.
        //Finally, if the array elements are small then this approach is the best.
        System.out.println("\n\n***Freq[]***");
        //1. Find max element to close the range...
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        //2. Determine the size.
        int size=max+1;
        //3. Creating a freq[].
        int[] freq=new int[size];
        //4. Store freq's of each & every element in freq[].
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        //5. Find Repeated Elements.
        System.out.println("Repeated Elements:");
        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]]>1)
            {
                System.out.print(arr[i]+" ");
                freq[arr[i]]=0; //To avoid printing the same duplicates again.
            }
        }
        //6. Find Non-Repeated Elements.
        System.out.println("\nNon-Repeated Elements:");
        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]]==1)
            {
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void printAllRepeatedNonRepeated(int[] arr)
    {
        //Method 4. Using HashMap --> TC:O(n) & SC:O(n)
        System.out.println("\n\n***Map Approach***");
        //1. Creating map
        Map<Integer,Integer> map = new LinkedHashMap<>(); //SC:O(n)
        //2. We need to find the freq's of each & every element in the array.
        for(int num:arr) //TC:O(n) it runs n times.
        {
            //count freq's
            map.put(num,map.getOrDefault(num,0)+1);
        }
        System.out.println("Repeated Elements:");
        for(Map.Entry<Integer,Integer> entry : map.entrySet())//TC:O(n)
        {
            if(entry.getValue()>1)
            {
                System.out.print(entry.getKey()+" ");
            }
        }
        System.out.println("\nNon-Repeated Elements:");
        for(Map.Entry<Integer,Integer> entry : map.entrySet())//TC:O(n)
        {
            if(entry.getValue()==1)
            {
                System.out.print(entry.getKey()+" ");
            }
        }
    }
    public static void displayAllRepeatedNonRepeated(int[] arr)
    {
        //Method 5. Using HashSet Approach -- TC:O(n) & SC:O(n)
        /*
             set.add(Integer e) returns:
             true --> if the element was NOT present and was added.
             false --> if the element was ALREADY present (no change)
         */
        System.out.println("\n\n***Set Approach***");
        //1. Creating 2 Sets.
        Set<Integer> distinct = new LinkedHashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        //2. loop & add all arr elements in set-->distinct
        //same logic as finding duplicates...
        for(int num:arr)
        {
            if(!(distinct.add(num)))
            {
                duplicates.add(num);
            }
        }
        System.out.println("Repeated Elements:");
        for(int num:duplicates)
        {
            System.out.print(num+" ");
        }
        System.out.println("\nNon-Repeated Elements:");
        for(int num:distinct)
        {
            if(!(duplicates.contains(num)))
            {
                System.out.print(num+" ");
            }
        }
    }
}


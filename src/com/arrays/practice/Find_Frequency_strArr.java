package com.arrays.practice;

import java.util.*;

public class Find_Frequency_strArr {
    public static void main(String[] args) {
        String[] arr1={"apple", "banana", "apple", "orange", "banana", "apple"};
        freq(arr1);
        String[] temp={"apple", "banana", "apple", "orange", "banana", "apple"};
        frequency(temp);
        findFrequencies(arr1);
        printFrequencies(arr1);
    }
    public static void freq(String[] words)
    {
        //Method 1. Using Nested Loops --> TC:O(n^2) & SC:O(1)
        //--> This method works for both +ve and -ve no.s.
        //--> It maintains/displays freq of elements in the insertion order.
        System.out.println("Frequencies:Nested Loops");
        for(int i=0;i<words.length;i++)
        {
            boolean alreadyCounted=false;
            //Skip if words[i] has alreadyCounted before...
            for(int k=0;k<i;k++)
            {
                if(words[k].equals(words[i]))
                {
                    alreadyCounted=true;
                    break;
                }
            }
            if(alreadyCounted) continue;
            //Print string elements along with their frequencies.
            int count=1;
            for(int j=i+1;j<words.length;j++)
            {
                if(words[i].equals(words[j]))
                {
                    count++;
                }
            }
            System.out.println(words[i]+" occurs "+count+" times.");
        }
    }
    public static void frequency(String[] words)
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
        //1. sort the given array.
        Arrays.sort(words);
        //2. Declare and Initialize count with 1
        int count=1;
        for(int i=1;i<words.length;i++)
        {
            if(words[i].equals(words[i-1]))
            {
                count++;
            }
            else {
                System.out.println(words[i-1]+" occurs "+count+" times.");
                count=1;
            }
        }
        System.out.println(words[words.length-1]+" occurs "+count+" times.");
    }
    public static void findFrequencies(String[] words)
    {
        //Method 3: A HashMap Approach --> TC:O(n) & SC:O(n)
        //To preserve insertion order use LinkedHashMap...
        System.out.println("\nFrequencies:HashMap");
        //Creating a HashMap
        Map<String,Integer> map = new LinkedHashMap<>();
        //Next put all array elements along with their frequencies in a map.
        for(String w:words)
        {
            map.put(w,map.getOrDefault(w,0)+1);
        }
        //Print elements along with their frequencies...
        for(String key:map.keySet())
        {
            System.out.println(key+" occurs "+map.get(key)+" times.");
        }
    }
    public static void printFrequencies(String[] words)
    {
        //Method 5: A HashSet Approach --> TC:O(n^2) & SC:O(n)
        //Creating a HashSet
        System.out.println("\nFrequencies:HashSet");
        Set<String> set = new LinkedHashSet<>();
        //Adding arr elements in set.
        for(String w: words)
        {
            set.add(w);
        }
        //Count frequency of each unique element
        for (String element : set) {
            int count = 0;
            for (String w : words) {
                if (w.equals(element)) {
                    count++;
                }
            }
            System.out.println(element+" occurs "+count+" times.");
        }
    }
}

package com.arrays.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Find_Last_k_Repeated_NonRepeated {
    public static void main(String[] args) {
        System.out.println("\n***K REPEATED & NON-REPEATED ELEMENTS***");
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        int k=4;
        findLastKRepeatedNonRepeated(arr,k);
        getKRepeatedNonRepeated(arr,k);
        printKRepeatedNonRepeated(arr,k);
    }
    public static void findLastKRepeatedNonRepeated(int[] arr,int k)
    {
        //Method 1. Nested Loop --> TC:O(n^2) & SC:O(1)
        System.out.println("\nNested Loop:");
        //For storing final results --> I use 2 lists because list grows dynamically...
        List<Integer> repeated = new ArrayList<>();
        List<Integer> nonRepeated = new ArrayList<>();
        //Repeated logic.
        //We need to iterate over the array - Right to Left
        for(int i=arr.length-1;i>=0 && repeated.size()<k;i--)
        {
            boolean alreadyChecked = false;
            //check if arr[i] has appeared before.
            for(int x=0;x<i;x++)
            {
                if(arr[x]==arr[i])
                {
                    alreadyChecked = true;
                    break;
                }
            }
            if(alreadyChecked) continue;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    repeated.add(arr[i]);
                    break;
                }
            }
        }
        System.out.println("Last "+k+" repeated elements:"+repeated);
        //Non-Repeated logic.
        //We need to iterate over the array - Right to Left
        for(int i=arr.length-1;i>=0 && nonRepeated.size()<k;i--)
        {
            boolean isRepeated = false;
            //Check if arr[i] has repeated before.
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j && arr[i]==arr[j])
                {
                    isRepeated = true;
                    break;
                }
            }
            if(!isRepeated)
            {
                nonRepeated.add(arr[i]);
            }
        }
        System.out.println("Last "+k+" non-repeated elements:"+nonRepeated);
    }
    public static void getKRepeatedNonRepeated(int[] arr,int k)
    {
        //Method 2: freq[] + visited[] --> TC:O(n) & SC:O(n)
        System.out.println("\nFreq[]:");
        //1. find max element.
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        //2. Determine the size.
        int size=max+1;
        //3. Creating a freq[]
        int[] freq=new int[size];
        boolean[] visited=new boolean[size];
        //4. store freq's of each element in freq[]
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        //5. For storing final results - I use 2 lists because list grows dynamically...
        List<Integer> repeated = new ArrayList<>();
        List<Integer> nonRepeated = new ArrayList<>();
        //6. Logic
        for (int i=arr.length-1;i>=0;i--) {
            if (visited[arr[i]]) continue;
            visited[arr[i]] = true;

            if (freq[arr[i]] > 1 && repeated.size() < k) {
                repeated.add(arr[i]);
            }
            if (freq[arr[i]] == 1 && nonRepeated.size() < k) {
                nonRepeated.add(arr[i]);
            }
            if (repeated.size()==k && nonRepeated.size()==k)
                break;
        }
        System.out.println("Last " + k + " Repeated: " + repeated);
        System.out.println("Last " + k + " Non-Repeated: " + nonRepeated);
    }
    public static void printKRepeatedNonRepeated(int[] arr,int k)
    {
        //Method 3: using LinkedHashMap
        System.out.println("\nLinkedHashMap:");
        //1. Creating a LinkedHashMap
        Map<Integer,Integer> map = new LinkedHashMap<>(); //SC:O(n)
        //2. Count & store frequencies of each element in map.
        for(int i=arr.length-1;i>=0;i--)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //3. For storing final results - I use 2 lists because list grows dynamically...
        List<Integer> repeated = new ArrayList<>();
        List<Integer> nonRepeated = new ArrayList<>();
        //4. Logic.
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1 && repeated.size() < k)
                repeated.add(entry.getKey());

            if (entry.getValue() == 1 && nonRepeated.size() < k)
                nonRepeated.add(entry.getKey());

            if (repeated.size() == k && nonRepeated.size() == k)
                break;
        }
        System.out.println("Last " + k + " Repeated: " + repeated);
        System.out.println("Last " + k + " Non-Repeated: " + nonRepeated);
    }
}

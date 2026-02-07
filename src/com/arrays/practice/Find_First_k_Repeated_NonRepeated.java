package com.arrays.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Find_First_k_Repeated_NonRepeated {
    public static void main(String[] args) {
        System.out.println("\n***K REPEATED & NON-REPEATED ELEMENTS***");
        int[] arr1={1,4,6,5,2,1,7,2,1,2};
        int k=2;
        findKRepeatedNonRepeated(arr1,k);
        getKRepeatedNonRepeated(arr1,k);
        printKRepeatedNonRepeated(arr1,k);
    }
    public static void findKRepeatedNonRepeated(int[] arr,int k)
    {
        //Method 1. Nested Loop Approach --> TC:O(n^2) & SC:O(1)
        //For storing final results - I use 2 lists because list grows dynamically...
        System.out.println("NESTED LOOP:");
        List<Integer> Repeated = new ArrayList<>();
        List<Integer> NonRepeated = new ArrayList<>();
        //Repeated Logic.
        for(int i=0;i<arr.length && Repeated.size()<k;i++)
        {
            boolean alreadyChecked=false;
            //check if arr[i] element has appeared before.
            for(int x=0;x<i;x++)
            {
                if(arr[x]==arr[i])
                {
                    alreadyChecked=true;
                    break;
                }
            }
            if(alreadyChecked) continue;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    Repeated.add(arr[i]);
                    break;
                }
            }
        }
        //Non-Repeated Logic.
        for(int i=0;i<arr.length && NonRepeated.size()<k ;i++)
        {
            boolean isRepeated=false;
            //check if arr[i] has repeated before.
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j && arr[i]==arr[j])
                {
                    isRepeated=true;
                    break;
                }
            }
            if(!isRepeated)
            {
                NonRepeated.add(arr[i]);
            }
        }
        System.out.println("First " + k + " Repeated: " + Repeated);
        System.out.println("First " + k + " Non-Repeated: " + NonRepeated);
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
        List<Integer> Repeated = new ArrayList<>();
        List<Integer> NonRepeated = new ArrayList<>();
        //6. Logic
        for (int i = 0; i < arr.length; i++) {
            if (visited[arr[i]]) continue;
            visited[arr[i]] = true;

            if (freq[arr[i]] > 1 && Repeated.size() < k) {
                Repeated.add(arr[i]);
            }
            if (freq[arr[i]] == 1 && NonRepeated.size() < k) {
                NonRepeated.add(arr[i]);
            }
            if (Repeated.size()==k && NonRepeated.size()==k)
                break;
        }
        System.out.println("First " + k + " Repeated: " + Repeated);
        System.out.println("First " + k + " Non-Repeated: " + NonRepeated);
    }
    public static void printKRepeatedNonRepeated(int[] arr,int k)
    {
        //Method 3: using LinkedHashMap
        System.out.println("\nLinkedHashMap:");
        //1. Creating a LinkedHashMap
        Map<Integer,Integer> map = new LinkedHashMap<>(); //SC:O(n)
        //2. Count & store frequencies of each element in map.
        for(int num:arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //3. For storing final results - I use 2 lists because list grows dynamically...
        List<Integer> Repeated = new ArrayList<>();
        List<Integer> NonRepeated = new ArrayList<>();
        //4. Logic.
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1 && Repeated.size() < k)
                Repeated.add(entry.getKey());

            if (entry.getValue() == 1 && NonRepeated.size() < k)
                NonRepeated.add(entry.getKey());

            if (Repeated.size() == k && NonRepeated.size() == k)
                break;
        }
        System.out.println("First " + k + " Repeated: " + Repeated);
        System.out.println("First " + k + " Non-Repeated: " + NonRepeated);
    }
}

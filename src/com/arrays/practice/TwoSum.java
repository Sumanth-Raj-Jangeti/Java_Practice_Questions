package com.arrays.practice;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int target=9;
        int[] result=twoSum(arr,target);
        System.out.println(Arrays.toString(result));
        //for 2-pointers
        int[] res=twoSumUsingTwoPointers(arr,target);
        System.out.println("["+res[0]+", "+res[1]+"]");
        //for HashMap
        int[] ans=twoSumUsingHashMap(arr,target);
        System.out.println("["+ans[0]+", "+ans[1]+"]");
    }
    public static int[] twoSum(int[] arr,int target)
    {
        //Method 1. Brute Force Approach --> TC:O(n^2) & SC:O(1)
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if((arr[i]+arr[j])==target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumUsingTwoPointers(int[] arr,int target)
    {
        //Method 2. By using Two-Pointers --> TC:O(n) & SC:O(1)
        //Limitations: This is only possible when the given is sorted.

        int start=0;
        int end=arr.length-1;
        while(start<end)
        {
            int sum=arr[start]+arr[end];
            if(sum==target)
            {
                return new int[]{start,end};
            }
            else if(sum<target)
            {
                start++;
            }
            else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumUsingHashMap(int[] arr,int target)
    {
        //Method 3. By using HashMap --> TC:O(n) & SC:O(n)
        //Creating a HashMap --> with array elements as keys & values as indexes
        HashMap<Integer,Integer> map=new HashMap<>();
        //we need to iterate over the given array.
        for(int i=0;i<arr.length;i++)
        {
            int complement=target-arr[i]; //the complement is the number needed to reach the target.
            //Check if "element" present in map or not.
            if(map.containsKey(complement))
            {
                return new int[]{map.get(complement),i};
            }
            //Fill <K,V> pairs
            map.put(arr[i],i); //where, keys=arrayElements , values=indexes
        }
        return new int[]{-1,-1};
    }
}

package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
      Problem Statement - 3 Sum
      Given an integer array arr, return all the triplets [arr[i], arr[j], arr[k]]
      such that i != j, i != k, and j != k, and arr[i] + arr[j] + arr[k] == 0.
*/

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        List<List<Integer>> result=threeSumUsingBruteForce(arr);
        System.out.println(result);
        List<List<Integer>> res=threeSumTwoPointers(arr);
        System.out.println(res);
    }
    public static List<List<Integer>> threeSumUsingBruteForce(int[] arr)
    {
        //Method 1. Brute Force Approach --> TC:O(n^3) & SC:O(n^2)
        List<List<Integer>> temp = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++)
        {
            for(int j=i+1;j<arr.length-1;j++)
            {
                for(int k=j+1;k<arr.length;k++)
                {
                    int sum=arr[i]+arr[j]+arr[k];
                    if(sum==0)
                    {
                        List<Integer> triplet= Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(triplet); //TC:O(n log n) & this method uses timsort
                                                   // Is sorting required ?
                                                   //without sorting -> This algorithm may generate
                                                   //triplets in different orders(duplicates may include).
                        if(!temp.contains(triplet))
                        {
                            temp.add(triplet);
                        }
                    }
                }
            }
        }
        return temp;
    }
    public static List<List<Integer>> threeSumTwoPointers(int[] arr)
    {
        //Method 2. Using Two_Pointers technique --> TC:O(n^2) & SC:O(n^2)
        //Sort the given array.
        Arrays.sort(arr);
        //Creating List of Lists to store triplets.
        List<List<Integer>> temp = new ArrayList<>();
        //We need to iterate over the given array.
        for(int i=0;i<arr.length-2;i++)
        {
            //In order to avoid duplicates lists --> use the below check.
            if(i>0 && arr[i]==arr[i-1])
            {
                continue;
            }
            //Declare & Initialize 2 pointers.
            int left=i+1;
            int right=arr.length-1;
            while(left<right)
            {
                //Determine the sum.
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==0)
                {
                    List<Integer> triplet=Arrays.asList(arr[i],arr[left],arr[right]);
                    //Now adding triplet in List of Lists.
                    temp.add(triplet);
                    while(left<right && arr[left]==arr[left+1])
                    {
                        left++;
                    }
                    while(left<right && arr[right]==arr[right-1])
                    {
                        right--;
                    }
                    //Move pointers
                    left++;
                    right--;
                }
                else if(sum<0)
                {
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return temp;
    }
}

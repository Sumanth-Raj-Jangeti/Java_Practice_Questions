package com.arrays.practice;

import java.util.*;
/*
     Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
        answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
        answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
*/
public class Find_Difference_Arrays {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={2,4,6};
        List<List<Integer>> difference = findDifference(arr1,arr2);
        System.out.println(difference);
    }
    public static List<List<Integer>> findDifference(int[] arr1,int[] arr2)
    {
        //Creating 2 Sets to store both array elements without duplicates.
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        //Adding arr1 elements in set1.
        for(int x:arr1) set1.add(x);
        for(int x:arr2) set2.add(x);
        //Creating 2 Lists to hold diff_12 & diff_21 ...
        List<Integer> diff_12=new ArrayList<>();
        List<Integer> diff_21=new ArrayList<>();

        //Finding all distinct integers in arr1 which are not present in arr2
        for(int s:set1)
        {
            if(!set2.contains(s))
                diff_12.add(s);
        }
        //Finding all distinct integers in arr2 which are not present in arr1
        for(int s:set2)
        {
            if(!set1.contains(s))
                diff_21.add(s);
        }
        return Arrays.asList(diff_12,diff_21);
    }
}

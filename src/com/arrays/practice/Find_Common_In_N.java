package com.arrays.practice;

import java.util.*;

/*
     Intersection of Multiple Arrays --> LeetCode:2248
     Problem Statement:Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers,
     return the list of integers that are present in each array of nums sorted in ascending order.
*/

public class Find_Common_In_N {
    public static void main(String[] args) {
        int[][] arrays = {
                {3,1,2,4,5},
                {1,2,3,4},
                {3,4,5,6},
        };
        List<Integer> r1 = findCommon(arrays);
        System.out.println("Common elements in all arrays:"+ r1);

        List<Integer> r2 = intersection(arrays);
        System.out.println("Intersection of Multiple Arrays:"+r2);

        List<Integer> r3 = intersect(arrays);
        System.out.println("Intersection of Multiple Arrays:"+r3);
    }
    public static List<Integer> findCommon(int[][] arrays)
    {
        //Creating a set to store intersection of multiple arrays...
        HashSet<Integer> common = new HashSet<>();
        // Initialize common set with first array.
        for (int num : arrays[0])
        {
            common.add(num);
        }
        // Intersect with remaining arrays...
        for(int i=1;i<arrays.length;i++)
        {
            //Creating a temp set.
            HashSet<Integer> temp = new HashSet<>();
            for(int num:arrays[i])
            {
                //Now here,we'll filter common elements...
                if(common.contains(num))
                {
                    temp.add(num); //storing common elements in temp.
                }
            }
            //Update the common set.
            common=temp;
        }
        return new ArrayList<>(common);
    }
    public static List<Integer> intersection(int[][] arrays)
    {
        //Creating a HashMap.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] arr : arrays) {
            for (int num : arr) {
                //So in this map,I'm storing all arrayEle's as Keys & their Count/Freq's as Values respectively.
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        //Our HashMap looks like this --> {1=2, 2=2, 3=3, 4=3, 5=2, 6=1}
        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == arrays.length) {
                result.add(key);
            }
        }
        Collections.sort(result); //if they ask then only...
        return result;
    }
    public static List<Integer> intersect(int[][] arrays)
    {
        /*
              Constraints:
            1.  1 <= nums.length <= 1000
            2.  1 <= sum(nums[i].length) <= 1000
            3.  1 <= nums[i][j] <= 1000
            4.  All the values of nums[i] are unique.
         */
        int[] count = new int[1001];
        // Step 1: Count occurrences
        for (int[] arr:arrays) {
            for (int num : arr) {
                count[num]++;
            }
        }
        // Step 2: Collect result
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (count[i] == arrays.length) {
                result.add(i);
            }
        }
        return result;
    }
}

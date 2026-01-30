package com.arrays.practice;

import java.util.HashSet;

public class Find_Common_In_N {
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 2, 3, 5},
                {2, 2, 3, 5, 7},
                {1, 2, 3, 5, 8},
                {0, 2, 3, 5, 9},
                {2,6,7,3}
        };
        HashSet<Integer> result = findCommon(arrays);
        System.out.println("Common elements in all arrays:"+result);
    }
    public static HashSet<Integer> findCommon(int[][] arrays)
    {
        // Initialize common set with first array
        HashSet<Integer> common = new HashSet<>();
        for (int num : arrays[0])
        {
            common.add(num);
        }
        // Intersect with remaining arrays
        for(int i=1;i< arrays.length;i++)
        {
            HashSet<Integer> temp = new HashSet<>();
            for(int num:arrays[i])
            {
                if(common.contains(num))
                {
                    temp.add(num);
                }

            }
            //Update the common set
            common=temp;
        }
        return common;
    }
}

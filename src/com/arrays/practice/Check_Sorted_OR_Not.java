package com.arrays.practice;

import java.util.stream.IntStream;

public class Check_Sorted_OR_Not {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        boolean status=isSorted(arr);
        System.out.println("Is Array Sorted? "+status);
        isItSorted(new int[]{2,3,5,7,11,13});
    }
    public static boolean isSorted(int[] arr)
    {
        //TC:O(n) & SC:O(1)
        //we need to iterate over the given array.
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
                return false;
            }
        }
        return true;
    }
    public static void isItSorted(int[] arr)
    {
        boolean result= IntStream.range(0,arr.length-1)
                .allMatch(i->arr[i]<=arr[i+1]);
        System.out.println("Is Array sorted? "+result);
    }
}

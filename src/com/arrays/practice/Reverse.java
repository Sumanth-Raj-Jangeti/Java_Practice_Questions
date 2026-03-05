package com.arrays.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Reverse {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        int[] res=reverse(arr);
        System.out.println("Reversed Array:"+ Arrays.toString(res));//Method 1
        reverseArr(arr);//Method 2
        int[] result=reversedArr(new int[]{1,4,6,5,2,1,7,2,1,2});//Method 3
        System.out.println("Reversed Array:"+Arrays.toString(result));
    }
    public static int[] reverse(int[] arr)
    {
        //Method 1: We'll be creating a new array to store all the reversed array elements.
        int[] revArr=new int[arr.length];
        //next we need to iterate over the given array...
        for(int i=0;i<arr.length;i++)
        {
            revArr[i]=arr[arr.length-1-i];
        }
        return revArr;
    }
    public static void reverseArr(int[] arr)
    {
        //method 2: in-place approach using 2 pointers.
        int n=arr.length;
        //we need to iterate over the array for (n/2) times
        for(int i=0;i<(n/2);i++)
        {
            //Using swapping logic
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
        System.out.println("Reversed Array:"+Arrays.toString(arr));
        /*
            //we can solve it using extra 2 pointers...
            int start=0;
            int end=arr.length-1;
            while(start<end)
            {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                //Move pointers...
                start++;
                end--;
            }
            System.out.println("Reversed Array:+Arrays.toString(arr));
        */
    }
    public static int[] reversedArr(int[] arr)
    {
        //Method 3: Using streams...
        return IntStream.range(0,arr.length)
                .map(i->arr[arr.length-1-i])
                .toArray();
    }
}

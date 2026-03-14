package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ReArrange_Array_Elements_By_Sign {
    public static void main(String[] args) {
        int[] arr1 ={3,1,-2,-5,2,-4};
        int[] result1 =rearrange(arr1);
        System.out.println(Arrays.toString(result1));
        int[] result2=rearrangeArr(new int[]{3,1,-2,-5,2,-4});
        System.out.println(Arrays.toString(result2));
    }
    public static int[] rearrange(int[] arr)
    {
        //Method 1: Using multiple extra spaces --> TC:O(n) & SC:O(n)
        //Creating 2 lists to store +ve & -ve elements.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        //we'll iterate over the given array
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
            }
        }

        //Creating a temp[] to store the result
        int[] temp=new int[arr.length];
        for(int i=0;i<pos.size() && i<neg.size();i++)
        {
            temp[2*i]=pos.get(i);
            temp[2*i+1]=neg.get(i);
        }
        return temp;
    }
    public static int[] rearrangeArr(int[] arr)
    {
        //Method 2: More Optimal solution --> TC:O(n) & SC:O(n)
        //Creating a temp[]
        int[] temp=new int[arr.length];
        int posIndex=0,negIndex=1;
        //We need to iterate over the given array
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                temp[posIndex]=arr[i];
                posIndex+=2;
            }
            else {
                temp[negIndex]=arr[i];
                negIndex+=2;
            }
        }
        return temp;
    }
}

package com.arrays.practice;

import java.util.Arrays;

public class Arrays3 {
    public static void main(String[] args) {
        //A program to check if 2 arrays are equal or not...
        //for 1D Arrays
        int[] arr1={1,2,3,4,5};
        int[] arr2={1,2,3,4,5};
        Arrays3 a=new Arrays3();
        System.out.println("1D Arrays are:"+a.isEqual1D(arr1,arr2));  //Method Call
        isEqual(arr1,arr2); //Method Call
        //for Multi-Dimensional Arrays
        int[][] arr3={{1,2},{3,4}};
        int[][] arr4={{1,2},{3,5}};
        System.out.println("MD Arrays are:"+a.isEqualMD(arr3,arr4));  //Method Call
    }
    public boolean isEqual1D(int[] arr1,int[] arr2)
    {
        System.out.println("By using built-in method...");
        return Arrays.equals(arr1,arr2);
    }
    public static void isEqual(int[] arr1,int[] arr2)
    {
        System.out.println("By using Manual Method...");
        boolean status=true; //Initially assuming both are equal.
        if(arr1.length!=arr2.length)
        {
            status=false;
        }
        else {
            for(int i=0;i<arr1.length;i++)
            {
                if(arr1[i]!=arr2[i])
                {
                    status=false;
                    break;
                }
            }
        }
        System.out.println("Are arrays equal? "+status);
    }
    public boolean isEqualMD(int[][] arr3,int[][] arr4)
    {
        System.out.println("By using Built-in method...");
        return Arrays.deepEquals(arr3,arr4); //Built-in
    }
}

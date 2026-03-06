package com.arrays.practice;

public class Move_All_Zeros_To_End_AND_Start {
    public static void main(String[] args) {
        moveZerosToEnd(new int[]{10,0,20,0,30,40,0,0,50,0}); //Passing Anonymous Arrays
        moveAllZerosToEnd(new int[]{10,0,20,0,30,40,0,0,50,0});
        moveZerosToStart(new int[]{10,0,20,0,30,40,0,0,50,0});
        moveAllZerosToStart(new int[]{10,0,20,0,30,40,0,0,50,0});
    }
    public static void moveZerosToEnd(int[] arr)
    {
        //Method 1: Two-Pointers Approach & in-place --> TC:O(n) & SC:O(1)
        int newIndex=0;
        //We need to iterate over the given array (Left To Right)
        for(int i=0;i<arr.length;i++)
        {
            //We only want non-zero elements
            if(arr[i]!=0)
            {
                arr[newIndex]=arr[i];
                newIndex++;
            }
        }
        //We need to fill remaining elements with 0's respectively or else we'll have :
        //10 20 30 40 50 40 0 0 50
        while(newIndex<arr.length)
        {
            arr[newIndex]=0;
            newIndex++;
        }
        System.out.println("Array after moving all zeros to the end:");
        for(int x:arr)
        {
            System.out.print(x+" ");
        }
    }
    public static void moveAllZerosToEnd(int[] arr)
    {
        //Method 2: Two Pointers + Swapping --> TC:O(n) & SC:O(1)
        int j=0;
        //We need to iterate over the given array
        for(int i=0;i<arr.length;i++)
        {
            //we only want non-zero elements
            if(arr[i]!=0)
            {
                if(i!=j) //To avoid unnecessary swaps.
                {
                    //Swapping logic
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                j++;
            }
        }
        System.out.println("\nArray after moving all zeros to the end:");
        for(int x:arr)
        {
            System.out.print(x+" ");
        }
    }
    public static void moveZerosToStart(int[] arr)
    {
        //Method 1. Two-Pointers + in-place --> TC:O() & SC:O()
        //We'll need a new index...
        int newIndex=arr.length-1;
        //We need to iterate over the given array (Right to Left)
        for(int i=arr.length-1;i>=0;i--)
        {
            //We only want non-zero elements.
            if(arr[i]!=0)
            {
                arr[newIndex]=arr[i];
                newIndex--;
            }
        }
        //We need to fill remaining elements with 0's.
        while(newIndex>=0)
        {
            arr[newIndex]=0;
            newIndex--;
        }
        System.out.println("\nArray after moving all zeros to the start:");
        for(int x:arr)
        {
            System.out.print(x+" ");
        }
    }
    public static void moveAllZerosToStart(int[] arr)
    {
        //Method 2: Two Pointers + Swapping --> TC:O(n) & SC:O(1)
        int j=arr.length-1;
        //We need to iterate over the given array
        for(int i=arr.length-1;i>=0;i--)
        {
            //we only want non-zero elements
            if(arr[i]!=0)
            {
                if(i!=j) //To avoid unnecessary swaps.
                {
                    //Swapping logic
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                j--;
            }
        }
        System.out.println("\nArray after moving all zeros to the start:");
        for(int x:arr)
        {
            System.out.print(x+" ");
        }
    }
}

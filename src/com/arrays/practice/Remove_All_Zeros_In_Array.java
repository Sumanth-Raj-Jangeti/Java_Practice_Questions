package com.arrays.practice;

public class Remove_All_Zeros_In_Array {
    public static void main(String[] args) {
        int[] arr1={10,0,20,0,30,40,0,0,50};
        removeZeros(arr1);
        int[] arr2=new int[]{10,0,20,0,30,40,0,0,50,0,60};
        deleteZeros(arr2);
    }
    public static void removeZeros(int[] arr)
    {
        //Method 1: With Extra Space --> TC:O(n) & SC:O(n)
        //Step 1. Count all non-zero elements
        int count=0;
        for (int i : arr) //TC:O(n)

        {
            if (i != 0) {
                count++;
            }
        }
        //Step 2. Creating a new array to hold only non-zero elements.
        int[] newArr=new int[count];
        //Step 3. Copy all non-zero elements from original[] to newArr[]
        int newIndex=0;
        for (int i : arr)//TC:O(n)
        {
            if (i != 0) {
                newArr[newIndex] = i;
                newIndex++;
            }
        }
        //Step 4. print the newArr[]
        System.out.println("Array after removing zeros:");
        for(int x:newArr)
        {
            System.out.print(x+" ");
        }
    }
    public static void deleteZeros(int[] arr)
    {
        //Method 2: A in-place approach --> TC:O(n) & SC:O(1)
        /*
           Limitations: 1. Original Array Modification.
                        2. Extra Space is used.
        */
        int newIndex=0;
        for(int i:arr)
        {
            if(i!=0)
            {
                arr[newIndex]=i;
                newIndex++;
            }
        }
        System.out.println("\nArray after removing zeros:");
        for(int i=0;i<newIndex;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}

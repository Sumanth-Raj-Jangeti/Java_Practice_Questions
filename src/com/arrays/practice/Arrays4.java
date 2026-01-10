package com.arrays.practice;

import java.util.Arrays;

public class Arrays4 {
    public static void main(String[] args) {
        //A program to copy one array to another
        // 1. Reference Copy
        int[] arr1={10,20,30,40,50};
        int[] arr2=arr1; //Reference copy:Both array variables point to the same memory location.
                         //Changing one effects the other.
        System.out.println("arr1[0]:"+arr1[0]); //prints the same
        System.out.println("arr2[0]:"+arr2[0]); //prints the same
        //Changing the array elements
        arr2[2]=80;
        System.out.println("arr1:"+Arrays.toString(arr1));
        System.out.println("arr2:"+Arrays.toString(arr2));

        // 2. Shallow Copy & Deep Copy: We can create independent arrays...
        // For 1D-Arrays Shallow copy=Deep copy, Becoz all elements are primitives.
        // By using clone()
        int[] arr3={1,2,3,4,5,6,7,8};
        int[] arr4=arr3.clone(); //Shallow Copy=Deep Copy
        System.out.println("arr3[0]:"+arr3[0]);
        System.out.println("arr4[0]:"+arr4[0]);
        //Changing the array elements
        arr4[2]=9;
        System.out.println("arr3:"+Arrays.toString(arr3));
        System.out.println("arr4:"+Arrays.toString(arr4));
        System.out.println();
        //Without using clone()
        int[] arr5={2,4,6,8,10};
        int[] arr6=new int[arr5.length];
        for(int i=0;i<arr5.length;i++)
        {
            arr6[i]=arr5[i]; //Copying & Storing arr5 elements in arr6...
        }
        System.out.println("Copied Array:"+Arrays.toString(arr6));
        //We can also perform various manipulations in arr6...
        arr6[4]=20;
        System.out.println("arr5:"+Arrays.toString(arr5));
        System.out.println("arr6:"+Arrays.toString(arr6));

        //We can also use copyOf(): This also creates an independent array...
        int[] a={1,3,5,7,9};
        int[] copy=Arrays.copyOf(a,a.length);
        System.out.println("a:"+Arrays.toString(a));
        System.out.println("copy:"+Arrays.toString(copy));
        copy[2]=10;
        System.out.println("a:"+Arrays.toString(a));
        System.out.println("copy:"+Arrays.toString(copy));
    }
}

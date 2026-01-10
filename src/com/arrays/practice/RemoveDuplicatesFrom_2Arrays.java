package com.arrays.practice;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFrom_2Arrays {
    public static void main(String[] args) {
       //A program to remove duplicates from Two-Arrays...
        int[] a={1,4,6,5,2,1,7,2,1,2};
        int[] b={2,2,4,4,6,8,10};
        int[] result=merge(a,b);
        System.out.println("Merged Array:"+Arrays.toString(result));
        removeDuplicates(result);
    }
    public static int[] merge(int[] arr1,int[] arr2)
    {
        int[] mergedArr=new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,mergedArr,0,arr1.length);
        System.arraycopy(arr2,0,mergedArr,arr1.length,arr2.length);
        return mergedArr;
    }
    public static void removeDuplicates(int[] a)
    {
        /*System.out.println("\nArray after removing duplicates:");
        for(int i=0;i<a.length;i++)
        {
            boolean isDuplicate=false;
            //Check if a[i] has appeared before.
            for(int j=0;j<i;j++)
            {
                if(a[i]==a[j])
                {
                    isDuplicate=true;
                    break;
                }
            }
            //If not a duplicate then just print it...
            if(!isDuplicate)
            {
                System.out.print(a[i]+" ");
            }
        }*/
        //Creating a HashSet.
        LinkedHashSet<Integer> set = new LinkedHashSet<>(); //Preserves Insertion order.
        //We need to loop through each and every element in the mergedArr.
        for(int num:a)
        {
            set.add(num);//Automatically duplicates are removed.
        }
        System.out.println(set);
    }
}

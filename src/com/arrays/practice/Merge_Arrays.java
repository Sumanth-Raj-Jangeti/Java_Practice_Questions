package com.arrays.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Merge_Arrays {
    public static void main(String[] args) {
        int[] arr1={2,4,6};
        int[] arr2={1,3,5,7,9};
        //A simple technique to merge arrays...
        int[] r1=merge(arr1,arr2);
        System.out.println("Merged Array:"+Arrays.toString(r1));

        //To merge array elements alternatively...
        int[] r2=mergeAlternatively(arr1,arr2);
        System.out.println("Merged Array(Alternatively):"+Arrays.toString(r2));

        //To merge 3 arrays that too in sorted order:
        int[] temp = mergeSorted(new int[]{1,3,5,7,9},new int[]{2,4,6,8,10});
        int[] r3=mergeSorted(temp,new int[]{10,20,30,40});
        System.out.println("Merged Array:"+Arrays.toString(r3));

        //Merging arrays using streams:
        int[] r4=mergeUsingStreams(new int[]{1,3,5,7,9},new int[]{2,4,6,8,10},new int[]{10,20,30,40});
        System.out.println("Merged Array:"+Arrays.toString(r4));

        int[] r5=Merge(new int[]{1,3,5,7,9},new int[]{2,4,6,8,10},new int[]{10,20,30,40});
        System.out.println("Merged Array(System.arraycopy):"+Arrays.toString(r5));
    }
    public static int[] merge(int[] arr1,int[] arr2)
    {
        //TC:O(n1+n2+n3) & SC:O(n1+n2+n3)
        //Creating a new array to store the result.
        int[] merged=new int[arr1.length+arr2.length];
        //Copying arr1 elements...
        for(int i=0;i<arr1.length;i++)
        {
            merged[i]=arr1[i];
        }
        //Copying arr2 elements...
        for(int i=0;i<arr2.length;i++)
        {
            merged[arr1.length+i]=arr2[i];
        }
        return merged;
    }
    public static int[] mergeAlternatively(int[] arr1,int[] arr2)
    {
        // TC & SC : O(n1+n2)
        int n1=arr1.length;
        int n2=arr2.length;
        //Determine the larger length...
        int maxLength=Math.max(n1,n2);
        //Creating a new array to store the result...
        int[] merged=new int[n1+n2];
        int k=0; //This will be our new index for merged[]
        //We need to loop through the maximum length of 2 arrays...
        for (int i=0;i<maxLength;i++)
        {
            if(i<n1)
            {
                //Selects an element from arr1.
                merged[k++]=arr1[i];
            }
            if (i<n2)
            {
                //Selects an element from arr2.
                merged[k++]=arr2[i];
            }
        }
        return merged;
    }
    public static int[] mergeSorted(int[] arr1,int[] arr2)
    {
        // TC & SC : O(n1+n2)
        //Finding lengths of 2 arrays.
        int n1=arr1.length;
        int n2=arr2.length;
        //Creating a new array to store the result.
        int[] merged=new int[n1+n2];
        int i=0,j=0,k=0;//where, i-->arr1,j-->arr2,k-->merged
        //Merging array elements in sorted order...
        while(i<n1 && j<n2)
        {
            if(arr1[i] < arr2[j])
            {
                merged[k++]=arr1[i++]; //Selects an element from arr1.
            }
            else {
                merged[k++]=arr2[j++]; //Selects an element from arr2.
            }
        }
        //Now we need to copy the remaining elements from arr1.
        while(i<n1)
        {
            merged[k++]=arr1[i++];
        }
        //Now we need to copy the remaining elements from arr2.
        while(j<n2)
        {
            merged[k++]=arr2[j++];
        }
        return merged;
    }
    public static int[] mergeUsingStreams(int[] arr1, int[] arr2, int[] arr3)
    {
        return IntStream
                .concat(IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)),Arrays.stream(arr3))
                .sorted()
                .toArray();
    }
    public static int[] Merge(int[] arr1,int[] arr2,int[] arr3)
    {
        // TC & SC : O(n1 + n2 + n3)
        int[] merged=new int[arr1.length+ arr2.length+ arr3.length];
        System.arraycopy(arr1,0,merged,0,arr1.length);
        System.arraycopy(arr2,0,merged,arr1.length,arr2.length);
        System.arraycopy(arr3,0,merged,arr1.length+arr2.length,arr3.length);
        return merged;
    }
}

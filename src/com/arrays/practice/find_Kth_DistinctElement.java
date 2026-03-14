package com.arrays.practice;

import java.util.LinkedHashSet;

public class find_Kth_DistinctElement {
    public static void main(String[] args) {
        int[] arr={1,4,6,5,2,1,7,2,1,2};
        int k=3;
        kthDistinctElement(arr,k);
    }
    public static void kthDistinctElement(int[] arr,int k)
    {
        // We need to remove duplicates & we also need to preserve the insertion order
        // so it is better if we use LinkedHashSet...
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        //Adding all array elements in LinkedHashSet.
        for(int num:arr)
        {
            set.add(num); //Duplicates are automatically removed & insertion order is also maintained.
        }
        int count=0;
        //we need to iterate over the set --> because set has all distinct elements.
        for(int num:set)
        {
            count++;
            if(count==k)
            {
                System.out.println("Kth distinct element is:"+num);
                return; //Immediately exit after finding the kth distinct element
            }
        }
        System.out.println("The value of k is larger than number of distinct elements");
    }
}

package com.arrays.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingNo {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,6};
        findMissing(arr1);//Sum of 'N' Natural No.s Method
        int[] arr2={5,6,7,9,10};
        findMissingNo(arr2);//Generalized Sum Method
        printMissing(arr2);
        int[] arr3={1,2,3,4,10};
        missingNos(arr3);//Finds all missing no.s - Brute Force
        getMissingNos(arr3);//Finds all missing no.s - HashSet
        int[] arr4={1,2,5,6,7,10,15};
        printMissingNos(arr4);//Using Stream API
    }
    public static void findMissing(int[] arr)
    {
        /*  Method 1: By using sum of 'n' Natural No.s = n*(n+1)/2 . Natural No.s always start from 1,2,3 and so on.
            This method has limitations like:
            --> Works only for arrays containing numbers from 1 to n (with one missing number).
            --> If we have duplicates this method doesn't work
            --> If we have multiple missing no.s then this method is not suitable
            TC: O(n) & SC: O(1)
        */
        int n = arr.length+1;
        int total_Sum = n*(n+1)/2;
        int actual_Sum = 0;
        for(int i = 0; i< arr.length; i++)
        {
            actual_Sum+= arr[i];
        }
        int missingNumber = total_Sum - actual_Sum;
        System.out.println("Missing Number:"+missingNumber);
    }
    public static void findMissingNo(int[] arr)
    {
        /*
            Method 2. By using generalized sum = (end - start + 1) * (start + end) / 2
            This method has limitations like:
            --> This method is applicable when array elements belong to a known continuous range [start, end] with exactly one missing element.
            --> It fails in the presence of duplicates or multiple missing values.
            TC:O(n) & SC:O(1)
         */
        //1. find the range[start,end]
        int start=arr[0];
        int end=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<start)  start=arr[i];
            if(arr[i]>end)    end=arr[i];
        }
        int total_Sum=(end - start + 1) * (start + end) / 2;
        int actual_Sum=0;
        for(int num:arr)
        {
            actual_Sum+=num;
        }
        int missingNumber = total_Sum - actual_Sum;
        System.out.println("Missing Number:"+missingNumber);
    }
    public static void printMissing(int[] arr)
    {
        //Method 3. By using Bitwise_XOR(^)--> (1^0)=1 , (0^1)=1 & (0^0)=0 , (1^1)=0
        //XOR is preferred over sum methods for large values because it avoids overflow and cancels duplicate pairs efficiently,
        //but it works only for a single missing number without duplicates.
        //It is very fast because it works on bits.
        int start = arr[0];
        int end = arr[0];
        // Find start and end
        for (int num : arr) {
            if (num < start) start = num;
            if (num > end) end = num;
        }
        int xor = 0;
        // XOR complete range
        for (int i = start; i <= end; i++) {
            xor ^= i;
        }
        // XOR array elements
        for (int num : arr) {
            xor ^= num;
        }
        System.out.println("Missing Number:"+xor);
    }
    //Find all missing numbers
    public static void missingNos(int[] arr)
    {
        //Method 1. A nested loop approach TC:O(n^2) & SC:O(1)
        //Find the maximum element
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)  max=arr[i];
        }
        System.out.println("All Missing Numbers:");
        for(int i=1;i<=max;i++)
        {
            boolean isPresent=false;
            //we need to loop through each and every element in the given array.
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]==i)
                {
                    isPresent=true;
                    break;
                }
            }
            if(!isPresent)
            {
                System.out.print(i+" ");
            }
        }
    }
    public static void getMissingNos(int[] arr)
    {
        //Method 2. HashSet Approach - TC:O(n) & SC:O(n)
        //Find start and end values.
        int start=arr[0];
        int end=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<start)  start=arr[i];
            if(arr[i]>end)    end=arr[i];
        }
        //Creating a HashSet
        HashSet<Integer> set = new HashSet<>();
        //Add arr elements in set.
        for(int num:arr)
        {
            set.add(num);
        }
        System.out.println("\nAll Missing Numbers:");
        for(int i=start;i<=end;i++)
        {
            if(!set.contains(i))
            {
                System.out.print(i+" ");
            }
        }
    }
    public static void printMissingNos(int[] arr)
    {
        //Method 3. By using stream API
        //We'll find max and min values to close the range...
        int min=Arrays.stream(arr).min().getAsInt();
        int max=Arrays.stream(arr).max().getAsInt();

        Set<Integer> set=Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        List<Integer> missing=IntStream.rangeClosed(min,max)
                .boxed()
                .filter(x-> !set.contains(x))
                .toList();

        System.out.println("\nMissing Numbers:"+missing);
    }
}

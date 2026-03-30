package com.arrays.practice;

public class CountAllOccurrences_Of_A_Element_InSortedArray {
    public static void main(String[] args) {
        int[] arr={5,7,8,8,8,8,10};
        int target=8;
        System.out.println("Total Occurrences of "+target+":"+countOccurrence(arr,target));
    }
    public static int countOccurrence(int[] arr,int target)
    {
        return (findLast(arr,target) - findFirst(arr,target) + 1);
    }
    public static int findFirst(int[] arr,int target)
    {
        //Declare & initialize 2 var's.
        int low=0,high=arr.length-1;
        int first=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                first=mid; //This may be our first occurrence.
                //Look for more small index on left part...
                high=mid-1;
            }
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return first;
    }
    public static int findLast(int[] arr,int target)
    {
        //Declare & initialize 2 var's.
        int low=0,high=arr.length-1;
        int last=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                last=mid; //This may be our last occurrence.
                low=mid+1;
            }
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return last;
    }
}

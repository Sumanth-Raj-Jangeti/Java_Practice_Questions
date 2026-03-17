package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr={1,0,-1,0,-2,2};
        int target=0;
        List<List<Integer>> result=fourSumUsingBruteForce(arr,target);
        System.out.println(result);
        List<List<Integer>> res=fourSumUsingTwoPointers(arr,target);
        System.out.println(res);
    }
    public static List<List<Integer>> fourSumUsingBruteForce(int[] arr, int target)
    {
        //Method 1. Brute Force Approach --> TC:O(n^4) & SC:O(n^3)
        List<List<Integer>> temp = new ArrayList<>();
        for(int i=0;i<arr.length-3;i++)
        {
            for(int j=i+1;j<arr.length-2;j++)
            {
                for(int k=j+1;k<arr.length-1;k++)
                {
                    for(int l=k+1;l<arr.length;l++)
                    {
                        long sum=(long)(arr[i]+arr[j]+arr[k]+arr[l]);
                        if(sum==target)
                        {
                            List<Integer> quadruplet = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(quadruplet); //TC:O(n log n) & this method uses timsort
                            // Is sorting required ?
                            //without sorting -> This algorithm may generate
                            //quadruplets in different orders(duplicates may include).
                            if(!temp.contains(quadruplet))
                            {
                                temp.add(quadruplet);
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }
    public static List<List<Integer>> fourSumUsingTwoPointers(int[] arr,int target)
    {
        //Method 2. Sorting + Two Pointers --> TC:O(n^3) & SC:O(n^3)
        //Sort the given array
        Arrays.sort(arr); //-2,-1,0,0,1,2
        //Creating List of Lists to store unique quadruplets.
        List<List<Integer>> temp=new ArrayList<>();
        //we need to iterate over the given array.
        for(int i=0;i<arr.length-3;i++)
        {
            //To avoid duplicates
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<arr.length-2;j++)
            {
                //To avoid duplicates
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                //Declare & initialize 2 pointers
                int left=j+1;
                int right=arr.length-1;
                while(left<right)
                {
                    long sum=(long)arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum==target)
                    {
                        List<Integer> quadruplet=Arrays.asList(arr[i],arr[j],arr[left],arr[right]);
                        //Now add "quadruplet" in list of lists "temp"
                        temp.add(quadruplet);
                        while(left<right && arr[left]==arr[left+1])
                        {
                            left++;
                        }
                        while(left<right && arr[right]==arr[right-1])
                        {
                            right--;
                        }
                        //Move Pointers
                        left++;
                        right--;
                    }
                    else if(sum<target)
                    {
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return temp;
    }
}

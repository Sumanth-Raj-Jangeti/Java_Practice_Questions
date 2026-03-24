package com.arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        int r1=majorityElement1(new int[]{2,2,1,1,1,2,2});
        System.out.println("Majority Element:"+r1);
        List<Integer> r2 = majorityElement2(new int[]{3,2,3});
        System.out.println("Majority Element:"+r2);
    }
    public static int majorityElement1(int[] arr)
    {
        //LeetCode:169 TC:O(n) & SC:O(1)
        /*
            Given an array arr of size n, return the majority element.
            The majority element is the element that appears more than ⌊n / 2⌋ times.
        */
        //By using Moore's Voting Algorithm.
        /*int candidate=arr[0];
        int votes=1;
        for(int i=1;i<arr.length;i++)
        {
            if(votes==0)
            {
                votes++;
                candidate=arr[i];
            }
            else if(candidate==arr[i])
            {
                votes++;
            }
            else{
                votes--;
            }
        }*/
        int candidate=0,count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(count==0)
            {
                candidate=arr[i];
            }
            if(arr[i]==candidate)
            {
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
    public static List<Integer> majorityElement2(int[] arr)
    {
        // LeetCode:229 TC:O(n) & SC:O(1) - Given an integer array of size n,find all elements that appear more than n/3 times.
        //Creating a List to store majority elements.
        List<Integer> majority = new ArrayList<>();
        //Declare & Initialize var's.
        Integer candidate1=null,candidate2=null;
        int count1=0,count2=0;
        for(int num:arr)
        {
            if(candidate1!=null && num==candidate1){
                count1++;
            }else if(candidate2!=null && num==candidate2){
                count2++;
            }else if(count1==0){
                candidate1=num;
                count1=1;
            }else if(count2==0){
                candidate2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        //Verifying candidates
        count1=0;
        count2=0;
        for(int num:arr){
            if(candidate1!=null && num==candidate1) count1++;
            if(candidate2!=null && num==candidate2) count2++;
        }
        if(count1 > (arr.length/3)) majority.add(candidate1);
        if(count2 > (arr.length/3)) majority.add(candidate2);
        return majority;
    }
}

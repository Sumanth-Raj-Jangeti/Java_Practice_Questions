package com.arrays.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Find_2nd_Repeated_NonRepeated {
    public static void main(String[] args) {
        System.out.println("\n***SECOND REPEATED & NON-REPEATED ELEMENT***");
        int[] arr1={1,4,6,5,2,1,7,2,1,2};
        findSecondRepeatedNonRepeated(arr1);
        getSecondRepeatedNonRepeated(arr1);
        printSecondRepeatedNonRepeated(arr1);
    }
    public static void findSecondRepeatedNonRepeated(int[] arr)
    {
        //Method 1: Using Nested Loops --> TC:O(n^2) & SC:O(1)
        System.out.println("Nested Loop Approach:");
        int secondRepeated=-1,r_count=0;
        int secondNonRepeated=-1,nr_count=0;
        //Logic to find second repeated element...
        for(int i=0;i<arr.length;i++)
        {
            boolean alreadyChecked=false;
            //Check if arr[i] has appeared before.
            for(int k=0;k<i;k++)
            {
                if(arr[k]==arr[i])
                {
                    alreadyChecked=true;
                    break;
                }
            }
            if(alreadyChecked) continue;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    r_count++;
                    if(r_count==2)
                    {
                        secondRepeated=arr[i];
                    }
                    break;//when we find the second repeated element, we immediately break for(j)
                }
            }
            if(secondRepeated!=-1)
            {
                break;//Breaks outer loop - for(i)
            }
        }
        System.out.println("Second Repeated Element:"+secondRepeated);
        //Logic to find second non-repeated element...
        for(int i=0;i<arr.length;i++)
        {
            boolean isRepeated=false;
            //check if arr[i] has appeared before...
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j && arr[i]==arr[j])
                {
                    isRepeated=true;
                    break;
                }
            }
            if(!isRepeated)
            {
                nr_count++;
                if(nr_count==2)
                {
                    secondNonRepeated=arr[i];
                    break;
                }
            }
        }
        System.out.println("Second Non-Repeated Element:"+secondNonRepeated);
    }
    public static void getSecondRepeatedNonRepeated(int[] arr)
    {
        //Method 2. Using freq[] --> TC;O(n) & SC:O(n)
        System.out.println("\nFreq[]:");
        //1. Find max element.
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        //2. Determine the size
        int size=max+1;//7+1=8
        //3. Creating a freq[]
        int[] freq=new int[size];
        boolean[] visited = new boolean[size]; //visited=F,F,F,F,F,F,F,F
        //4. store freq's of each & every element in freq[].
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;//freq=[0,3,3,0,1,1,1,1]
        }
        //5. Declare and Initialize var's
        int secondRepeated=-1,r_count=0;
        int secondNonRepeated=-1,nr_count=0;
        //6. Logic to find secondRepeated & secondNonRepeated element...
        for (int i = 0; i < arr.length; i++) {//i=4
            if (visited[arr[i]]){
                continue;            //index=0,1,2,3,4,5,6,7,8,9
            }                          //arr=1,4,6,5,2,1,7,2,1,2
            visited[arr[i]] = true;//visited=F,T,T,F,T,T,T,F
            // Repeated              //freq=[0,3,3,0,1,1,1,1]
            if (freq[arr[i]] > 1) {
                r_count++;//2
                if (r_count == 2)
                    secondRepeated = arr[i];//arr[4]=2
            }
            // Non-Repeated
            if (freq[arr[i]] == 1) {
                nr_count++;//3
                if (nr_count == 2)
                    secondNonRepeated = arr[i];//arr[2]=6
            }
            //early exit
            if(secondRepeated!=-1 && secondNonRepeated!=-1) break;
        }
        System.out.println("Second Repeated:"+(secondRepeated == -1 ? "None" : secondRepeated));
        System.out.println("Second Non-Repeated:"+(secondNonRepeated == -1 ? "None" : secondNonRepeated));
    }
    public static void printSecondRepeatedNonRepeated(int[] arr)
    {
        //Method 3. Using LinkedHashMap --> TC:O(n) & SC:O(n)
        System.out.println("\nLinkedHashMap:");
        //1. Creating a LinkedHashMap
        Map<Integer,Integer> map = new LinkedHashMap<>(); //SC:O(n)
        //2. Count & store frequencies of each element in map.
        for(int num:arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //3. Declare & initialize 4 var's.
        Integer secondRepeated = null;
        int r_count=0;
        Integer secondNonRepeated = null;
        int nr_count=0;
        //4. iterate over DISTINCT elements
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            //For Repeated
            if(entry.getValue()>1)
            {
                r_count++;
                if(r_count==2)
                {
                    secondRepeated=entry.getKey();
                }
            }
            //For Non-Repeated
            if(entry.getValue()==1)
            {
                nr_count++;
                if(nr_count==2)
                {
                    secondNonRepeated= entry.getKey();
                }
            }
            //Early-Exit
            if(secondRepeated!=null && secondNonRepeated!=null)
            {
                break;
            }
        }
        System.out.println("Second Repeated:"+(secondRepeated == null ? "None" : secondRepeated));
        System.out.println("Second Non-Repeated:"+(secondNonRepeated == null ? "None" : secondNonRepeated));
    }
}

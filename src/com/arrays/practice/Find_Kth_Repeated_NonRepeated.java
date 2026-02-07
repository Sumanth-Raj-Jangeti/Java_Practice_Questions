package com.arrays.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Find_Kth_Repeated_NonRepeated {
    public static void main(String[] args) {
        System.out.println("\n***Kth REPEATED & NON-REPEATED ELEMENT***");
        int[] arr1={1,4,6,5,2,1,7,2,1,2,7};
        int k=3;
        findKthRepeatedNonRepeated(arr1,k);
        getKthRepeatedNonRepeated(arr1,k);
        printKthRepeatedNonRepeated(arr1,k);
    }
    public static void findKthRepeatedNonRepeated(int[] arr, int k)
    {
        //Method 1: Using Nested Loops --> TC:O(n^2) & SC:O(1)
        System.out.println("Nested Loop:");
        int kthRepeated=-1,r_count=0;
        int kthNonRepeated =-1,nr_count=0;
        //Logic to find kth repeated element...
        for(int i=0;i<arr.length;i++)
        {
            boolean alreadyChecked=false;
            //Check if arr[i] has appeared before.
            for(int x=0;x<i;x++)
            {
                if(arr[x]==arr[i])
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
                    if(r_count==k)
                    {
                        kthRepeated=arr[i];
                    }
                    break;//when we find the kth repeated element, we immediately break for(j)
                }
            }
            if(kthRepeated!=-1)
            {
                break;//Breaks outer loop - for(i)
            }
        }
        System.out.println("Kth Repeated Element:"+((kthRepeated==-1)?"Element Not Found":kthRepeated));
        //Logic to find kth non-repeated element...
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
                if(nr_count==k)
                {
                    kthNonRepeated =arr[i];
                }
                break;
            }
        }
        System.out.println("Kth Non-Repeated Element:"+ ((kthNonRepeated==-1)?"Element Not Found":kthNonRepeated));
    }
    public static void getKthRepeatedNonRepeated(int[] arr,int k)
    {
        //Method 2. Using freq[] --> TC;O(n) & SC:O(size)
        System.out.println("\nFreq[]:");
        //1. Find max element.
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        //2. Determine the size
        int size=max+1;
        //3. Creating a freq[]
        int[] freq=new int[size];
        boolean[] visited = new boolean[size];
        //4. store freq's of each & every element in freq[].
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        //5. Declare and Initialize var's
        int kthRepeated=-1,r_count=0;
        int kthNonRepeated =-1,nr_count=0;
        //6. Logic to find kthRepeated & kthNonRepeated element...
        for (int i = 0; i < arr.length; i++) {
            if (visited[arr[i]]){
                continue;
            }
            visited[arr[i]] = true;
            // Repeated
            if (freq[arr[i]] > 1) {
                r_count++;
                if (r_count == k)
                    kthRepeated = arr[i];
            }
            // Non-Repeated
            if (freq[arr[i]] == 1) {
                nr_count++;
                if (nr_count == k)
                    kthNonRepeated = arr[i];
            }
            //early exit
            if(kthRepeated!=-1 && kthNonRepeated!=-1) break;
        }
        System.out.println("Kth Repeated Element:"+(kthRepeated == -1 ? "Element Not Found" : kthRepeated));
        System.out.println("Kth Non-Repeated Element:"+(kthNonRepeated == -1 ? "Element Not Found" : kthNonRepeated));
    }
    public static void printKthRepeatedNonRepeated(int[] arr,int k)
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
        Integer kthRepeated = null;
        int r_count=0;
        Integer kthNonRepeated = null;
        int nr_count=0;
        //4. iterate over DISTINCT elements
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            //For Repeated
            if(entry.getValue()>1)
            {
                r_count++;
                if(r_count==k)
                {
                    kthRepeated =entry.getKey();
                }
            }
            //For Non-Repeated
            if(entry.getValue()==1)
            {
                nr_count++;
                if(nr_count==k)
                {
                    kthNonRepeated = entry.getKey();
                }
            }
            //Early-Exit
            if(kthRepeated !=null && kthNonRepeated !=null)
            {
                break;
            }
        }
        System.out.println("Kth Repeated Element:"+(kthRepeated == null ? "Element Not Found" : kthRepeated));
        System.out.println("Kth Non-Repeated Element:"+(kthNonRepeated == null ? "Element Not Found" : kthNonRepeated));
    }
}

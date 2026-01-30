package com.arrays.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Find_Common_In_3 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,4,5};
        int[] arr2={2,3,4,5};
        int[] arr3={1,2,3,4,5};
        commonEle(arr1,arr2,arr3);      //Nested loops
        commonUniqueEle(arr1,arr2,arr3);//Nested loops
        int[] a={5,4,4,3,2,1};
        int[] b={5,4,3,2};
        int[] c={5,4,3,2,1};
        findCommonEle(a,b,c); // Sorting + Pointers
        getCommonEle(arr1,arr2,arr3); // HashMap
        printCommonEle(arr1,arr2,arr3);// HashSet
    }
    public static void commonEle(int[] arr1, int[] arr2, int[] arr3)
    {   //TC:O(xyz) & SC:O(1)
        System.out.println("Common Elements in 3 arrays:");
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                if(arr1[i]==arr2[j])
                {
                    for(int k=0;k<arr3.length;k++)
                    {
                        if(arr1[i]==arr3[k])
                        {
                            System.out.print(arr1[i]+" ");
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void commonUniqueEle(int[] arr1,int[] arr2,int[] arr3)
    {   //TC:O(n^2+n.y+n.z) --> if 3 arrays are of same size(x=y=z) then the TC simplified to
        //                      TC is O(x^2+x^2+x^2)-->O(3x^2)-->O(x^2)
        //                      SC:O(1)
        System.out.println("\nUnique Common Elements in 3 arrays:");
        for(int i=0;i<arr1.length;i++) //TC:O(x)
        {
            boolean alreadyChecked=false;
            //Check if arr1[i] has appeared before...
            for(int x=0;x<i;x++)       //TC:O(x)
            {
                if(arr1[x]==arr1[i])
                {
                    alreadyChecked=true;
                    break;
                }
            }
            if(alreadyChecked)
            {
                continue;
            }
            //Check in arr2
            boolean foundInArr2=false;
            for(int j=0;j<arr2.length;j++)  //TC:O(y)
            {
                if(arr1[i]==arr2[j])
                {
                    foundInArr2=true;
                    break;
                }
            }
            //Check in arr3
            boolean foundInArr3=false;
            if(foundInArr2)
            {
                for(int k=0;k<arr3.length;k++) //TC:O(z)
                {
                    if(arr1[i]==arr3[k])
                    {
                        foundInArr3=true;
                        break;
                    }
                }
            }
            //Print only once
            if(foundInArr2 && foundInArr3)
            {
                System.out.print(arr1[i]+" ");
            }
        }
    }
    public static void findCommonEle(int[] arr1,int[] arr2,int[] arr3)
    {   //TC:O(x log x + y log y + z log z) because sorting is the term which grows fatest in time.
        //SC:O(1)
        System.out.println("\nCommon Elements in 3 arrays(Sorting+Pointers):");
        //1. sort the given arrays
        Arrays.sort(arr1); //TC:O(x log x)
        Arrays.sort(arr2); //TC:O(y log y)
        Arrays.sort(arr3); //TC:O(z log z)
        //2. Declare and Initialize pointers
        int i=0,j=0,k=0;
        Integer lastPrinted=null;
        while(i<arr1.length && j<arr2.length && k<arr3.length) //TC:O(x + y + z)
        {
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k])
            {
                if(lastPrinted==null||arr1[i]!=lastPrinted)
                {
                    System.out.print(arr1[i]+" ");
                    lastPrinted=arr1[i];
                }
                i++;
                j++;
                k++;
            } else if (arr1[i]<arr2[j]) {
                i++;
            } else if (arr2[j]<arr3[k]) {
                j++;
            }
            else
            {
                k++;
            }
        }
    }
    public static void getCommonEle(int[] arr1,int[] arr2,int[] arr3)
    {   //TC:O(x + y + z) & SC:O(x)
        System.out.println("\nCommon elements in 3 arrays(HashMap):");
        //Creating a HashMap
        HashMap<Integer,Integer> map = new HashMap<>(); //initially we are storing arr1 elements so SC:O(x)
        //Add arr1 elements in map with same values...
        for(int num:arr1)//TC;O(x)
        {
            map.put(num,1);
        }
        //Update (K,V) in map when common in both arr1 and arr2
        for(int num:arr2)//TC:O(y)
        {
            if(map.containsKey(num))
            {
                map.put(num,2);
            }
        }
        //Common Elements
        for(int num:arr3)//TC:O(z)
        {
            if(map.containsKey(num) && map.get(num)==2)
            {
                System.out.print(num+" ");
                //Update the (K,V) to avoid printing same duplicates
                map.put(num,0);
            }
        }
    }
    public static void printCommonEle(int[] arr1,int[] arr2,int[] arr3)
    {   //TC:O(x + y + z) & SC:O(x)
        //Creating HashSet.
        HashSet<Integer> set = new HashSet<>();      //SC:O(x)
        HashSet<Integer> common12 = new HashSet<>(); //SC:O(min(x,y))
        HashSet<Integer> common123 = new HashSet<>();//SC:O(min(x,y,z))
        //Add arr1 elements in set                   //if x=y=z then it simplifies to O(3x)=O(x)
        for(int num:arr1) //TC:O(x)
        {
            set.add(num);//Automatically duplicates are removed
        }
        //finding common elements in arr1 & arr2 and store them in common12
        for(int num:arr2) //TC:O(y)
        {
            if(set.contains(num))
            {
                common12.add(num);
            }
        }
        //Now find common elements from common12 & arr3 and store them in common123
        for(int num:arr3)//TC:O(z)
        {
            if(common12.contains(num))
            {
                common123.add(num);
            }
        }
        System.out.println("\nCommon Elements in 3 arrays(HashSet):"+common123);
    }
}

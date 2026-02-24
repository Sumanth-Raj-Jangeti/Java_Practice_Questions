package com.arrays.practice;

import java.util.Arrays;

public class Delete_AND_Insert {
    public static void main(String[] args) {
        int[] arr={10,20,30,-30,40,-30,50,20};
        int[] elementsToBeDeleted={20,-30};
        //Here, we'll delete 2nd_Occ of 20 & All_Occ of -30
        int k=0;
        int count=0,kthOcc=2;
        //We need to iterate over the given array & deleting the given elements
        for(int i=0;i<arr.length;i++)
        {
            boolean found=false;
            //To delete 2nd_Occ of 20
            if(arr[i]==elementsToBeDeleted[0])
            {
                count++;
                if(count==kthOcc)
                {
                    found=true;
                }
            }
            //To delete all_Occ of -30
            if(arr[i]==elementsToBeDeleted[1])
            {
                found=true;
            }
            if(!found)
            {
                arr[k]=arr[i];
                k++;
            }
        }
        //Now we'll fill the remaining elements with 0
        int freeSpace=arr.length-k;
        while(k<arr.length)
        {
            arr[k]=0;
            k++;
        }
        System.out.println("Elements deleted successfully..."+"\n"+ Arrays.toString(arr));
        //Now we'll insert elements in those extra spaces...
        int[] insert={60,70,80};
        int elementsToBeInserted=insert.length;
        if(elementsToBeInserted>freeSpace)
        {
            System.out.println("INSERTION is not possible");
        }
        else{
            int startIndex=arr.length-freeSpace;
            k=0;
            while(k<freeSpace)
            {
                arr[startIndex]=insert[k];
                startIndex++;
                k++;
            }
        }
        System.out.println("Array after deleting & inserting:"+"\n"+Arrays.toString(arr));
    }
}

package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertElement {
    public static void main(String[] args) {
         /*
            Since we don't have any extra spaces left in array, So in-place insertion with all elements is not possible,
            If the requirement is strictly in-place then we need to drop one element in the array so that we can perform
            insertion.
            Best Alternatives:
            1. If they allow extra space then create a new array. (or)
            2. Use dynamic data structure like ArrayList.

            Finally, when the size is known and does not change, arrays are very efficient.
         */
        System.out.println("***INSERT ELEMENT***");
        //Method 1:
        int[] arr1={10,20,40,50};
        int[] arr2={10,20,30,50,0};
        int index=2, elementToBeInserted=30;
        insertElement(arr1,index, elementToBeInserted);
        insertElement(arr2,3,40);
        //Method 2:
        int[] arr3={10,20,30,40,60,70,80,90};
        int[] result=insert(arr3,4,50);
        System.out.println(Arrays.toString(result));
        //Method 3:
        insertion();
        //Method 4:
        insertEleInDuplicatePos(new int[]{10,20,30,30,50},3 ,40);
        //Method 5:
        insertMultipleElements(new int[]{10,20,50},2,new int[]{30,40});
    }
    public static void insertElement(int[] arr, int index, int elementToBeInserted)
    {
        /*
             Method 1. Shifting elements to right : Data is Lost --> (last element is overwritten/Lost) TC:O(n) & SC:O(1)
             Limitations: 1. This fails if we have more elements - highly confusing.
                          2. Data is lost.
         */
        System.out.println("\n(in-place)Insertion by dropping one element:");
        for(int i=arr.length-1;i>index;i--)
        {
            arr[i]=arr[i-1];
        }
        arr[index]= elementToBeInserted; // Inserting 30 between 20 & 40
        System.out.println(Arrays.toString(arr));
    }
    public static int[] insert(int[] arr,int index,int elementToBeInserted)
    {
        /*  Method 2: Creating a new array --> TC:O(n) & SC:O(n)
            Both are independent arrays, So they don't affect the other...
        */
        System.out.println("\nInsertion using a new array:");
        //1. Creating a new array with extra space - for new insertions.
        int[] newArr=new int[arr.length+1];
        //2. Copy all the elements before the index.
        for(int i=0;i<index;i++)
        {
            newArr[i]=arr[i];
        }
        //3. Insert the given element.
        newArr[index]=elementToBeInserted;
        //4. Copy remaining left over elements.
        for(int i=index;i<arr.length;i++)
        {
            newArr[i+1]=arr[i];
        }
        return newArr;
    }
    public static void insertion()
    {
        //Method 3. Using ArrayList --> TC:O(n) & SC;O(n)
        System.out.println("\nArrayList:");
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40,60,70,80,90));
        list.add(4,50);
        list.removeLast();
        System.out.println(list);
    }
    public static void insertEleInDuplicatePos(int[] arr,int index,int elementToBeInserted)
    {
        System.out.println("\nGiven Array:"+Arrays.toString(arr));
        //1. Find duplicate index.
        int duplicateIndex=-1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    duplicateIndex=j;//Storing index
                    break;
                }
            }
            if(duplicateIndex!=-1)
            {
                break;
            }
        }
        //2. Removing duplicate by shifting it to left.
        if (duplicateIndex != -1) {
            for (int i = duplicateIndex; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
        } else {
            System.out.println("Duplicate not found. Cannot insert.");
        }
        //3. Again shifting elements to right.
        for(int i=arr.length-1;i>index;i--)
        {
            arr[i]=arr[i-1];
        }
        //4. Inserting element
        arr[index]=elementToBeInserted;
        //5. print
        System.out.println("Inserted element in duplicate position:"+Arrays.toString(arr));
    }
    public static void insertMultipleElements(int[] arr,int index,int[] elementsToBeInserted)
    {
        System.out.println("\nInitial Array was:"+Arrays.toString(arr));
        //1. Creating new array with extra spaces.
        int[] newArr=new int[arr.length + elementsToBeInserted.length];
        //2. Copy elements before index.
        for(int i=0;i<index;i++)
        {
            newArr[i]=arr[i];
        }
        //3. Insert elements in newArr.
        for(int i=0;i<elementsToBeInserted.length;i++)
        {
            newArr[index+i]=elementsToBeInserted[i];
        }
        //4. copy remaining elements.
        for(int i=index;i<arr.length;i++)
        {
            newArr[i+elementsToBeInserted.length]=arr[i];
        }
        //5. printing...
        System.out.println("After Inserting multiple elements:"+Arrays.toString(newArr));
    }
}

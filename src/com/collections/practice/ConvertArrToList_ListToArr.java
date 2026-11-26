package com.collections.practice;

import java.util.*;
public class ConvertArrToList_ListToArr {
    public static void main(String[] args) {
        //Converting array to list...
        List<Integer> list = new ArrayList<>();
        int[] arr = {1,4,6,5,2,1,7,2,1,2};
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println(list);
        //converting list to array
        int[] newArr = new int[list.size()];
        for(int i=0;i< list.size();i++){
            newArr[i]= list.get(i);
        }
        System.out.println(Arrays.toString(newArr));
    }
}

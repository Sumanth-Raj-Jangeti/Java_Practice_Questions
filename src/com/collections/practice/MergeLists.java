package com.collections.practice;

import java.util.*;
import java.util.stream.Stream;

public class MergeLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,3,4));
        List<Integer> mergedList = mergeLists(list1,list2);
        System.out.println(mergedList);
        List<Integer> result = merge(list1,list2);
        System.out.println(result);
    }
    public static List<Integer> mergeLists(List<Integer> list1,List<Integer> list2){
        List<Integer> merged = new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size() && j< list2.size()){
            if(list1.get(i) < list2.get(j)){
                merged.add(list1.get(i));
                i++;
            }else{
                merged.add(list2.get(j));
                j++;
            }
        }
        //Copy Remaining elements from list1.
        while(i<list1.size()){
            merged.add(list1.get(i));
            i++;
        }
        //Copy Remaining elements from list2.
        while(j<list2.size()){
            merged.add(list2.get(j));
            j++;
        }
        return merged;
    }
    public static List<Integer> merge(List<Integer> list1,List<Integer> list2){
        return Stream.concat(list1.stream(),list2.stream()).toList();
    }
}

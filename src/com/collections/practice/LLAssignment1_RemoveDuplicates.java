package com.collections.practice;

import java.util.*;

public class LLAssignment1_RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);
        List<Integer> updatedList = removeDuplicates(list);
        System.out.println("Linked list without duplicates");
        for (Integer value : updatedList) {
            System.out.print(value+" ");
        }
    }
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> result = new LinkedList<>();
        for(Integer value:list){
            if(!result.contains(value)){
                result.add(value);
            }
        }
        return result;

        /*  Method 2:
            Set<Integer> unique = new LinkedHashSet<>(list);
            return new LinkedList(unique);
        */
    }
}

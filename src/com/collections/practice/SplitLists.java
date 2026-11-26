package com.collections.practice;

import java.util.*;

public class SplitLists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,4,6,5,2,1,7,2,1,2));
        List<List<Integer>> splits = splitList(list);
        System.out.println("List 1:"+splits.getFirst()+"\nList 2:"+splits.getLast());
    }
    public static List<List<Integer>> split(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int mid = list.size() / 2;
        for (int i = 0; i < list.size(); i++) {
            if (i < mid) {
                list1.add(list.get(i));
            } else {
                list2.add(list.get(i));
            }
        }
        return Arrays.asList(list1,list2);
    }
    public static List<List<Integer>> splitList(List<Integer> list) {
        int mid = list.size() / 2;
        List<Integer> list1 = new ArrayList<>(list.subList(0, mid));
        List<Integer> list2 = new ArrayList<>(list.subList(mid, list.size()));
        return Arrays.asList(list1, list2);
    }
}

package com.collections.practice;

import java.util.*;

public class LLAssignment2_CommonElements {
    public static void main(String[] args) {
        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(12);
        listOne.add(21);
        listOne.add(1);
        listOne.add(53);
        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(11);
        listTwo.add(21);
        listTwo.add(25);
        listTwo.add(53);
        listTwo.add(47);
        System.out.println(findCommonElements(listOne, listTwo));
    }
    public static List<Integer> findCommonElements(List<Integer> listOne, List<Integer> listTwo) {
        Set<Integer> set = new HashSet<>(listOne); // fast lookup
        List<Integer> result = new LinkedList<>();
        for (Integer value : listTwo) {
            if (set.contains(value) && !result.contains(value)) {
                result.add(value);
                set.remove(value);
            }
        }
        return result;
    }
}

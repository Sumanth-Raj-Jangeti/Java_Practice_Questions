package com.collections.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapAssignment3 {
    public static void main(String args[]) {
        String input = "Data Structures";
        Map<Character, Integer> occurrenceMap = findOccurrences(input);
        System.out.println("Occurrences of characters\n=======================");
        for (Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    }
    public static Map<Character, Integer> findOccurrences(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}

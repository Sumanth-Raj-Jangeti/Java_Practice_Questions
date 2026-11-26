package com.collections.practice;

import java.util.*;

public class MapAssignment2 {
    public static void main(String[] args) {
        Map<String,Integer> mapOne = new HashMap<>();
        mapOne.put("Toby", 15);
        mapOne.put("Micheal", 20);
        mapOne.put("Angela", 30);
        Map<String, Integer> mapTwo = new HashMap<>();
        mapTwo.put("Toby", 15);
        mapTwo.put("Andy", 45);
        mapTwo.put("Micheal", 40);
        Map<String,Integer> mergedMap = mergeMaps(mapOne, mapTwo);
        System.out.println("Merged Map:"+mergedMap);
    }
    /*
     Merge two hash maps in such a way that no data is lost.
     If the maps contain duplicate keys with different values,
     then while merging add the value of the duplicate key with a new key by concatenating "new" with the key.
     Implement the logic inside mergeMaps() method and return a HashMap containing the entries of both the HashMaps passed to the method.
    */
    public static Map<String,Integer> mergeMaps(Map<String,Integer> mapOne,Map<String,Integer> mapTwo) {
        Map<String,Integer> result = new HashMap<>();//This is where the final merged data will be stored.
        // Step 1: Copy all entries from mapOne into result.
        result.putAll(mapOne);
        // Step 2: Merge mapTwo
        for (Map.Entry<String,Integer> entry : mapTwo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            //Check if key already exists
            if (result.containsKey(key)) {
                // If values are different → create new key
                if (!result.get(key).equals(value)) {
                    result.put(key + "new", value);
                }
                // If same value → do nothing (already present)
            } else {
                result.put(key, value);
            }
        }
        return result;
    }
}


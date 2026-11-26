package com.collections.practice;

import java.util.*;

public class MapAssignment1 {
    public static void main(String[] args) {
        Map<String, Integer> sales = new HashMap<>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);
        List<String> employees = sortSales(sales);
        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employees) {
            System.out.println(employeeName);
        }
    }
    /*
    A Sales company is conducting its month end reviews.
    The Sales department head decides to meet the employees based on the order of their sales.
    The person with maximum number of sales will have the meeting first followed by the person having second highest sales and so on.
    Implement the logic in sortSales() method to sort a HashMap containing the names of the employees and their corresponding sales and
    return a List<String> containing the names of the employees based on the decreasing order of their sales.
    */
    public static List<String> sortSales(Map<String, Integer> sales) {
        // Step 1: Get all sales values
        List<Integer> values = new ArrayList<>(sales.values());
        // Step 2: Sort in descending order
        Collections.sort(values);
        Collections.reverse(values);
        // Step 3: Match values to names
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (Integer val : values) {
            for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                if (entry.getValue().equals(val) && !set.contains(entry.getKey())) {
                    result.add(entry.getKey());
                    set.add(entry.getKey());
                    break; // avoid duplicate matching
                }
            }
        }
        return result;
    }
}

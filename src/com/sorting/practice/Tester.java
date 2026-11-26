package com.sorting.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Charlie", 70000));
        employees.add(null); // Adding a null employee
        employees.add(new Employee(1, "Alice", 50000));
        employees.add(new Employee(2, "Bob", 60000));
        employees.add(null); // Adding another null employee
        // 1. Using nullsFirst()
        System.out.println("--- nullsFirst ---");
        employees.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        employees.forEach(System.out::println);
        // 2. Using nullsLast()
        System.out.println("\n--- nullsLast ---");
        employees.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        employees.forEach(System.out::println);
    }
}

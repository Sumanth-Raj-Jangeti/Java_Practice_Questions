package com.collections.practice;

import java.util.*;
/*
    Given a HashMap of type<String, Double> that stores names and corresponding average marks of students in a class,
     find out who scored the maximum and minimum marks. Implement the logic inside findMaxMinScorers() method.
     The method should return a HashMap<String, Double> which contains the maximum marks
     and the student(s) who scored the marks followed by minimum marks and the students(s) who scored it.
*/
class Student1 {
    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        Map<String, Double> result = new LinkedHashMap<>();
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        // Step 1: Find max and min
        for (double marks : studentMarks.values()) {
            if (marks > max) {
                max = marks;
            }
            if (marks < min) {
                min = marks;
            }
        }
        // Step 2: Collect max scorers
        for (Map.Entry<String, Double> entry : studentMarks.entrySet()) {
            if (entry.getValue() == max) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        // Step 3: Collect min scorers
        for (Map.Entry<String, Double> entry : studentMarks.entrySet()) {
            if (entry.getValue() == min) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
public class MapExercise1 {
    public static void main(String[] args) {
        Map<String, Double> studentMarks = new HashMap<String, Double>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);
        Map<String, Double> maxMinScorers = Student1.findMaxMinScorers(studentMarks);
        System.out.println("Details of Top Scorers & Low Scorers\n====================================");
        for (Map.Entry<String, Double> entry : maxMinScorers.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }

    }
}
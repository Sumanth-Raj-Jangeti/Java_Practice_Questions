package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(generateAllSubarrays(arr));
        System.out.println("****************");
        int[][] subarrays = getSubarrays(arr);
        System.out.println(Arrays.deepToString(subarrays));//Returns a human-readable string of a multi-dimensional array's contents.
        System.out.println("Line-by-Line Format:");
        for (int i = 0; i < subarrays.length; i++) {
            System.out.printf("Subarray %d: %s%n", i + 1, Arrays.toString(subarrays[i]));
            /*
            Arrays.toString() does not return an array object. It returns a java.lang.String object.
            The purpose of the Arrays.toString() method in the java.util.Arrays utility package
            is to convert an array's contents into a human-readable text format.
            In Java's System.out.printf() method, %s acts as a placeholder for strings, %d acts as a placeholder for integers,
            while %n acts as a platform-independent newline character
            */
        }
        System.out.println(Arrays.deepToString(subarrays(arr)));
    }
    /*
     * The total number of non-empty subarrays or substrings for a sequence of length n is exactly n(n+1)/2.
     * (Note:) If you need to include the empty subarray/substring [], you simply add 1 to the result, making it n(n+1)/2 + 1
     * Why creating a copy is necessary?
     * Notice the line result.add(new ArrayList<>(currentSubarray));
     * If you simply write result.add(currentSubarray);,
     * Java will pass the reference to that list. As currentSubarray continues to grow in the inner loop,
     * all previous entries inside your result master list would change along with it.
     * Making a shallow copy preserves the exact snapshot of the subarray at that moment.*/
    public static List<List<Integer>> generateAllSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            List<Integer> currentSubarray = new ArrayList<>();
            for (int j = i; j < n; j++) {
                currentSubarray.add(arr[j]);
                result.add(new ArrayList<>(currentSubarray));
            }
        }
        return result;
    }//for larger arrays, this approach is expensive in terms of memory & GC should work overtime...
    /*
    * Arrays.copyOfRange(original, from, to) is a built-in Java method in the java.util.Arrays class
    * that copies a specified range of an existing array into a brand-new array.
    * The original array remains completely unchanged.
    * original: The source array to copy from (works with all primitive types like int[], char[], and object arrays like String[]).
    * from: The starting index of the range to copy, which is inclusive.
    * to: The ending index of the range to copy, which is exclusive (the element at this index is not included).*/
    public static int[][] getSubarrays(int[] arr) {
        int n = arr.length;
        // 1. Calculate exact total to size the 2D array perfectly
        int totalSubarrays = n * (n + 1) / 2;
        int[][] result = new int[totalSubarrays][]; // Jagged array
        int index = 0;
        // 2. Generate and store
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Arrays.copyOfRange is extremely fast and handles the copying at the JVM level
                result[index++] = Arrays.copyOfRange(arr, i, j + 1);
            }
        }
        return result;
    }
    public static int[][] subarrays(int[] arr) {
        int n = arr.length;
        // 1. Calculate exact total to size the 2D array perfectly
        int totalSubarrays = n * (n + 1) / 2;
        int[][] result = new int[totalSubarrays][]; // Jagged array
        int index = 0;
        // 2. Generate and store
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Determine the exact length of the current subarray
                int subLength = j - i + 1;
                result[index] = new int[subLength];
                // Manually copy elements from arr to the new subarray
                for (int k = 0; k < subLength; k++) {
                    result[index][k] = arr[i + k];
                }
                index++;
            }
        }
        return result;
    }
}

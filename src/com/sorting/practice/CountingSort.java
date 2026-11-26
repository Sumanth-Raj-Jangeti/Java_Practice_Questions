package com.sorting.practice;

import java.util.Arrays;
public class CountingSort {
    public static void main (String[] args) {
        int[] arr = {1,4,6,5,2,-1,7,-2,-1,-2};
        sortUnstable(arr);
        System.out.println(Arrays.toString(arr));
        int[] newArr = sortStable(new int[]{1,4,6,5,2,-1,7,-2,-1,-2});
        System.out.println(Arrays.toString(newArr));
    }
    public static void sortUnstable(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        // 1. Find both the minimum and maximum values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        // 2. Calculate the range to size the frequency array
        int range = max - min + 1;
        int[] countMap = new int[range];
        // 3. Count occurrences using the shift (num - min)
        for (int num : arr) {
            countMap[num - min]++;
        }
        // 4. Reconstruct the array, shifting back (i + min)
        int index = 0;
        for (int i = 0; i < countMap.length; i++) {
            while (countMap[i] > 0) {
                arr[index] = i + min; // Restore the original negative/positive value
                index++;
                countMap[i]--;
            }
        }
    }
    public static int[] sortStable(int[] arr){
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }
        // 1. Find BOTH the maximum and minimum elements
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        // 2. Calculate the range and initialize cntArr
        int range = max - min + 1;
        int[] cntArr = new int[range];
        // 3. Count frequency of each element using the offset (arr[i] - minVal)
        for (int i = 0; i < n; i++) {
            cntArr[arr[i] - min]++;
        }
        // 4. Compute prefix sum
        for (int i = 1; i < range; i++) {
            cntArr[i] += cntArr[i - 1];
        }
        // 5. Build output array iterating backwards (this preserves stability)
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int v = arr[i];
            // We must also apply the offset here to look up the correct prefix sum!
            int shiftedIndex = v - min;
            ans[cntArr[shiftedIndex] - 1] = v;
            cntArr[shiftedIndex]--;
        }
        return ans;
    }
}
package com.arrays.practice;

import java.util.*;

public class MinimumSwapsToSortByDigitSum_LC3551 {
    public static void main(String[] args) {
        //System.out.println("MinSwaps:"+Solution1.minSwaps(new int[]{18,43,34,16}));
        System.out.println("MinSwaps:"+Solution2.minSwaps(new int[]{18,43,34,16}));
    }
}
class Solution1 {
    private static final Comparator<Integer> BY_DIGIT_SUM = (a, b) -> {
        int x = getDigitSum(a);
        int y = getDigitSum(b);
        if (x != y) {
            return Integer.compare(x, y);
        }
        return Integer.compare(a, b);
    };
    private static int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;//Extracts the last digit.
            num /= 10;//eliminates the last digit.
        }
        return sum;
    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] boxedArr = new Integer[n];//CUSTOM_SORTED_ARR
        Map<Integer,Integer> VALUETOINDEX = new HashMap<>();
        for(int i=0;i<n;i++){
            boxedArr[i] = nums[i];
            VALUETOINDEX.put(nums[i],i);
        }
        Arrays.sort(boxedArr,BY_DIGIT_SUM);
        int count = 0;
        for(int i=0;i<n;i++){
            int expectedVal = boxedArr[i], currVal = nums[i];
            if(expectedVal == currVal) continue;
            int index = VALUETOINDEX.get(expectedVal);
            nums[i] = expectedVal;
            nums[index] = currVal;
            VALUETOINDEX.put(expectedVal,i);
            VALUETOINDEX.put(currVal,index);
            count++;
        }
        return count;
    }
}
class Solution2 {
    static class Element {
        int number;
        int digitSum;
        int originalIndex;
        public Element(int number, int digitSum, int originalIndex) {
            this.number = number;
            this.digitSum = digitSum;
            this.originalIndex = originalIndex;
        }
    }
    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        Element[] arr = new Element[n];
        // 1. Precompute digit sums and store original indices
        for (int i = 0; i < n; i++) {
            arr[i] = new Element(nums[i], getDigitSum(nums[i]), i);
        }
        // 2. Sort by digit sum ascending, tie-break by numerical value
        Arrays.sort(arr, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.number, b.number);
        });
        // 3. Cycle decomposition using a boolean visited array. We create a visited array to keep track of which numbers we've already looked at.
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position
            if (visited[i] || arr[i].originalIndex == i) {
                continue;
            }
            // Trace the permutation cycle
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr].originalIndex;
                cycleSize++;
            }
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}

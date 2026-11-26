package com.sorting.practice;

public class LC3011_OptimalSolution {
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{8,4,30,2,15}));
    }
    public static boolean canSortArray(int[] nums) {
        // Track the max value of the PREVIOUS segment of same-bit numbers
        int previousMax = Integer.MIN_VALUE;
        // Track stats for the CURRENT segment of same-bit numbers
        int currentMin = nums[0];
        int currentMax = nums[0];
        int currentBitCount = Integer.bitCount(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int bitCount = Integer.bitCount(nums[i]);
            if (bitCount == currentBitCount) {
                // Same segment: update min and max
                currentMin = Math.min(currentMin, nums[i]);
                currentMax = Math.max(currentMax, nums[i]);
            } else {
                // Different segment: check if we can safely pass the previous segment
                if (currentMin < previousMax) {
                    return false;
                }
                // Start tracking the new segment
                previousMax = currentMax;
                currentMin = nums[i];
                currentMax = nums[i];
                currentBitCount = bitCount;
            }
        }
        // Final check for the very last segment
        return currentMin >= previousMax;
    }
}

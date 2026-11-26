package com.recursion.practice;

public class MinimumOperationsToReduceXToZero_LC1658 {
    public static void main(String[] args) {
        int[] arr = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(arr,x));
    }
    /*public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        int result = solve(nums,x,0,n-1,0,memo);
        return result >= Integer.MAX_VALUE ? -1 : result;
    }
    private static int solve(int[] arr,int target,int left,int right,int count,int[][] memo){
        //Base cases:
        if(target == 0) return count;
        if(target < 0 || left > right) return Integer.MAX_VALUE;
        if(memo[left][right] != -1) return memo[left][right];
        // Branch 1: Pick the leftmost element and move the left pointer inward
        int pickLeft = solve(arr, target - arr[left], left + 1, right,count + 1,memo);
        // Branch 2: Pick the rightmost element and move the right pointer inward
        int pickRight = solve(arr, target - arr[right], left, right - 1,count + 1,memo);
        //we want the minimum operations required from pickLeft or pickRight.
        return memo[left][right] = Math.min(pickLeft,pickRight);
    }*/
    /*public static int minOperations(int[] arr, int x) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>(); // Map stores: (PrefixSum, Index)
        map.put(0,-1);
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            map.put(sum,i);
        }
        if(sum < x) return -1;
        int remainingSum = sum - x;
        int longest = Integer.MIN_VALUE;
        sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum - remainingSum)){
                longest = Math.max(longest,i-map.get(sum - remainingSum));
            }
        }
        return longest == Integer.MIN_VALUE ? -1 : n - longest;
    }*/
    public static int minOperations(int[] arr, int x) {
        int target = -x;
        for (int num : arr) target += num;
        if (target == 0) return arr.length; // Remove all elements
        if (target < 0) return -1; // Impossible since all nums > 0
        int maxLength = -1;
        int currentSum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            // Shrink window from the left if we exceed the target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            // Record the maximum length if we hit the target exactly
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength == -1 ? -1 : arr.length - maxLength;
    }
}

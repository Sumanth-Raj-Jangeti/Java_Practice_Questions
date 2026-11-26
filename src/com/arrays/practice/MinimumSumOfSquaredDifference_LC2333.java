package com.arrays.practice;

import java.util.*;

public class MinimumSumOfSquaredDifference_LC2333 {
    public static void main(String[] args) {
        long result = minSumSquareDiff2(new int[]{20,19,3,18,16,20,0},new int[]{39,5,3,1,30,1,14},6,14);
        System.out.println(result);
    }
    public static long minSumSquareDiff1(int[] arr1, int[] arr2, int k1, int k2) {
        int n = arr1.length;//arr1 and arr2, both of length n.
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            pq_max.offer(Math.abs(arr1[i] - arr2[i]));
        }
        int k = k1 + k2;//where k represents total no.of modifications.
        while(k > 0 && !pq_max.isEmpty() && pq_max.peek() > 0){
            int largestDiff = pq_max.peek();
            pq_max.poll();//performing a temporary removal.
            pq_max.offer(largestDiff - 1);
            k--;
        }
        long result = 0L;
        while(!pq_max.isEmpty()){
            int root = pq_max.poll();
            result += ((long) root * root);
        }
        return result;
    }
    public static long minSumSquareDiff2(int[] arr1, int[] arr2, int k1, int k2) {
        int n = arr1.length;
        //Max absolute difference between 0 and 100,000 is 100,000. Array size 100,001 accommodates indices 0 to 100,000.
        int[] diffCounts = new int[100001];//10^5 i.e 1e5
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr1[i] - arr2[i]);
            diffCounts[diff]++;
            if (diff > maxDiff) {
                maxDiff = diff; // Optimization: tracking maxDiff saves looping empty buckets
            }
        }
        //k1 + k2 can exceed Integer.MAX_VALUE. Must use long.
        long k = (long) k1 + k2;
        // 2. Greedily processing exactly from the highest recorded difference.
        for (int currDiff = maxDiff; currDiff > 0 && k > 0; currDiff--) {
            if (diffCounts[currDiff] == 0) continue;
            // Cast bucket count to long to prevent overflow during Math.min comparisons
            // Determining how many modifications we can actually perform at this level
            long countOps = Math.min((long) diffCounts[currDiff], k);
            diffCounts[currDiff] -= (int) countOps;
            diffCounts[currDiff - 1] += (int) countOps;
            k -= countOps;
        }
        // 3. Calculate final sum of squares
        long result = 0L;
        for (long d = 1; d <= maxDiff; d++) {
            if (diffCounts[(int)d] > 0) {
                result += ((long) diffCounts[(int)d] * d * d);
            }
        }
        return result;
    }
}
/*
What is 1e5?
It uses scientific notation (also known as E-notation), where:
• 1 is the base number.
• e (or E) stands for "times 10 to the power of".
• 5 is the exponent.
Mathematically, it represents 1 * 10^5, which is 1 * 100,000.
*/

package com.recursion.practice;

import java.util.*;

class Solution {
    static class State{
        long score;
        List<Integer> indices;
        public State(long score,List<Integer> indices){
            this.score = score;
            this.indices = indices;
        }
    }
    int[][] temp;
    int n;
    State[][] memo;
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n=intervals.size();
        temp = new int[n][4];
        for(int i=0;i<n;i++){
            temp[i][0] = intervals.get(i).get(0);//start
            temp[i][1] = intervals.get(i).get(1);//end
            temp[i][2] = intervals.get(i).get(2);//weight
            temp[i][3] = i;                      //original index
        }
        Arrays.sort(temp, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // 1. Start time (ascending)
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // 2. End time (ascending)
            if (a[2] != b[2]) return Integer.compare(b[2], a[2]); // 3. Weight (descending)
            return Integer.compare(a[3], b[3]);                   // 4. Original index (ascending)
        });
        // DP Memoization table: max 5 states for the quota (0 to 4)
        memo = new State[n][5];
        // Start DP at index 0 with a quota of 4 intervals
        State result = solve(0, 4);
        // Convert the resulting List of indices into an int array
        int[] ans = new int[result.indices.size()];
        for (int i = 0; i < result.indices.size(); i++) {
            ans[i] = result.indices.get(i);
        }
        return ans;
    }
    private State solve(int i, int k) {
        // Base cases: no more intervals or out of quota
        if (i == n || k == 0) {
            return new State(0L, new ArrayList<>());
        }
        // Return cached result if available
        if (memo[i][k] != null) {
            return memo[i][k];
        }
        // Option 1: Skip the current interval
        State skip = solve(i + 1, k);

        // Option 2: Pick the current interval
        // Binary search the first valid interval that starts strictly AFTER the current one ends
        int nextIdx = binarySearch(i + 1, temp[i][1]);
        State nextState = solve(nextIdx, k - 1);

        long pickScore = temp[i][2] + nextState.score;
        List<Integer> pickIndices = new ArrayList<>(nextState.indices);
        pickIndices.add(temp[i][3]); // Add original index
        Collections.sort(pickIndices); // Keep indices sorted for lexicographical comparison

        State pick = new State(pickScore, pickIndices);

        // Evaluate the best choice
        if (pick.score > skip.score) {
            memo[i][k] = pick;
        } else if (pick.score < skip.score) {
            memo[i][k] = skip;
        } else {
            // Tie-breaker: If scores are equal, choose the lexicographically smaller list of indices
            memo[i][k] = compareLists(pick.indices, skip.indices) < 0 ? pick : skip;
        }
        return memo[i][k];
    }

    // Finds the first interval whose start time > targetEnd
    private int binarySearch(int start, int targetEnd) {
        int low = start, high = n - 1;
        int ans = n; // Default to 'n' (out of bounds) if none found
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (temp[mid][0] > targetEnd) {
                ans = mid;
                high = mid - 1; // Try to find an earlier valid one
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    // Helper to compare two index lists lexicographically
    private int compareLists(List<Integer> l1, List<Integer> l2) {
        int minSize = Math.min(l1.size(), l2.size());
        for (int i = 0; i < minSize; i++) {
            int cmp = Integer.compare(l1.get(i), l2.get(i));
            if (cmp != 0) return cmp;
        }
        // If identical up to the length of the shorter list, the shorter list is smaller
        return Integer.compare(l1.size(), l2.size());
    }
}
public class LC3414_TopDown {
    public static void main(String[] args) {
        List<List<Integer>> list = List.of(
                List.of(1, 3, 2),
                List.of(4, 5, 2),
                List.of(1, 5, 5),
                List.of(6, 9, 3),
                List.of(6, 7, 1),
                List.of(8, 9, 1)
        );
        int[] result = new Solution().maximumWeight(list);
        System.out.println(Arrays.toString(result));
    }
}

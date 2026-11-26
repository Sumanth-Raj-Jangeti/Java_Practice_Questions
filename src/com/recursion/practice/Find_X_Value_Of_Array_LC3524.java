package com.recursion.practice;

import java.util.Arrays;

public class Find_X_Value_Of_Array_LC3524 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 3;
        System.out.println(Arrays.toString(resultArray(arr,k)));
    }
    public static long[] resultArray(int[] arr, int k) {
        int n = arr.length;
        int[][] memo = new int[n+1][n+1];
        for(int[] num:memo){
            Arrays.fill(num,-1);
        }
        long[] result = new long[k];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int x = solve(i,j, arr,k,memo);
                result[x]++;
            }
        }
        return result;
    }
    private static int solve(int i, int j, int[] arr, int k, int[][] memo){
        if(memo[i][j] != -1) return memo[i][j];
        if(i == j)  return memo[i][j] = arr[j] % k;
        int prev = solve(i,j-1, arr,k,memo); // [ i to j-1]
        return memo[i][j] = (int)(((long) prev * arr[j]) % k);// [i to j]
    }
}
/*Better Brute Force Solution:
  "This algorithm calculates the product of all possible contiguous subarrays within the input array arr,
  takes that product modulo k, and returns an array containing the frequency of each resulting remainder.
  It uses dynamic programming—specifically top-down memoization—to avoid recalculating the product of overlapping subarrays."

The Main Loop: The nested for loops iterate through every valid start index i and end index j, representing every possible subarray.
The Base Case: If i == j (a single-element subarray), the product is simply arr[j] % k.
The Recursive Step: To find the product of a subarray from i to j, the function recursively fetches the already-computed product of the subarray from i to j-1,
                    and multiplies it by the current element arr[j].
Memoization: The memo 2D array stores the result of solve(i, j).
             Since we encounter the same i and j bounds multiple times during the recursive unwinding,
             returning the cached -1 check saves us from redundant recursive calls."

"One critical detail in the solve method is how the multiplication is handled.
Even if prev and arr[j] are both standard integers, their product can easily exceed the 32-bit signed integer limit (approx. 2.14 billion),
resulting in a negative overflow. To prevent this, I cast prev to a 64-bit long before multiplying.
Once the mathematically correct large product is calculated, I apply the modulo k.
Since the remainder of anything modulo k is strictly less than k (which fits in an int),
it is safe to cast the final result back down to an int to store it in the memoization table."

Time Complexity: O(n²)
There are n * (n - 1) / 2 possible contiguous subarrays in an array of size n, meaning there are O(n²) unique states for (i, j).
Because of the memoization table, each state (i, j) is calculated exactly once in O(1) time.
        Therefore, the total time spent across the nested loops and recursive calls is bounded by O(n²).

Space Complexity: O(n² + k)
Memoization Table: The 2D memo array of size (n+1) x (n+1) takes O(n²) space.
Call Stack: In the worst-case scenario (computing the entire array from 0 to n-1), the recursion depth goes down to n levels, requiring O(n) auxiliary stack space.
Result Array: The frequency array requires O(k) space.
Overall, the O(n²) memoization table dominates the memory footprint, making the final space complexity O(n² + k).
*/

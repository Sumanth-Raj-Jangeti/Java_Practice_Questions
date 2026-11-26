package com.sorting.practice;

import java.util.Arrays;

public class QuickSortFirst {
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,2,1,7,2,1,2};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int low,int high){
        //We'll sort only if given array has more than 1 element.
        if(low < high){
            int partitionIndex = getPartition(arr,low,high);
            sort(arr,low,partitionIndex-1);
            sort(arr,partitionIndex+1,high);
        }
    }
    private static int getPartition(int[] arr, int low, int high){
        //Choose the FIRST element as the pivot
        int pivot = arr[low];
        int i=low,j=high;
        while(i < j){
            //i walks forward looking for an element GREATER than the pivot
            while(arr[i] <= pivot && i <= high - 1){
                i++;
            }
            //j walks backward looking for an element SMALLER than/equal to the pivot
            while(arr[j] > pivot && j >= low + 1){
                j--;
            }
            // If pointers have not crossed, swap the misplaced elements
            if(i<j) swap(arr,i,j);
        }
        swap(arr,low,j);// Finally, lock the pivot into its correct, sorted position
        return j;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
Intuition:
"I'm using Quick Sort with the first element as the pivot.
I maintain two pointers, i and j.
i starts from the left and moves forward until it finds an element greater than the pivot.
j starts from the right and moves backward until it finds an element less than or equal to the pivot.
Whenever i < j, I swap those two elements because they're on the wrong sides of the pivot.
Once the pointers cross, I swap the pivot with arr[j]. This places the pivot in its final sorted position.
Then I recursively apply the same process to the left and right subarrays."

Why do you use two pointers?
"Because I want to partition the array around the pivot in-place.
One pointer searches from the left for elements that belong on the right, and the other searches from the right for elements that belong on the left.
Swapping them, partitions the array without creating another array."

Why did you choose the first element as pivot?
"It's a simple pivot choice and makes the partition logic straightforward.
However, the choice of pivot affects performance.
If the input is already sorted or nearly sorted, choosing the first element can produce highly unbalanced partitions and lead to O(n²) worst-case time."

What happens after partition?
"After partitioning, I place the pivot at index j.
At that point, all elements on the left are less than or equal to the pivot and the elements on the right are greater than the pivot, according to my partition conditions.
So the pivot is in its final position and I recursively sort the two remaining portions."
*/

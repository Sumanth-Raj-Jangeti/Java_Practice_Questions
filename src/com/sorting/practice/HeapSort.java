package com.sorting.practice;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 5, 2, 1, 7, 2, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        int n = arr.length;
        // Phase 1: Build max heap
        // Start from the last non-leaf node
        // and heapify each node up to the root.
        buildMaxHeap(arr);
        // Phase 2: Extract maximum elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current maximum (root) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Heap size is now reduced to i
            // because arr[i] is already sorted.
            heapifyDown(arr, 0, i);
        }
    }
    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        // Last non-leaf node
        int lastNonLeaf = n / 2 - 1;
        // Heapify from bottom to top
        for (int i = lastNonLeaf; i >= 0; i--) {
            heapifyDown(arr, i, n);
        }
    }
    private static void heapifyDown(int[] arr, int index, int heapSize) {
        while (true) {
            // Assume current index contains the largest value
            int largest = index;
            // Calculate child indices
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            // Check left child
            if (left < heapSize && arr[left] > arr[largest]) {
                largest = left;
            }
            // Check right child
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            // Current node is already the largest
            if (largest == index) {
                break;
            }
            // Swap current node with larger child
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            // Continue heapifying from the new position
            index = largest;
        }
    }
}


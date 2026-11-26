package com.collections.practice;

import java.util.Deque;
import java.util.ArrayDeque;

public class QueueAssignment3 {
    public static void main(String[] args) {
        Deque<Integer> inputStack = new ArrayDeque<Integer>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);
        Deque<Integer> updatedStack = changeSmallest(inputStack);
        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        Deque<Integer> tempStack = new ArrayDeque<>();
        // Step 1: Find smallest
        int min = Integer.MAX_VALUE;
        for (Integer val : inputStack) {
            if (val < min)
                min = val;
        }
        // Step 2: Separate elements and count smallest
        int count = 0;
        while (!inputStack.isEmpty()) {
            int val = inputStack.pop();
            if (val == min) {
                count++;
            } else {
                tempStack.push(val);
            }
        }
        // Step 3: Push smallest elements first (bottom)
        while (count > 0) {
            inputStack.push(min);
            count--;
        }
        // Step 4: Push remaining elements back (maintain order)
        while (!tempStack.isEmpty()) {
            inputStack.push(tempStack.pop());
        }

        return inputStack;
    }
}

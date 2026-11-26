package com.collections.practice;

import java.util.Deque;
import java.util.ArrayDeque;

public class QueueAssignment2  {
    public static void main(String[] args) {
        Deque<Integer> integerQueue = new ArrayDeque<Integer>();
        integerQueue.add(3);
        integerQueue.add(6);
        integerQueue.add(9);
        Deque<Character> characterQueue = new ArrayDeque<Character>();
        characterQueue.add('a');
        characterQueue.add('e');
        characterQueue.add('i');
        characterQueue.add('o');
        characterQueue.add('u');
        characterQueue.add('b');
        Deque<Object> mergedQueue = mergeQueue(integerQueue, characterQueue);
        System.out.println("The elements in the merged queue are:");
        for(Object element: mergedQueue)
            System.out.println(element);
    }
    public static Deque<Object> mergeQueue(Deque<Integer> intQueue, Deque<Character> charQueue) {
        Deque<Object> result = new ArrayDeque<>();
        // Merge alternately
        while (!intQueue.isEmpty() && !charQueue.isEmpty()) {
            result.add(intQueue.poll());   // integer first
            result.add(charQueue.poll());  // then character
        }
        // Add remaining elements (if any)
        while (!intQueue.isEmpty()) {
            result.add(intQueue.poll());
        }
        while (!charQueue.isEmpty()) {
            result.add(charQueue.poll());
        }
        return result;
    }
}

package com.collections.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueAssignment5 {
    public static void main(String[] args) {
        Deque<Character> inputStack = new ArrayDeque<Character>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');
        Deque<Character> resultStack = updateStack(inputStack);
        System.out.println("The alphabets in updated stack are:");
        for (Character ch : resultStack)
            System.out.println(ch);
    }
    public static Deque<Character> updateStack(Deque<Character> inputStack) {
        Deque<Character> temp = new ArrayDeque<>();
        // Step 1: Reverse stack
        while (!inputStack.isEmpty()) {
            temp.push(inputStack.pop());
        }
        // Step 2: Take bottom 3 elements
        char[] bottom = new char[3];
        for (int i = 0; i < 3; i++) {
            bottom[i] = temp.pop(); // E, D, C
        }
        // Step 3: Push remaining back to inputStack
        while (!temp.isEmpty()) {
            inputStack.push(temp.pop()); // A, B
        }
        // Step 4: Push bottom elements back (correct order)
        for (int i=0;i<bottom.length;i++) {
            inputStack.push(bottom[i]);
        }
        return inputStack;
    }
}
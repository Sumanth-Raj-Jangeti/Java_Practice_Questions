package com.collections.practice;

public class StackAssignment {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        calculateSum(stack);
        System.out.println("Updated stack");
        stack.display();
    }
    public static void calculateSum(Stack stack) {
        //Implement your code here
        Stack tempStack = new Stack(10);
        int sum = 0;
        // Step 1: Pop all elements & calculate sum
        while (!stack.isEmpty()) {
            int data = stack.pop();
            sum += data;
            tempStack.push(data);
        }
        // Step 2: Push sum first (goes to bottom)
        stack.push(sum);
        // Step 3: Restore original order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}

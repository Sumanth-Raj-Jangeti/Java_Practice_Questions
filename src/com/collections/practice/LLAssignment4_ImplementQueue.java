package com.collections.practice;

import java.util.LinkedList;

class Queue1 {
    private LinkedList<String> queue;
    private int maxSize;
    // Constructor
    public Queue1(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
    }
    // Return queue
    public LinkedList<String> getQueue() {
        return queue;
    }
    // Check if full
    public boolean isFull() {
        return queue.size() == maxSize;
    }
    // Check if empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    // Enqueue (add element at rear)
    public boolean enqueue(String data) {
        if (isFull()) {
            return false;
        }
        queue.addLast(data);
        return true;
    }
    // Dequeue (remove element from front)
    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        queue.removeFirst();
        return true;
    }
}
public class LLAssignment4_ImplementQueue {
    public static void main(String arga[]){
        Queue1 queue= new Queue1(5);
        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getQueue());
    }
}

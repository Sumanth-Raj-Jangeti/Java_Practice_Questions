package com.collections.practice;

public class QueueExercise1 {
    public static void main(String[] args) {
        Queue queue = new Queue(7);
        queue.enqueue(2);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.enqueue(10);
        Queue[] queueArray = splitQueue(queue);
        System.out.println("Elements in the queue of odd numbers");
        queueArray[0].display();
        System.out.println("\nElements in the queue of even numbers");
        queueArray[1].display();
    }
    public static Queue[] splitQueue(Queue queue) {
        Queue oddQueue = new Queue(queue.getMaxSize());
        Queue evenQueue = new Queue(queue.getMaxSize());
        while (!queue.isEmpty()) {
            int data = queue.dequeue();
            if (data % 2 == 0) {
                evenQueue.enqueue(data);
            } else {
                oddQueue.enqueue(data);
            }
        }
        Queue[] result = new Queue[2];
        result[0] = oddQueue;
        result[1] = evenQueue;
        return result;
    }
}

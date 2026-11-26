package com.collections.practice;

public class QueueAssignment1 {
    public static void main(String[] args) {
        Queue queue = new Queue(7);
        queue.enqueue(13983);
        queue.enqueue(10080);
        queue.enqueue(7113);
        queue.enqueue(2520);
        queue.enqueue(2500);
        Queue outputQueue = findEvenlyDivisibleNumbers(queue);
        System.out.println("Evenly divisible numbers");
        outputQueue.display();
    }
    public static Queue findEvenlyDivisibleNumbers(Queue queue) {
        Queue result = new Queue(queue.getMaxSize());
        while (!queue.isEmpty()) {
            int data = queue.dequeue();
            if (data % 2520 == 0)//A number divisible by all numbers from 1 to 10 must be divisible by their LCM.
            {                    //LCM of 1 to 10 is 2520
                result.enqueue(data);
            }
        }
        return result;
    }
}

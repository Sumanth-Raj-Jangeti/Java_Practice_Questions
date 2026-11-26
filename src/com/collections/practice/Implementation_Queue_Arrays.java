package com.collections.practice;

class Queue{
    /**Here,
     * front - represents the index position of the 1st element in the queue.
     * rear - represents the index position of the last element in the queue.
     * maxSize - represents the max no.of elements that can be stored in queue. */
    private int front,rear,maxSize;
    private int[] arr;
    public Queue(int maxSize){
        this.front=0;
        this.rear=-1;
        this.maxSize=maxSize;
        this.arr=new int[maxSize];
    }
    public int getMaxSize() {
        return maxSize;
    }
    //Implementations...
    /**This method adds an element in the queue.*/
    public void enqueue(int data){
        //Check if queue is full or not
        if(rear==maxSize-1){
            System.out.println("Queue is Full");
            return;
        }
        //If not full...
        rear++;
        arr[rear]=data;
    }
    public void display(){
        if(rear==-1){
            System.out.println("Queue is Empty");
            return;
        }
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]+" ");
        }
    }
    /**This method removes element from the front position & returns the removed element to notify the user.*/
    //if front=0,rear=-1(initialCase) & front=5,rear=4(FutureCase)
    //so we can use this condition like (front>rear) to check if queue is empty or not.
    public int dequeue(){
        if(front>rear){
            System.out.println("Queue is Empty");
            return -1;
        }
        int value=arr[front];
        front++;
        return value;
    }
    public boolean isEmpty() {
        if (front > rear)
            return true;
        return false;
    }
}
public class Implementation_Queue_Arrays {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        System.out.println("\nRemoved "+q.dequeue());
        q.display();
        q.enqueue(60);
        q.display();
    }
}
/*This is a linear queue implementation using arrays.
 It has a limitation called false overflow because freed space cannot be reused.
 To solve this efficiently, we use a circular queue instead of shifting elements.*/
/*

class CircularQueue {
    private int front, rear, maxSize;
    private int[] arr;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    // Enqueue
    public void enqueue(int data) {
        // Check full condition
        if ((rear + 1) % maxSize == front) {
            System.out.println("Queue is Full");
            return;
        }

        // First element insertion
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % maxSize;
        arr[rear] = data;
    }

    // Dequeue
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = arr[front];

        // If only one element
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }

        return value;
    }

    // Display
    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % maxSize;
        }
    }
}

public class Implementation_CircularQueue {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        System.out.println("\nRemoved " + q.dequeue());
        q.display();

        q.enqueue(60);  // works (wrap-around)
        System.out.println();
        q.display();
    }
}
*/
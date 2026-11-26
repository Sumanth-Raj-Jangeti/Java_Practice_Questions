package com.collections.practice;

class Stack{
    /**top represents the index position of top most element in the stack
     * when stack is created top is initialized to -1 */
    private int top;
    private int maxSize;
    private int[] arr;
    public Stack(int maxSize){
        this.top=-1;
        this.maxSize=maxSize;
        this.arr=new int[maxSize];
    }
    /**This method pushes an element on the top of the stack.*/
    public void push(int data){
        //Check whether the stack is full or not.
        if(top==maxSize-1){
            System.out.println("STACK IS FULL");
            return;
        }
        //Add element in stack...
        top=top+1;
        arr[top]=data;
    }
    /**This method displays the elements present in stack.*/
    public void display(){
        if(top==-1){
            System.out.println("STACK IS EMPTY");
            return;
        }
        //Iterating from top to bottom.
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    /**This method removes and returns the top element of the stack.*/
    public int pop(){
        if(top==-1) return -1;
        int value=arr[top];
        top--;
        return value;
    }
    /**This method returns the element on the top of the stack, but does not remove it.*/
    public int peek(){
        return arr[top];
    }
    /**This method returns true if the stack contains no elements at all, and false otherwise.*/
    public boolean isEmpty(){
        return top == -1;
    }
}
public class Implementation_Stack_Arrays {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        System.out.println("Peek:"+stack.peek());

        System.out.println("Popped Element is:"+stack.pop());
        stack.display();
        System.out.println("Peek:"+stack.peek());
    }
}

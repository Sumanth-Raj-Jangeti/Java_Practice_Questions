package com.collections.practice;

//Concept of inner classes...
class LinkedList_Stack{
    static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node top;
    /**This method pushes an element on the top of the stack.*/
    public void push(int data){
        //Creating a Node.
        Node newNode = new Node(data);
        newNode.setNext(top);
        this.top=newNode;
    }
    /**This method displays the elements present in stack.*/
    public void display(){
        if(top==null){
            System.out.println("STACK IS EMPTY");
            return;
        }
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }
    /**This method removes and returns the top element of the stack.*/
    public int pop(){
        if(top==null){
            System.out.println("STACK IS EMPTY");
            return -1;
        }
        int value=top.getData();
        top=top.getNext();
        return value;
    }
    /**This method returns the element on the top of the stack, but does not remove it.*/
    public int peek(){
        return top.getData();
    }
}
public class Implementation_Stack_LL {
    public static void main(String[] args) {
        LinkedList_Stack ls = new LinkedList_Stack();
        ls.push(10);
        ls.push(20);
        ls.push(30);
        ls.display();
        System.out.println("\nPopped element is:"+ls.pop());
        ls.display();
        System.out.println("\nPeek:"+ls.peek());
    }
}

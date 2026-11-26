package com.patterns.practice;
//Circular Doubly Linked List (CDLL) – Last node's next points to the head, and head's prev points to the last node.
public class CDLL {
    private Node head;
    private Node tail;
    private int size;
    public CDLL(){
        this.head = this.tail = null;
        size = 0;
    }
    //Methods...
    public void addFirst(int data){
        //Create a Node.
        Node newNode = new Node(data);
        //Check if list is empty or not. If it's empty, please make this newNode as head & tail.
        if(isEmpty()){
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }//If list is not empty.
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
            head.prev = tail;
        }
        size++;
    }
    public void addLast(int data){
        //Create a Node.
        Node newNode = new Node(data);
        //Check if list is empty or not. If it's empty please make this newNode as head & tail.
        if(isEmpty()){
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }//If list is not empty.
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        }
        size++;
    }
    public void add(int index,int data){
        if(index<0 || index>size){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size){
            addLast(data);
            return;
        }
        //Create a Node.
        Node newNode = new Node(data);
        //Initialize temp with head.
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        //1st connect newNode to its neighbour's.
        newNode.prev = temp;
        newNode.next = temp.next;
        //Because temp.next is the only reference to the remaining part of the list.
        //If I overwrite it first, the remaining nodes become unreachable, and the list gets broken.
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }
    public int getFirst(){
        if(!isEmpty()) return head.data;
        return -1;
    }
    public int getLast(){
        if(!isEmpty()) return tail.data;
        return -1;
    }
    /** returns any element at a specified index.
     * The special cases for the first and last elements are optimizations.
     * The traversal logic alone is sufficient to retrieve any valid index.
     * By handling index 0 and size - 1 separately, we avoid unnecessary traversal, giving us O(1) time for those cases.
     * Otherwise, we traverse the list, which takes O(n) in the worst case.*/
    public int get(int index){
        if(index<0 || index>=size){
            System.out.println("Invalid Index");
            return -1;
        }
        if(index==0) return getFirst();
        if(index==size-1) return getLast();
        //Initialize temp with head.
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public void set(int index,int data){
        if(index<0 || index>=size){
            System.out.println("Invalid Index");
            return;
        }
        //Initialize temp with head.
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        temp.data = data;
    }
    public void removeFirst(){
        if(isEmpty()) return;
        //If we have only one node.
        if(head==tail){
            head = tail = null;
            size--;
            return;
        }
        //If we have more than one node.
        head = head.next;
        tail.next = head;
        head.prev = tail;
        size--;
    }
    public void removeLast(){
        if(isEmpty()) return;
        //If we have ony one node.
        if(head==tail){
            head = tail = null;
            size--;
            return;
        }
        //if we have more than one node.
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
    }
    public void remove(int index){
        if(index<0 || index>=size){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            removeFirst();
            return;
        }
        if(index==size-1){
            removeLast();
            return;
        }
        //Initialize temp with head.
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }
    public void display(){
        if(isEmpty()) return;
        //Initialize temp with head.
        Node temp = head;
        do{
            System.out.println(temp.data);
            temp = temp.next;
        }while(temp != head);
    }
    public boolean contains(int data){
        //TC: O(n) & SC: O(1) visiting each and every node.
        if(isEmpty()) return false;
        //Initialize temp with head
        Node temp=head;
        //Traverse the list.
        do{
            if(temp.data==data) return true;
            temp = temp.next;
        }while(temp!=head);
        return false;
    }
    public int indexOf(int element){
        //TC: O(n) & SC: O(1) worst case: visiting each and every node. (Linear search)
        if(isEmpty()) return -1;
        //Initialize temp with head.
        Node temp = head;
        int index = 0;
        do{
            if(temp.data == element) return index;
            //Move pointers.
            temp = temp.next;
            index++;
        }while(temp!=head);
        return -1;
    }
    public int lastIndexOf(int element){
        //TC: O(n) & SC: O(1) visiting each and every node.
        if(isEmpty()) return -1;
        //Initialize temp with head.
        Node temp = head;
        int index=0,lastIndex = -1;
        do{
            if(temp.data == element){
                lastIndex=index;
            }
            //Move pointers.
            index++;
            temp=temp.next;
        }while(temp!=head);
        return lastIndex;
    }
    public boolean isEmpty(){
        return (head==null);
    }
    public int size(){
        return size;
    }
    public void clear(){
        head = tail = null;
        size = 0;
    }
    @Override
    public String toString() {
        //TC: O(n) & SC: O(n) Traverses list and builds a string of size proportional to the number of elements.
        if(isEmpty()) return "[]";
        StringBuilder sbl = new StringBuilder();
        //Initialize temp with head.
        Node temp = head;
        sbl.append("[");
        do{
            sbl.append(temp.data);
            if(temp.next != head){
                sbl.append(", ");
            }
            temp=temp.next;
        }while(temp!=head);
        sbl.append("]");
        return sbl.toString();
    }
    /**Why private? Node is an implementation detail of linked list.
     Nobody outside CDLL should know that Node exists.
     Making Node as private hides it completely from outside code. This is a good example of encapsulation.*/
    private static class Node{
        Node prev;
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.prev = this.next = null;
        }
    }
}

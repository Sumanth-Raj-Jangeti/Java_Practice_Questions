package com.patterns.practice;

public class DLL {
    private Node head;
    private Node tail;
    private int size;
    public DLL(){
        this.head = this.tail = null;
        this.size = 0;
    }
    //Methods...
    public void addFirst(int data){
        //Create a Node.
        Node newNode = new Node(data);
        //Check whether list is empty or not. If it is empty then make this node as head and tail.
        if(head==null){
            this.head = this.tail = newNode;
            size++;
            return;
        }
        //If it is not empty.
        newNode.next = head;
        head.prev = newNode;
        head = newNode;//moving head to correct position.
        size++;
    }
    public void addLast(int data){
        //Create a Node.
        Node newNode = new Node(data);
        //Check whether list is empty or not. If it is empty then make this node as head and tail.
        if(head==null){
            this.head = this.tail = newNode;
            size++;
            return;
        }
        //If it is not empty.
        tail.next = newNode;
        newNode.prev = tail;
        //Move tail.
        tail = newNode;
        size++;
    }
    public void add(int index,int data){
        if(index<0 || index>size()){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        //Create a Node.
        Node newNode = new Node(data);
        //initialize temp with head.
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        //Move pointers.
        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }
    public int getFirst(){
        //If list is empty.
        if(head==null){
            System.out.println("List is Empty");
            return -1;
        }
        return head.data;
    }
    public int getLast(){
        //If list is empty.
        if(head==null){
            System.out.println("List is Empty");
            return -1;
        }
        return tail.data;
    }
    public int get(int index){
        //TC: O(n) & SC: O(1) Traverses to the index.
        if(index<0 || index>=size()){
            System.out.println("Invalid Index");
            return -1;
        }
        if(index==0) return getFirst();
        if(index==size()-1) return getLast();
        //Initialize temp with head.
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    public void set(int index,int data){
        //TC: O(n) & SC: O(1) Traverses to the index or respective node.
        if(index<0 || index>=size()){
            System.out.println("Invalid Index");
            return;
        }
        //Initialize temp with head.
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.data=data;
    }
    public void display(){
        //TC: O(n) & SC: O(1) visiting each and every node.
        //Initializing temp with head.
        Node temp=this.head;
        //Traverse the list and print data of each node.
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;//Moves to the next node.
        }
    }
    public void displayInReverse(){
        //TC: O(n) & SC: O(1) visiting each and every node.
        //Initializing temp with head.
        Node temp=this.tail;
        //Traverse the list and print data of each node.
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.prev;//Moves to the next node.
        }
    }
    public boolean contains(int data){
        //TC: O(n) & SC: O(1) visiting each and every node.
        //Initialize temp with head
        Node temp=this.head;
        //Traverse the list.
        while(temp!=null){
            if(temp.data==data) return true;
            temp=temp.next;//Move to next node.
        }
        return false;
    }
    public void removeFirst(){
        //TC & SC: O(1) we're just moving the head.
        //If list is empty.
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        //If we have only one node.
        if(head==tail){
            head = tail = null;
            size--;
            return;
        }
        //if we have more than one node.
        head=head.next;
        head.prev = null;
        size--;
    }
    public void removeLast(){
        //TC: O(n) & SC: O(1) because, we must find the node before the tail.
        //If list is empty.
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        //If list has exactly one node.
        if(head==tail){
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    public void remove(int index){
        //TC: O(n) & SC: O(1) Traversing to previous node.
        if(index<0 || index>=size()){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            removeFirst();
            return;
        }
        if(index==size()-1){
            removeLast();
            return;
        }
        //Initialize temp with head.
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        temp.next=(temp.next.next);
        temp.next.prev = temp;
        size--;
    }
    public int indexOf(int element){
        //TC: O(n) & SC: O(1) worst case: visiting each and every node. (Linear search)
        //Initialize temp with head.
        Node temp = head;
        int index = 0;
        while(temp!=null){
            if(temp.data==element) return index;
            //Move pointers.
            temp=temp.next;
            index++;
        }
        return -1;
    }
    public int lastIndexOf(int element){
        //TC: O(n) & SC: O(1) visiting each and every node.
        //Initialize temp with head.
        Node temp = head;
        int index=0,lastIndex = -1;
        while(temp!=null){
            if(temp.data==element){
                lastIndex=index;
            }
            index++;
            temp=temp.next;
        }
        return lastIndex;
    }
    public boolean isEmpty(){
        //TC & SC: O(1)
        return (size==0); //we can also use return (head==null);
    }
    public void clear(){
        //TC & SC: O(1) Only we are just updating pointers.
        this.head = this.tail = null;
        size=0;//resetting size.
        // Once head and tail are set to null, the nodes become unreachable. They are eligible for garbage collection.
    }
    public int size(){
        return size;
    }
    @Override
    public String toString() {
        //TC: O(n) & SC: O(n) Traverses list and builds a string of size proportional to the number of elements.
        StringBuilder sbl = new StringBuilder();
        //Initialize temp with head.
        Node temp = head;
        sbl.append("[");
        while(temp!=null){
            sbl.append(temp.data);
            if(temp.next != null){
                sbl.append(", ");
            }
            temp=temp.next;
        }
        sbl.append("]");
        return sbl.toString();
    }
    public String reverseToString() {
        //TC: O(n) & SC: O(n) Traverses list and builds a string of size proportional to the number of elements.
        StringBuilder sbl = new StringBuilder();
        Node temp = tail;
        sbl.append("[");
        while (temp != null) {
            sbl.append(temp.data);
            if (temp.prev != null) {
                sbl.append(", ");
            }
            temp = temp.prev;
        }
        sbl.append("]");
        return sbl.toString();
    }
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

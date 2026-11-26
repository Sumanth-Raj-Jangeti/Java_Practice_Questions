package com.patterns.practice;

//Optimized Version.
public class SLL {
    private Node head;
    private Node tail;
    private int size;
    public SLL(){
        this.head = this.tail = null;
        this.size = 0;
    }//This is explicit constructor block, even if you write: public SLL{ } also works because, Java automatically initializes instance variables to their default values.
    //Methods.
    public void addFirst(int data){
        //TC & SC: O(1) Only we are just updating pointers.
        //Create a node.
        Node newNode = new Node(data);
        //check if the list is empty or not --> if empty make this node as head and tail.
        if(head==null){
            this.head = this.tail = newNode;
            size++;
            return;
        }
        //if list is not empty then add this element to the start.
        newNode.next=head;
        this.head=newNode;
        size++;
    }
    public void addLast(int data){
        //Create a node.
        //TC & SC: O(1) Only we are just updating pointers.
        Node newNode = new Node(data);
        //Check if the list is empty or not --> if empty make this node as head and tail.
        if(head==null){
            this.head = this.tail = newNode;
            size++;
            return;
        }
        //If not then add to the last.
        tail.next=newNode;
        this.tail=newNode;
        size++;
    }
    public void add(int index,int data){
        //TC: O(n) & SC: O(1) Need to traverse to index-1.
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
        //Create a node.
        Node newNode = new Node(data);
        //Initialize temp with head.
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    public void add(int data){
        addLast(data);
    }
    public int getFirst(){
        //TC & SC: O(1)
        //if list is empty.
        if(head==null){
            System.out.println("List is Empty");
            return -1;
        }
        return head.data;
    }
    public int getLast(){
        //TC & SC: O(1)
        //if list is empty.
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
        //If more than one node...
        Node temp = head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
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
        size--;
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
    /**Reverses the Singly Linked List using an iterative approach.
     * <p>Time Complexity: O(n)</p>
     *<p>Space Complexity: O(1)</p>
     * */
    public void reverseIterative() {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        // Update tail before changing head
        tail = head;//tail updates with currentHead.
        head = prev;
    }
    /**Reverses the Singly Linked List using an recursive approach.
     * <p>Time Complexity: O(n)</p>
     *<p>Space Complexity: O(n)</p>
     * */
    public void reverseRecursive(){
        if(head == null || head.next == null) return;
        tail = head; //Old head becomes new tail.
        head = reverse(head);
    }
    private Node reverse(Node head){
        if(head==null || head.next==null) return head;
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    /** Middle of the LL - LC: 876
     * <p>returns the middle node of the linked list.</p>
     * <p>If there are two middle nodes, return the second middle node.</p>*/
    public void MiddleNode(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
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
    /*Why private? Node is an implementation detail of linked list.
    Nobody outside SLL should know that Node exists.
    Making Node private hides it completely from outside code. This is a good example of encapsulation.*/
    private static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

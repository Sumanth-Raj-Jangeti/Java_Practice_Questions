package com.collections.practice;

class Node{
    private String data;
    private Node next; //A class can have:"a reference variable of its own type to refer to another object of the same class".
    public Node(String data) {
        this.data=data;
        this.next=null;
    }
    public String getData() {return data;}
    public void setData(String data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
class SinglyLinkedList{
    private Node head;
    private Node tail;
    public Node getHead() {
        return head;
    }
    /**This method adds a new element at the start of list*/
    public void addFirst(String data){
        //Creating a node...
        Node newNode = new Node(data);
        //Check if the list is empty,
        //if yes, make the node as the head and the tail
        if(head==null) {
            this.head = this.tail = newNode;
            return;
        }
        //If the list is not empty, add the element at the start
        newNode.setNext(head);//Makes newNode as the 1st element.
        this.head=newNode;
    }
    /**This method adds a new element at the end of the list*/
    public void addLast(String data){
        //Creating a node...
        Node newNode = new Node(data);
        //Check if the list is empty,
        //if yes, make the node as the head and the tail
        if(head==null) {
            this.head = this.tail = newNode;
            return;
        }
        //If the list is not empty, add the element at the end
        this.tail.setNext(newNode);
        //Make the new node as tail
        this.tail=newNode;
    }
    /**This method is used to display all elements present in a list*/
    public void display() {
        // Initialize temp to the head node
        Node temp = this.head;
        // Traverse the list and print data of each node
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();//Move to the next node
        }
    }
    /**This method searches the specified data in list,if match is found - it returns the Node object; Otherwise null*/
    public Node search(String data) {
        // Initialize temp to the head node
        Node temp = this.head;
        while (temp != null) {
            if (temp.getData().equals(data))//Compare current node’s data with target data
                return temp;
            temp = temp.getNext();//Move to the next node
        }
        return null;
    }
    /**This method inserts element in user desired location...
     * This means it inserts data AFTER dataBefore*/
    public void insert(String data, String dataBefore) {
        Node newNode = new Node(data);
        // Check if the list is empty,
        // if yes, make the node as the head and the tail
        if (this.head == null)
            this.head = this.tail = newNode;
        else {
            // search the node after which the data has to be inserted
            Node nodeBefore = search(dataBefore);
            if (nodeBefore != null) {
                // Insert the new node after nodeBefore
                newNode.setNext(nodeBefore.getNext());
                nodeBefore.setNext(newNode);
                // If nodeBefore is currently the tail node,
                // make the new node as the tail node
                if (nodeBefore == this.tail)
                    this.tail = newNode;
            } else
                System.out.println("Node not found");
        }
    }
    public void removeFirst(){
        // Case 1: empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // Case 2: only one node
        if (head == tail) {
            head = tail = null;
            return;
        }
        head=head.getNext();
    }
    public void removeLast(){
        // Case 1: empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // Case 2: only one node
        if (head == tail) {
            head = tail = null;
            return;
        }
        //initialize the temp to the head
        Node temp=this.head;
        while(temp.getNext()!=tail){
            temp=temp.getNext();//Move to the next node
        }
        temp.setNext(null);
        this.tail=temp;
    }
    public void delete(String data) {
        // Check if the list is empty,
        if (this.head == null)
            System.out.println("List is empty");
        else {
            // Find the node to be deleted
            Node node = this.search(data);
            // If the node is not found
            if (node == null)
                System.out.println("Node not found");
                // If the node to be deleted is the head node
            else if (node == this.head)
            {
                this.head = this.head.getNext();
                node.setNext(null);
                // If the node to be deleted is also the tail node
                if (node == this.tail)
                    tail = null;
            }
            else {
                // Traverse to the node present before the node to be deleted
                Node nodeBefore = null;
                Node temp = this.head;
                while (temp != null) {
                    if (temp.getNext() == node) {
                        nodeBefore = temp;
                        break;
                    }
                    temp = temp.getNext();
                }
                // Remove the node
                nodeBefore.setNext(node.getNext());
                // If the node to be deleted is the tail node,
                // then make the previous node as the tail
                if (node == this.tail)
                    this.tail = nodeBefore;
                node.setNext(null);
            }
        }
    }
    public int size(){
        int count=0;
        Node temp=this.head;
        while(temp!=null){
            count++;
            temp=temp.getNext();
        }
        return count;
    }
    public  void clear(){
        //Reset pointers...
        this.head=this.tail=null;
    }
}
public class Implementation_SLL {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast("Mango");
        sll.addLast("Grape");
        sll.addLast("Kiwi");
        sll.addFirst("Banana");
        sll.insert("Apple","Banana");
        sll.display();
        System.out.println((sll.search("Kiwi")!=null)?"Element Found":"Element not Found!");
        sll.removeLast();
        sll.removeFirst();
        sll.delete("Mango");
        sll.display();

        String elementToBeFound = "Apple";
        int position = findPosition(elementToBeFound, sll.getHead());
        if (position != 0)
            System.out.println("The position of the element is " + position);
        else
            System.out.println("The element is not found!");

        System.out.println("Size:"+sll.size());
        sll.clear();
        System.out.println("Size:"+sll.size());
    }
    public static int findPosition(String element, Node head) {
        int position=1;
        Node temp=head;
        while(temp!=null){
            if(temp.getData().equals(element)) return position;
            temp=temp.getNext();
            position++;
        }
        return 0;
    }
}

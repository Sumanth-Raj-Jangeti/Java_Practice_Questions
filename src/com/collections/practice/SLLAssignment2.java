package com.collections.practice;

public class SLLAssignment2 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList reversedLinkedList = new SinglyLinkedList();

        list.addLast("Data");
        list.addLast("Structures");
        list.addLast("and");
        list.addLast("Algorithms");

        System.out.println("Initial List");
        list.display();

        System.out.println();

        reverseList(list.getHead(), reversedLinkedList);
        System.out.println("Reversed List");
        reversedLinkedList.display();
    }

    public static void reverseList(Node head, SinglyLinkedList reversedLinkedList) {
        // Base case
        if (head == null)
            return;
        // Recursive call
        reverseList(head.getNext(), reversedLinkedList);
        // Add while coming back
        reversedLinkedList.addLast(head.getData());
    }
}

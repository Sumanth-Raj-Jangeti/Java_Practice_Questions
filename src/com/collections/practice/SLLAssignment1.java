package com.collections.practice;

public class SLLAssignment1 {
    public static void main(String[] args) {
        SinglyLinkedList s1 = new SinglyLinkedList();
        s1.addLast("ABC");
        s1.addLast("DFG");
        s1.addLast("XYZ");
        s1.addLast("EFG");

        SinglyLinkedList s2 = new SinglyLinkedList();
        s2.addLast("ABC");
        s2.addLast("DFG");
        s2.addLast("XYZ");
        s2.addLast("EFG");

        System.out.println("Initial List");
        s1.display();

        System.out.println("\nList after left shifting by 2 positions");
        shiftListLeft(s1, 2);
        s1.display();

        System.out.println("\nInitial List");
        s2.display();

        System.out.println("\nList after right shifting by 2 positions");
        shiftListRight(s2, 2);
        s2.display();
    }

    public static void shiftListLeft(SinglyLinkedList list, int n) {
        if (list.getHead() == null || n == 0)
            return;
        // Step 1: Find length
        int length = 0;
        Node temp = list.getHead();
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        n = n % length;//To reduce unnecessary rotations if n is large.
        if (n == 0) return;
        // Step 2: Rotate
        for (int i = 0; i < n; i++) {
            String data = list.getHead().getData(); // first node data
            list.delete(data);                      // remove from front
            list.addLast(data);                    // add at end
        }
    }

    public static void shiftListRight(SinglyLinkedList list, int n) {
        if (list.getHead() == null || n == 0)
            return;
        // Step 1: Find length
        int length = 0;
        Node temp = list.getHead();
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }
        n = n % length;
        if (n == 0) return;
        // Step 2: Rotate
        for (int i = 0; i < n; i++) {
            // Find last and second last
            Node prev = null;
            Node curr = list.getHead();
            while (curr.getNext() != null) {
                prev = curr;
                curr = curr.getNext();
            }
            String data = curr.getData();
            // Remove last
            list.delete(data);
            // Add at beginning
            list.addFirst(data);
        }
    }
}

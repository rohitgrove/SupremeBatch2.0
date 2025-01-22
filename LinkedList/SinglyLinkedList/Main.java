public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(10);
        ll.insertAtTail(20);
        ll.insertAtTail(30);
        ll.insertAtTail(50);
        ll.printLL();

        // ll.insertAtPosition(5, 1);
        ll.insertAtPosition2(1000, 3);
        ll.printLL();

        // // creation of node
        // Node first = new Node(10);
        // Node second = new Node(20);
        // Node third = new Node(30);
        // Node fourth = new Node(40);
        // Node fifth = new Node(50);
        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        // // linked list create ho chuki hai
        // System.out.println("Printing the entire LL: ");
        // LinkedList ll = new LinkedList();
        // ll.head = first;
        // ll.tail = fifth;
        // ll.printLL();

        // ll.insertAtTail(500);

        // ll.printLL();
    }
}

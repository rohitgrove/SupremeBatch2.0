public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.insertAtTail(10);
        // ll.insertAtTail(20);
        // ll.insertAtTail(30);
        // ll.insertAtTail(50);
        // ll.insertAtPosition(5, 1);
        // ll.insertAtPosition(100, 57);
        // System.out.println(ll.getLength());

        // ll.print();

        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.print();
        
        // ll.deleteAtPositionByPos(3);

        // ll.print();

        ll.deleteAtPositionByVal(30);
        ll.print();
    }
}

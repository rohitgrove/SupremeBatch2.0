public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(10);
        ll.insertAtHead(20);
        ll.insertAtHead(30);
        ll.print();
    
        ll.insertAtTail(50);
        ll.print();
        System.out.println(ll.getLength());
        ll.insertAtPosition(100, 3);
        ll.print();
        System.out.println(ll.getLength());
        ll.insertAtPosition2(450, 3);
        ll.print();
        System.out.println(ll.getLength());
        // ll.deleteAtHead();
        // ll.print();
        // ll.deleteAtTail();
        // ll.print();
        // ll.deleteAtPosition(2);
        // ll.print();
        ll.print();
        ll.deleteAtPositionByVal(450);
        ll.print();
    }
}

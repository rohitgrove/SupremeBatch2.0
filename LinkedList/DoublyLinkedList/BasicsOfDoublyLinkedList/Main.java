public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(40);
        dll.insertAtHead(30);
        dll.insertAtHead(20);
        dll.insertAtHead(10);
        dll.print();
        dll.insertAtTail(50);
        dll.print();
        dll.insertAtPosition(1000, 3);
        dll.print();
        // dll.revPrint();

        dll.deleteAtIndex(3);
        dll.print();
        System.out.println(dll.findLength());
        dll.deleteAtIndex(2);
        dll.print();
        dll.deleteAtIndex(2);
        dll.print();
        dll.deleteAtIndex(2);
        dll.print();
        dll.deleteAtIndex(2);
        dll.print();
        dll.deleteAtIndex(1);
        dll.print();
        System.out.println(dll.findLength());
    }
}

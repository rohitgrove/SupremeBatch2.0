public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.print();
        // ll.insertAtTail(1000);
        // ll.print();
        // ll.insertAtMiddle(5, 500);
        // ll.print();

        ll.deleteNode(4);
        ll.print();
        System.out.println(ll.findLength());
        ll.deleteNode(2);
        ll.print();
        System.out.println(ll.findLength());
        ll.deleteNode(2);
        ll.print();
        System.out.println(ll.findLength());
        ll.deleteNode(1);
        ll.print();
        System.out.println(ll.findLength());
    }
}

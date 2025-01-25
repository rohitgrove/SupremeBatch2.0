public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(20);
        ll.insertAtTail(40);
        ll.insertAtTail(60);
        ll.insertAtTail(80);
        ll.insertAtTail(100);
        ll.printLL();
        System.out.println(ll.getLength());
        ll.insertAtposition(101, 6);
        ll.printLL();
        System.out.println(ll.getLength());

        ll.deleteNode(6);
        ll.printLL();
        System.out.println(ll.getLength());
    }
}

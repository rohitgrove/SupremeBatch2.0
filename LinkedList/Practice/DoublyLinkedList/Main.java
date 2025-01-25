public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);

        // ll.printLL();

        // ll.insertAtPosition(6, 1000);
        ll.printLL();

        ll.deleteNode(4);
        ll.printLL();

        System.out.println(ll.size());
        ll.deleteNode(2);
        ll.printLL();

        System.out.println(ll.size());
        ll.deleteNode(2);
        ll.printLL();

        System.out.println(ll.size());
        ll.deleteNode(1);
        ll.printLL();

        System.out.println(ll.size());
    }
}

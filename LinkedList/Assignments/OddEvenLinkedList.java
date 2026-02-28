public class OddEvenLinkedList {
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node h1 = head; // odd node list
        Node h2 = head.next; //even node list
        Node evenHead = head.next;
        while (h2 != null && h2.next != null) {
            h1.next = h2.next;
            h2.next = h2.next.next;
            h1 = h1.next;
            h2 = h2.next;
        }

        // the two indipendent prepared has been regrouped
        // odd index wali list -> even index wali list
        h1.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        ll1.insertAtTail(6);
        ll1.printLL();
        ll1.printLL(oddEvenList(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(3);
        ll2.insertAtTail(4);
        ll2.insertAtTail(5);
        ll2.insertAtTail(6);
        ll2.insertAtTail(7);
        ll2.printLL();
        ll2.printLL(oddEvenList(ll2.head));
    }
}

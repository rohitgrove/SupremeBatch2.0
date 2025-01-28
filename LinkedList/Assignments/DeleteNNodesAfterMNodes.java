public class DeleteNNodesAfterMNodes {
    public static void linkdelete(Node head, int n, int m) {
        if (head == null) {
            return;
        }

        Node it = head;
        for (int i = 0; i < m - 1; i++) {
            // if M nodes are N.A.
            if (it == null) {
                return;
            }
            it = it.next;
        }

        // it would be at Mth node;
        if (it == null) {
            return;
        }

        Node MthNode = it;
        it = MthNode.next;
        for (int i = 0; i < n; i++) {
            if (it == null) {
                return;
            }
            it = it.next;
        }

        MthNode.next = it;
        linkdelete(it, n, m);
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(9);
        ll1.insertAtTail(1);
        ll1.insertAtTail(3);
        ll1.insertAtTail(5);
        ll1.insertAtTail(9);
        ll1.insertAtTail(4);
        ll1.insertAtTail(10);
        ll1.insertAtTail(1);
        linkdelete(ll1.head, 1, 2);
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(3);
        ll2.insertAtTail(4);
        ll2.insertAtTail(5);
        ll2.insertAtTail(6);
        linkdelete(ll2.head, 1, 6);
        ll2.printLL();

        LinkedList ll3 = new LinkedList();
        ll3.insertAtTail(3);
        ll3.insertAtTail(2);
        ll3.insertAtTail(0);
        ll3.insertAtTail(-4);
        ll3.insertAtTail(-1);
        linkdelete(ll3.head, 1, 1);
        ll3.printLL();
    }
}

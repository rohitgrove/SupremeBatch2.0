public class DeleteNNodesAfterMNodes {
    public static void linkdelete(Node head, int M, int N) {
        if (head == null) {
            return;
        }

        Node it = head;
        for (int i = 0; i < M - 1; i++) {
            // if M nodes are N.A
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
        for (int i = 0; i < N; i++) {
            if (it == null) {
                break;
            }
            it = it.next;
        }
        MthNode.next = it;
        linkdelete(it, M, N);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(9);
        ll.insertAtTail(1);
        ll.insertAtTail(3);
        ll.insertAtTail(5);
        ll.insertAtTail(9);
        ll.insertAtTail(4);
        ll.insertAtTail(10);
        ll.insertAtTail(1);
        ll.printLL();
        linkdelete(ll.head, 2, 1);
        ll.printLL();

        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(6);
        ll1.insertAtTail(5);
        ll1.insertAtTail(4);
        ll1.insertAtTail(3);
        ll1.insertAtTail(2);
        ll1.insertAtTail(1);
        ll1.printLL();
    }
}

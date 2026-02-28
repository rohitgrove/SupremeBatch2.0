import java.util.TreeMap;

public class UnionOfTwoLL {
    public static Node findUnion(Node head1, Node head2) {
        TreeMap<Integer, Node> maping = new TreeMap<>();
        Node curr = head1;

        // L1 hashed
        while (curr != null) {
            maping.put(curr.data, curr);
            curr = curr.next;
        }

        // L2 hashed
        curr = head2;
        while (curr != null) {
            maping.put(curr.data, curr);
            curr = curr.next;
        }

        Node UL = null;
        curr = null;
        // iterate Map & make final UL
        for (Node it : maping.values()) {
            if (UL == null) {
                UL = it;
                curr = UL;
            } else {
                if (curr != null) {
                    curr.next = it;
                    curr = curr.next;
                }
            }
        }
        if (curr != null) {
            curr.next = null;
        }

        return UL;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(9);
        ll1.insertAtTail(6);
        ll1.insertAtTail(4);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(8);
        System.out.println("Linked List 1: ");
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(8);
        ll2.insertAtTail(6);
        ll2.insertAtTail(2);
        System.out.println("Linked List 2: ");
        ll2.printLL();

        System.out.println("Union Linked List: ");
        ll2.printLL(findUnion(ll1.head, ll2.head));
    }
}
import java.util.TreeMap;

public class UnionOfTwoLL {
    public static Node findUnion(Node head1, Node head2) {
        TreeMap<Integer, Node> map = new TreeMap<>();
        Node curr = head1;

        // List 1 hashed
        while (curr != null) {
            map.put(curr.data, curr);
            curr = curr.next;
        }

        curr = head2;

        // List 2 hashed
        while (curr != null) {
            map.put(curr.data, curr);
            curr = curr.next;
        }

        Node UL = null;
        curr = null;

        // Iterate map and make final union list
        for (Node it : map.values()) {
            if (UL == null) {
                UL = it;
                curr = UL;
            } else {
                curr.next = it;
                curr = curr.next;
            }
        }

        if (curr != null) {
            curr.next = null;
        }

        return UL;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.addFirst(9);
        ll1.addLast(6);
        ll1.addLast(4);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(8);

        ll1.printLL(ll1.head);

        LinkedList ll2 = new LinkedList();
        ll2.addFirst(2);
        ll2.addFirst(6);
        ll2.addFirst(8);
        ll2.addFirst(2);
        ll2.addFirst(1);

        ll2.printLL(ll2.head);

        LinkedList ll3 = new LinkedList();
        ll3.head = findUnion(ll1.head, ll2.head);
        ll3.printLL(ll3.head);
    }
}

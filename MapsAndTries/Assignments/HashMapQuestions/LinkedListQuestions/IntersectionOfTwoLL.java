import java.util.HashMap;

public class IntersectionOfTwoLL {
    public static Node findIntersection(Node head1, Node head2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node curr = head2;
        // hash L2 items
        while (curr != null) {
            map.putIfAbsent(curr.data, 0);
            map.put(curr.data, map.get(curr.data) + 1);

            curr = curr.next;
        }

        Node IL = null;
        Node it = null;
        curr = head1;

        while (curr != null) {
            if (map.containsKey(curr.data)) {
                // node val found in L2
                if (IL == null) {
                    IL = curr;
                    it = IL;
                } else {
                    if (map.get(curr.data) > 0 && it != null) {
                        it.next = curr;
                        it = it.next;
                        map.put(curr.data, map.get(curr.data) - 1);
                    }
                }
            }

            curr = curr.next;
        }

        if (it != null) {
            it.next = null;
        }
        return IL;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(9);
        ll1.insertAtTail(6);
        ll1.insertAtTail(4);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(8);
        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(8);
        ll2.insertAtTail(6);
        ll2.printLL(findIntersection(ll1.head, ll2.head));
    }
}

import java.util.HashMap;

public class IntersectionOfTwoLL {
    public static Node findIntersection(Node head1, Node head2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node curr = head2;

        while (curr != null) {
            int count = 0;
            if (map.containsKey(curr.data)) {
                count = map.get(curr.data);
            }
            map.put(curr.data, count + 1);
            curr = curr.next;
        }

        Node ll = null;
        Node it = null;
        curr = head1;

        while (curr != null) {
            if (map.containsKey(curr.data)) {
                if (ll == null) {
                    ll = curr;
                    it = ll;
                } else {
                    it.next = curr;
                    it = curr;
                }
            } 

            curr = curr.next;
        }

        if (it != null) {
            it = it.next;
        }

        return ll;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.addFirst(9);
        ll1.addLast(6);
        ll1.addLast(4);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(8);

        LinkedList ll2 = new LinkedList();
        ll2.addFirst(1);
        ll2.addLast(2);
        ll2.addLast(8);
        ll2.addLast(6);

        LinkedList ll3 = new LinkedList();
        ll3.head = findIntersection(ll1.head, ll2.head);
        ll3.printLL();
    }
}

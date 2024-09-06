import java.util.HashMap;

public class IntersectionOfTwoLL {
    public static Node findIntersection(Node head1, Node head2) { // tc: O(n+m)
        HashMap<Integer, Integer> map = new HashMap<>();
        Node curr = head2;

        // hash l2 items
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
                // value found in ll2
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
            it.next = null;            
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

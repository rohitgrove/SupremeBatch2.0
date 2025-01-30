import java.util.HashMap;

public class RemoveZeroSumFromConsicutiveNodes {
    public static void sanitizeMap(Node head, HashMap<Integer, Node> mp, int csum) {
        int temp = csum;
        while (true) {
            temp += head.data;
            if (temp == csum) {
                break;
            }
            mp.remove(temp);
            head = head.next;
        }
    }

    public static Node removeZeroSumSublists(Node head) {
        if (head == null || (head.next == null && head.data == 0)) return null;

        HashMap<Integer, Node> mp = new HashMap<>();
        Node it = head;
        int cSum = 0;

        while (it != null) {
            cSum += it.data;

            if (cSum == 0) {
                head = it.next;
                mp.clear();
            } else if (mp.containsKey(cSum)) {
                sanitizeMap(mp.get(cSum).next, mp, cSum);
                mp.get(cSum).next = it.next;
            } else {
                mp.put(cSum, it);
            }

            it = it.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(-3);
        ll1.insertAtTail(3);
        ll1.insertAtTail(1);
        // ll1.printLL();
        ll1.printLL(removeZeroSumSublists(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(3);
        ll2.insertAtTail(-3);
        ll2.insertAtTail(4);
        // ll2.printLL();
        ll2.printLL(removeZeroSumSublists(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtTail(1);
        ll3.insertAtTail(2);
        ll3.insertAtTail(3);
        ll3.insertAtTail(-3);
        ll3.insertAtTail(-2);
        // ll3.printLL();
        ll3.printLL(removeZeroSumSublists(ll3.head));

        LinkedList ll4 = new LinkedList();
        ll4.insertAtTail(-9);
        ll4.insertAtTail(2);
        ll4.insertAtTail(3);
        ll4.insertAtTail(-2);
        ll4.insertAtTail(-3);
        ll4.insertAtTail(9);
        ll4.insertAtTail(1);
        // ll4.printLL();
        ll4.printLL(removeZeroSumSublists(ll4.head));
    }
}

import java.util.HashMap;

public class RemoveZeroSumConsicutiveNumbers {
    public static Node removeZeroSumSublists(Node head) {
        if (head == null) {
            return head;
        }

        HashMap<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        dummy.next = head;
        map.put(0, dummy);

        int preSum = 0;
        while (head != null) {
            preSum += head.data;
            if (map.containsKey(preSum)) {
                Node start = map.get(preSum);
                int prevSum = preSum;
                while (start != null && start != head) {
                    start = start.next;
                    prevSum += start.data;
                    if (start != head) {
                        map.remove(prevSum);
                    }
                }
                map.get(preSum).next = start.next;
            } else {
                map.put(preSum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(-3);
        ll1.insertAtTail(3);
        ll1.insertAtTail(1);
        ll1.printLL();
        ll1.head = removeZeroSumSublists(ll1.head);
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(3);
        ll2.insertAtTail(-3);
        ll2.insertAtTail(4);
        ll2.printLL();
        ll2.head = removeZeroSumSublists(ll2.head);
        ll2.printLL();

        LinkedList ll3 = new LinkedList();
        ll3.insertAtTail(1);
        ll3.insertAtTail(2);
        ll3.insertAtTail(3);
        ll3.insertAtTail(-3);
        ll3.insertAtTail(-2);
        ll3.printLL();
        ll3.head = removeZeroSumSublists(ll3.head);
        ll3.printLL();
    }
}

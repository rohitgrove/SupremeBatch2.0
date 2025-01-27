public class LinkedListReverseInKGroup {
    public static int getLength(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1 case
        Node prev = null;
        Node curr = head;
        Node nextNode = curr.next;
        int pos = 0;
        int len = getLength(head);

        if (len < k) {
            return head;
        }

        while (pos < k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            pos++;
        }

        if (nextNode != null) {
            Node recursionAns = reverseKGroup(nextNode, k);
            head.next = recursionAns;
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        ll1.insertAtTail(6);
        ll1.insertAtTail(7);
        ll1.printLL(reverseKGroup(ll1.head, 2));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(3);
        ll2.insertAtTail(4);
        ll2.insertAtTail(5);
        ll2.printLL(reverseKGroup(ll2.head, 2));
    }
}

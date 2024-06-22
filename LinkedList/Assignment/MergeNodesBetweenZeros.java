public class MergeNodesBetweenZeros {
    public static Node mergeNodes(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head.next, newLastNode = null;
        int sum = 0;
        while (fast != null) {
            if (fast.data != 0) {
                sum += fast.data;
            } else {
                // fast.data == 0
                slow.data = sum;
                newLastNode = slow;
                slow = slow.next;
                sum = 0;
            }
            fast = fast.next;
        }

        // just forward new list
        newLastNode.next = null;
        return head;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(0);
        ll1.insertAtTail(3);
        ll1.insertAtTail(1);
        ll1.insertAtTail(0);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        ll1.insertAtTail(2);
        ll1.insertAtTail(0);
        ll1.printLL();
        ll1.printLL(mergeNodes(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(0);
        ll2.insertAtTail(1);
        ll2.insertAtTail(0);
        ll2.insertAtTail(3);
        ll2.insertAtTail(0);
        ll2.insertAtTail(2);
        ll2.insertAtTail(2);
        ll2.insertAtTail(0);
        ll2.printLL();
        ll2.printLL(mergeNodes(ll2.head));
    }    
}

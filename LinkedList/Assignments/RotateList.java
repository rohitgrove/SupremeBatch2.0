public class RotateList {
    public static int getLength(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public static Node rotateRight(Node head, int k) {
        if (head == null) {
            return head;
        }
        int len = getLength(head);
        int actualRotateK = (k % len);
        if (actualRotateK == 0) {
            return head;
        }

        int newLastNodePos = len - actualRotateK - 1;
        Node newLastNode = head;
        for (int i = 0; i < newLastNodePos; i++) {
            newLastNode = newLastNode.next;
        }

        Node newHead = newLastNode.next;
        newLastNode.next = null;

        Node it = newHead;
        while (it.next != null) {
            it = it.next;
        }

        it.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtPosition(1, 1);
        ll1.insertAtPosition(2, 2);
        ll1.insertAtPosition(3, 3);
        ll1.insertAtPosition(4, 4);
        ll1.insertAtPosition(5, 5);
        ll1.printLL();
        ll1.printLL(rotateRight(ll1.head, 2));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(0);
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        ll2.printLL();
        ll2.printLL(rotateRight(ll2.head, 4));
    }
}

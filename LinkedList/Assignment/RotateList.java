public class RotateList {
    public static int getLength(Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static Node rotateRight(Node head, int k) {
        if (head == null) {
            return null;
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
        Node newHeadNode = newLastNode.next;
        newLastNode.next = null;
        Node it = newHeadNode;
        while (it.next != null) {
            it = it.next;
        }

        it.next = head;
        return newHeadNode;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        int k1 = 2;
        ll1.printLL();
        ll1.head = rotateRight(ll1.head, k1);
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(0);
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        int k2 = 4;
        ll2.printLL();
        ll2.head = rotateRight(ll2.head, k2);
        ll2.printLL();
    }
}

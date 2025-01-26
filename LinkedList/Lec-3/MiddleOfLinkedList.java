public class MiddleOfLinkedList {
    public static int getLength(Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public static Node middleNodeByIndexes (Node head) {
        int n = getLength(head);
        int position = n / 2 + 1;
        Node temp = head;
        while (position != 1) {
            temp = temp.next;
            position--;
        }
        return temp;
    }

    public static Node tortoiseAndHareApproach(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node middleNode(Node head) {
        return tortoiseAndHareApproach(head);
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(2);
        ll1.insertAtTail(4);
        ll1.insertAtTail(6);
        ll1.insertAtTail(8);
        ll1.insertAtTail(10);
        ll1.printLL();
        System.out.println(middleNode(ll1.head).data);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtPosition(2, 1);
        ll2.insertAtPosition(4, 2);
        ll2.insertAtPosition(6, 3);
        ll2.insertAtPosition(8, 4);
        ll2.insertAtPosition(10, 5);
        ll2.insertAtPosition(12, 6);
        ll2.printLL();
        System.out.println(middleNode(ll2.head).data);

        LinkedList ll3 = new LinkedList();
        ll3.insertAtPosition(1, 1);
        ll3.insertAtPosition(2, 2);
        ll3.insertAtPosition(3, 3);
        ll3.insertAtPosition(4, 4);
        ll3.insertAtPosition(5, 5);
        ll3.printLL();
        System.out.println(middleNode(ll3.head).data);

        LinkedList ll4 = new LinkedList();
        ll4.insertAtPosition(1, 1);
        ll4.insertAtPosition(2, 2);
        ll4.insertAtPosition(3, 3);
        ll4.insertAtPosition(4, 4);
        ll4.insertAtPosition(5, 5);
        ll4.insertAtPosition(6, 6);
        ll4.printLL();
        System.out.println(middleNode(ll4.head).data);
    }
}

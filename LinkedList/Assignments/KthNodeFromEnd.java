public class KthNodeFromEnd {
    public static int len(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static Node findKthFromLastUsingItr(Node list, int positionFromTail) {
        int len = len(list);
        int pos = len - positionFromTail - 1;
        Node temp = list;
        while (pos > 0) {
            temp = temp.next;
            pos--;
        }

        return temp;
    }

    public static Node findKthFromLastUsingRec(Node head, int positionFromTail, int[] currentPosition) {
        if (head == null) {
            return head;
        }
        Node value = findKthFromLastUsingRec(head.next, positionFromTail, currentPosition);

        currentPosition[0]++;

        if (currentPosition[0] == positionFromTail) {
            return head;
        }

        return value;
    }

    public static Node findKthFromLast(Node list, int positionFromTail) {
        int[] currentPosition = new int[1];
        currentPosition[0] = -1;
        return findKthFromLastUsingRec(list, positionFromTail, currentPosition);
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(3);
        ll1.insertAtTail(2);
        ll1.insertAtTail(1);
        System.out.println(findKthFromLast(ll1.head, 2).data);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(43);
        ll2.insertAtTail(6);
        ll2.insertAtTail(9);
        ll2.insertAtTail(1);
        ll2.insertAtTail(5);
        ll2.insertAtTail(-1);
        System.out.println(findKthFromLast(ll2.head, 4).data);

        LinkedList ll3 = new LinkedList();
        ll3.insertAtTail(3);
        ll3.insertAtTail(7);
        ll3.insertAtTail(-32);
        ll3.insertAtTail(8);
        ll3.insertAtTail(11);
        ll3.insertAtTail(-1);
        System.out.println(findKthFromLast(ll3.head, 5).data);

        LinkedList ll4 = new LinkedList();
        ll4.insertAtTail(2);
        ll4.insertAtTail(26);
        ll4.insertAtTail(35);
        ll4.insertAtTail(5);
        ll4.insertAtTail(-1);
        System.out.println(findKthFromLast(ll4.head, 1).data);
    }
}

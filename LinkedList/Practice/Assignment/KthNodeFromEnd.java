public class KthNodeFromEnd {
    public static int len(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public static Node findKthFromLastUsingItr(Node head, int k) {
        int len = len(head);

        int position = len - k - 1;
        Node temp = head;

        while (position > 0) {
            temp = temp.next;
            position--;
        }

        return temp;
    }

    public static Node findKthFromLastUsingRec(Node head, int kthPositionFromEnd, int currPosition[]) {
        if (head == null) {
            return head;
        }

        Node value = findKthFromLastUsingRec(head.next, kthPositionFromEnd, currPosition);

        currPosition[0]++;
        if (currPosition[0] == kthPositionFromEnd) {
            return head;
        }

        return value;
    }

    public static Node findKthFromLast(Node head, int k) {
        int currPosition[] = new int[1];
        currPosition[0] = -1;
        return findKthFromLastUsingRec(head, k, currPosition);
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
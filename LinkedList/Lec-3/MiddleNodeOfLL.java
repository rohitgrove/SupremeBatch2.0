public class MiddleNodeOfLL {
    public static int getLength(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public  static Node simpleApproachOfMiddleNode(Node head) {
        int length = getLength(head);
        int position = (length / 2) + 1;

        int currPos = 1;
        Node temp = head;
        while (currPos != position) {
            temp = temp.next;
            currPos++;
        }
        return temp;
    }

    public static Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node middleNode(Node head) {
        return slowFastApproach(head);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(60);
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.printLL();
        System.out.println(middleNode(ll.head).data);
    }
}

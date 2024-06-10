public class MiddleNodeOfLL {
    public int getLength(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public Node simpleApproachOfMiddleNode(Node head) {
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

    public Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node middleNode(Node head) {
        return slowFastApproach(head);
    }
}

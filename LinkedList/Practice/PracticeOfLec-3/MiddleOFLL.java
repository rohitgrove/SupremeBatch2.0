public class MiddleOFLL {
    public int getLength(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public Node simpleApproach(Node head) {
        int length = getLength(head);
        int pos = (length / 2) + 1;
        int idx = 1;
        Node temp = head;
        while (idx != pos) {
            idx++;
            temp = temp.next;
        }

        return temp;
    }

    public Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public Node middleOfLL(Node head) {
        return slowFastApproach(head);
    }
}

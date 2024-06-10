public class ReverseALinkedList {
    public Node reverseListitr(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public Node reverseListrec(Node prev, Node curr) {
        // base case
        if (curr == null) {
            return prev;
        }

        Node nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
        return reverseListrec(prev, curr);
    }

    public Node reverseList(Node head) {
        return reverseListrec(null, head);
    }
}

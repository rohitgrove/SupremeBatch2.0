public class ReverseALinkedList {
    public static Node reverseListUsingLoop(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node reverseListUsingRec(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }

        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

        return reverseListUsingRec(prev, curr);
    }

    public static Node reverseList(Node head) {
        return reverseListUsingRec(null, head);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(1);
        ll.insertAtTail(2);
        ll.insertAtTail(3);
        ll.insertAtTail(4);
        ll.insertAtTail(5);
        ll.printLL();
        ll.printLL(reverseList(ll.head));
    }
}

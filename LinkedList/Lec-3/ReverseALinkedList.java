public class ReverseALinkedList {
    public static Node reverseListitr(Node head) {
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

    public static Node reverseListrec(Node prev, Node curr) {
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

    public static Node reverseList(Node head) {
        return reverseListrec(null, head);
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.printLL();
        ll.printLL(reverseList(ll.head));
    }
}

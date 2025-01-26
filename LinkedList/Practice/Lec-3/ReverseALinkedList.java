public class ReverseALinkedList {
    public static Node reverseListUisingItr(Node head) {
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

    public static Node reverseListUisingRec(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }

        Node nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;

        return reverseListUisingRec(prev, curr);
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        return reverseListUisingRec(prev, curr);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.printLL();
        ll.printLL(reverseList(ll.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(9);
        ll2.insertAtHead(8);
        ll2.insertAtHead(6);
        ll2.insertAtHead(4);
        ll2.insertAtHead(2);
        ll2.printLL();
        ll2.printLL(reverseList(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtHead(8);
        ll3.insertAtHead(6);
        ll3.insertAtHead(4);
        ll3.insertAtHead(2);
        ll3.printLL();
        ll3.printLL(reverseList(ll3.head));
    }

}
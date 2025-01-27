public class Add1ToALinkedList {
    public static Node reverseLL(Node head) {
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

    public static Node addOne(Node head) {
        // reverse
        head = reverseLL(head);
        // add1
        int carry = 1;
        Node temp = head;
        while (temp.next != null) {
            int totalSum = temp.data + carry;
            int digit = totalSum % 10;
            carry = totalSum / 10;

            temp.data = digit;
            temp = temp.next;
            if (carry == 0) {
                break;
            }
        }

        // process Last Node
        if (carry != 0) {
            int totalSum = temp.data + carry;
            int digit = totalSum % 10;
            carry = totalSum / 10;

            temp.data = digit;
            if (carry != 0) {
                Node newNode = new Node(carry);
                temp.next = newNode;
            }
        }

        // reverse
        head = reverseLL(head);

        return head;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(1);
        ll1.insertAtTail(3);
        ll1.insertAtTail(7);
        ll1.printLL();
        ll1.printLL(addOne(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(1);
        ll2.insertAtTail(3);
        ll2.insertAtTail(9);
        ll2.printLL();
        ll2.printLL(addOne(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtHead(9);
        ll3.insertAtHead(9);
        ll3.insertAtHead(9);
        ll3.printLL();
        ll3.printLL(addOne(ll3.head));
    }
}

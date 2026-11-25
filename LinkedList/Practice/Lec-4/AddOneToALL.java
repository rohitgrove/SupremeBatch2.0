public class AddOneToALL {
    public static Node reverseLL(Node head) {
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

    public static Node addOne(Node head) {
        head = reverseLL(head);

        Node temp = head;
        int carry = 1;

        while (temp.next != null) {
            int totalSum = temp.data + carry;
            carry = totalSum / 10;
            int digit = totalSum % 10;

            temp.data = digit;
            temp = temp.next;
            if (carry == 0) {
                break;
            }
        }

        if (carry != 0) {
            int totalSum = temp.data + carry;
            carry = totalSum / 10;
            int digit = totalSum % 10;

            temp.data = digit;
            if (carry != 0) {
                Node newNode = new Node(carry);
                temp.next = newNode;
            }
        }

        head = reverseLL(head);
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(6);
        ll1.insertAtHead(5);
        ll1.insertAtHead(4);
        ll1.printLL();
        ll1.printLL(addOne(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(3);
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        ll2.printLL();
        ll2.printLL(addOne(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtHead(9);
        ll3.insertAtHead(9);
        ll3.insertAtHead(1);
        ll3.printLL();
        ll3.printLL(addOne(ll3.head));
    }
}

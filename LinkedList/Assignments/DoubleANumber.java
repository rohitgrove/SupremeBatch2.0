public class DoubleANumber {
    public static int carry = 0;
    public static void solve(Node head) {
        if (head == null) {
            return;
        }

        solve(head.next);

        int sum = (head.data * 2) + carry;
        head.data = sum % 10;
        carry = sum / 10;
    }

    public static Node doubleIt(Node head) {
        solve(head);
        if (carry != 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(8);
        ll1.insertAtTail(9);
        ll1.printLL();
        ll1.printLL(doubleIt(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(9);
        ll2.insertAtTail(9);
        ll2.insertAtTail(9);
        ll2.printLL();
        ll2.printLL(doubleIt(ll2.head));
    }
}

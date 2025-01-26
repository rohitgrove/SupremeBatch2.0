public class PalindromeOfLL {
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node reverseList(Node head) {
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

    public static boolean compareList(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null & temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public static boolean isPalindrome(Node head) {
        // break into 2 halfes
        Node midNode = middleNode(head);
        Node head2 = midNode.next;
        midNode.next = null;
        // reverse second halfes
        head2 = reverseList(head2);

        // compare both linked list
        boolean ans = compareList(head, head2);
        return ans;
    }

    public static void main(String[] args) {
        LinkedList oddLL = new LinkedList();
        oddLL.insertAtPosition(1, 1);
        oddLL.insertAtPosition(2, 2);
        oddLL.insertAtPosition(3, 3);
        oddLL.insertAtPosition(2, 4);
        oddLL.insertAtPosition(1, 5);
        System.out.println(isPalindrome(oddLL.head));

        LinkedList evenLL = new LinkedList();
        evenLL.insertAtPosition(1, 1);
        evenLL.insertAtPosition(2, 2);
        evenLL.insertAtPosition(3, 3);
        evenLL.insertAtPosition(4, 4);
        evenLL.insertAtPosition(2, 5);
        evenLL.insertAtPosition(1, 6);
        System.out.println(isPalindrome(evenLL.head));
    }
}

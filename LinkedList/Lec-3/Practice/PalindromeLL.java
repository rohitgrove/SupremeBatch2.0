public class PalindromeLL {
    public Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

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

    public boolean compare(Node head, Node head2) {
        Node temp = head, temp2 = head2;
        while (temp2 != null) {
            if (temp.data != temp2.data) {
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public boolean isPalindrome(Node head) {
        Node midNode = slowFastApproach(head);
        Node head2 = midNode.next;
        head2 = reverseListitr(head2);
        return compare(head, head2);
    }
}

public class PalindromeLL {
    public Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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

    public boolean compareList(Node head, Node head2) {
        while (head != null && head2 != null) {
            if (head.data != head2.data) {
                return false;
            } else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    public boolean isPalindrome(Node head) {
        // break into two halfs
        Node midNode = slowFastApproach(head);
        Node head2 = midNode.next;
        midNode.next = null;
       
        // reverse second half
        Node prev = null;
        Node curr = head2;
        head2 = reverseListrec(prev, curr); 

        // comapre both LinkedList
        boolean ans = compareList(head, head2);
        return ans;
    }
}

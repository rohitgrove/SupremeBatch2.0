public class PalindromeLL {
    public ListNode slowFastApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseListrec(ListNode prev, ListNode curr) {
        // base case
        if (curr == null) {
            return prev;
        }

        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
        return reverseListrec(prev, curr);
    }

    public boolean compareList(ListNode head, ListNode head2) {
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

    public boolean isPalindrome(ListNode head) {
        // break into two halfs
        ListNode midNode = slowFastApproach(head);
        ListNode head2 = midNode.next;
        midNode.next = null;
        // reverse second half

        ListNode prev = null;
        ListNode curr = head2;
        head2 = reverseListrec(prev, curr); 

        // comapre both LinkedList
        boolean ans = compareList(head, head2);
        return ans;
    }
}

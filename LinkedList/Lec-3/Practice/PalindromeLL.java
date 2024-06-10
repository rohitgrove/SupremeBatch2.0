public class PalindromeLL {
    public ListNode slowFastApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverseListitr(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public boolean compare(ListNode head, ListNode head2) {
        ListNode temp = head, temp2 = head2;
        while (temp2 != null) {
            if (temp.data != temp2.data) {
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode midNode = slowFastApproach(head);
        ListNode head2 = midNode.next;
        head2 = reverseListitr(head2);
        return compare(head, head2);
    }
}

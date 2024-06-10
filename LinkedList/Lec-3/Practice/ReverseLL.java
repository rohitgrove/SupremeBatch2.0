public class ReverseLL {
    public ListNode reverseListrec(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }

        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
        return reverseListrec(prev, curr);
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
    
    public ListNode reverseList(ListNode head) {
        return reverseListrec(null, head);
    }    
}

public class MiddleOFLL {
    public int getLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public ListNode simpleApproach(ListNode head) {
        int length = getLength(head);
        int pos = (length / 2) + 1;
        int idx = 1;
        ListNode temp = head;
        while (idx != pos) {
            idx++;
            temp = temp.next;
        }

        return temp;
    }

    public ListNode slowFastApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode middleOfLL(ListNode head) {
        return slowFastApproach(head);
    }
}

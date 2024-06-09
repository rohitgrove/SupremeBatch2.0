public class MiddleNodeOfLL {
    public int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public ListNode simpleApproachOfMiddleNode(ListNode head) {
        int length = getLength(head);
        int position = (length / 2) + 1;

        int currPos = 1;
        ListNode temp = head;
        while (currPos != position) {
            temp = temp.next;
            currPos++;
        }
        return temp;
    }

    public ListNode slowFastApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode middleNode(ListNode head) {
        return slowFastApproach(head);
    }
}

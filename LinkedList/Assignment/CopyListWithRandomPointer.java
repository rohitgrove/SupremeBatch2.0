import java.util.HashMap;

public class CopyListWithRandomPointer {
    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static ListNode helper1(ListNode head, HashMap<ListNode, ListNode> mp) { // t.c: O(n), s.c: O(n)
        if (head == null) {
            return null;
        }   

        ListNode newNode = new ListNode(head.val);
        mp.put(head, newNode);
        newNode.next = helper1(head.next, mp);
        if (head.random != null) {
            newNode.random = mp.get(head.random);
        }
        return newNode;
    }

    public static ListNode helper2(ListNode head) {// t.c: O(1)
        if (head == null) return null;

        // Step 1: Clone A -> A'
        ListNode it = head; // iterate over old head

        while (it != null) {
            ListNode clonedNode = new ListNode(it.val);
            clonedNode.next = it.next;
            it.next = clonedNode;
            it = clonedNode.next;
        }

        // Step 2: Assign random links of A' with the help of original nodes
        it = head;

        while (it != null) {
            ListNode clonedNode = it.next;
            clonedNode.random = (it.random != null) ? it.random.next : null;
            it = clonedNode.next;
        }

        // Step 3: Detach A' from A.
        it = head;
        ListNode clonedHead = head.next;

        while (it != null) {
            ListNode clonedNode = it.next;
            it.next = clonedNode.next;
            if (clonedNode.next != null) {
                clonedNode.next = clonedNode.next.next;
            }
            it = it.next;
        }

        return clonedHead;
    }

    public static ListNode copyRandomList(ListNode head) {
        // HashMap<ListNode, ListNode> mp = new HashMap<>(); // old node- --> new node mapping
        // return healper1(head, mp);

        return helper2(head);
    }
    
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            if (temp.random != null) {
                System.out.print(temp.random.val + " ");
            } else {
                System.out.print("null ");
            }
            System.out.print("| ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(7);
        ListNode second = new ListNode(13);
        ListNode third = new ListNode(11);
        ListNode fourth = new ListNode(10);
        ListNode fifth = new ListNode(1);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        second.random = first;
        third.random = fifth;
        fourth.random = third;
        fifth.random = first;

        ListNode head = first;
        System.out.println("Original List:");
        printLL(head);

        ListNode copiedHead = copyRandomList(head);
        System.out.println("Copied List:");
        printLL(copiedHead);
    }
}

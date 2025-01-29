import java.util.HashMap;

public class CloneLLWithRandomPointer {
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.random != null) {
                System.out.print(" { " + temp.data + " Random: " + temp.random.data + " } -> ");
            } else {
                System.out.print(" { " + temp.data + " Random: Null  } -> ");
            }
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static ListNode copyRandomListUsingMap(ListNode head, HashMap<ListNode, ListNode> mp) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.data);
        mp.put(head, newHead);
        newHead.next = copyRandomListUsingMap(head.next, mp);

        if (head.random != null) {
            newHead.random = mp.get(head.random);
        }

        return head;
    }

    public static ListNode copyRandomListWithoutUsingMap(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode it = head;
        while (it != null) {
            ListNode newNode = new ListNode(it.data);
            newNode.next = it.next;
            it.next = newNode;
            it = it.next.next;
        }

        it = head;
        while (it != null) {
            ListNode cloneNode = it.next;
            if (it.random != null) {
                cloneNode.random = it.random.next;
            }
            it = it.next.next;
        }

        it = head;
        ListNode clonedHead = it.next;
        while (it != null) {
            ListNode cloneNode = it.next;
            it.next = it.next.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            it = it.next;
        }

        return clonedHead;
    }

    public static ListNode copyRandomList(ListNode head) {
        // HashMap<ListNode, ListNode> mp = new HashMap<>();
        // return copyRandomListUsingMap(head, mp);
        return copyRandomListWithoutUsingMap(head);
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
        printLL(head);
        printLL(copyRandomList(head));
    }
}
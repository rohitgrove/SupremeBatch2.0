import java.util.PriorityQueue;
import java.util.Comparator;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Comp implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}

public class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comp());

        // Add the head of each list to the priority queue
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode ansHead = new ListNode(-1); // Dummy head node
        ListNode it = ansHead;

        // Merge the lists
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();

            it.next = top;
            if (top.next != null) {
                pq.offer(top.next);
            }

            it = it.next;
        }

        return ansHead.next; // Return the merged list starting from the first real node
    }
       
    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        ListNode firstHead = new ListNode(1);
        firstHead.next = new ListNode(4);
        firstHead.next.next = new ListNode(5);

        ListNode secondHead = new ListNode(1);
        secondHead.next = new ListNode(3);
        secondHead.next.next = new ListNode(4);

        ListNode thirdHead = new ListNode(2);
        thirdHead.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = firstHead;
        lists[1] = secondHead;
        lists[2] = thirdHead;

        ListNode sortedList = mergeKLists(lists);
        print(sortedList);
    }
}

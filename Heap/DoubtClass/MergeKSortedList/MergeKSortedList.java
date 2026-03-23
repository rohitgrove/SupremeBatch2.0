import java.util.PriorityQueue;

public class MergeKSortedList {
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        // Insert the first node of each list into the priority queue
        for (Node head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        Node ansHead = new Node(-1); // Dummy node
        Node it = ansHead;

        while (!pq.isEmpty()) {
            Node top = pq.poll(); // Extract minimum node
            it.next = top;
            if (top.next != null) {
                pq.offer(top.next);
            }
            it = it.next;
        }

        return ansHead.next;
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(4);
        head1.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node head3 = new Node(2);
        head3.next = new Node(6);

        Node lists[] = { head1, head2, head3 };

        printList(mergeKLists(lists));
    }
}

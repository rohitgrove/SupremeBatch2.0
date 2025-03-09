import java.util.PriorityQueue;

public class MergeKSortedList {
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        // process first element of every LL
        for (Node listHead : lists) {
            if (listHead != null) {
                pq.offer(listHead);
            }
        }

        // for new LL
        Node head = null;
        Node tail = null;

        while (!pq.isEmpty()) {
            Node topNode = pq.poll();

            // ye frontNode jo nikali hai
            // ye hamari first node ho;
            if (tail == null) {
                // pehli node insert krra hu
                head = topNode;
                tail = topNode;
                if (tail.next != null) {
                    pq.offer(tail.next);
                }
            } else {
                // pehle ke baad me koi node insert krra hu
                tail.next = topNode;
                tail = topNode;
                if (tail.next != null) {
                    pq.offer(tail.next);
                }
            }
        }

        return head;
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

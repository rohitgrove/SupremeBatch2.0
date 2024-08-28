import java.util.PriorityQueue;
import java.util.Comparator;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Coustom implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.val - o2.val;
    }
}

public class MergeKSortedList {
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Coustom());

        // process first element of every ll
        for (int i = 0; i < lists.length; i++) {
            Node listHead = lists[i];
            if (listHead != null) {
                pq.add(listHead);                
            }
        }

        // for new ll
        Node head = null;
        Node tail = null;

        while (!pq.isEmpty()) {
            Node topNode = pq.poll();

            // ye frontnode jo nikali hai,
            // ye hamari first node ho
            if (head == null) {
                // pehli node insert karra hu
                head = topNode;
                tail = topNode;
                if (tail.next != null) {
                    pq.add(tail.next);
                }
            } else {
                // phele ke baad me koi node insert karra hu
                tail.next = topNode;
                tail = topNode;
                if (tail.next != null) {
                    pq.add(topNode.next);
                }
            }
        }

        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node firstHead = new Node(1);
        firstHead.next = new Node(4);
        firstHead.next.next = new Node(5);

        Node secondHead = new Node(1);
        secondHead.next = new Node(3);
        secondHead.next.next = new Node(4);

        Node thirdHead = new Node(2);
        thirdHead.next = new Node(6);

        Node[] lists = new Node[3];
        lists[0] = firstHead;
        lists[1] = secondHead;
        lists[2] = thirdHead;

        Node sortedList = mergeKLists(lists);
        print(sortedList);
    }
}

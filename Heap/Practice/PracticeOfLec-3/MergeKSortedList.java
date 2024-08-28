import java.util.PriorityQueue;
import java.util.Comparator;

class Node {
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Coustom implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.data - o2.data;
    }
    
}

public class MergeKSortedList {
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Coustom());

        for (int row = 0; row < lists.length; row++) {
            Node listHead = lists[row];
            if (listHead != null) {
                pq.add(listHead);
            }
        }

        Node head = null;
        Node tail = null;
        while (!pq.isEmpty()) {
            Node currNode = pq.poll();

            if (head == null) {
                head = currNode;
                tail = currNode;
                if (tail.next != null) {
                    pq.add(tail.next); 
                }
            } else {
                tail.next = currNode;
                tail = currNode;
                if (tail.next != null) {
                    pq.add(tail.next); 
                }
            }
        }

        return head;
    }  

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
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

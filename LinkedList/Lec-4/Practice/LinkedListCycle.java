import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    public static boolean mapApproach(Node head) {
        Map<Node, Boolean> table = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            if (table.getOrDefault(temp, false)) {
                return true;
            } else {
                table.put(temp, true);
            }
            temp = temp.next;
        }

        return false;
    }

    public static boolean slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle(Node head) {
        return slowFastApproach(head);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); 
        ll.insertAtHead(70);
        ll.insertAtHead(60);
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.tail.next = ll.head.next.next;
        ll.tail.next = ll.head.next.next.next;
        System.out.println(hasCycle(ll.head));
    }
}

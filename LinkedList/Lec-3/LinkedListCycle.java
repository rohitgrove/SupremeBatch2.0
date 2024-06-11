import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        Map<Node, Boolean> table = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            if (table.getOrDefault(temp, false)) {
                // Cycle present
                return true;
            } else {
                table.put(temp, true);
            }
            temp = temp.next;
        }
        // Loop not present
        return false;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(60);
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.printLL();
        ll.tail.next = ll.head.next.next;
        System.out.println(hasCycle(ll.head));
    }
}

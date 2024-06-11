import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    public boolean mapApproach(Node head) {
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

    public boolean slowFastApproach(Node head) {
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

    public boolean hasCycle(Node head) {
        return slowFastApproach(head);
    }
}

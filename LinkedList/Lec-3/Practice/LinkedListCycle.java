import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    public boolean hasCycle(Node head) {
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
}

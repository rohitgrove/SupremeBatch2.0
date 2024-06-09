import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> table = new HashMap<>();

        ListNode temp = head;
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

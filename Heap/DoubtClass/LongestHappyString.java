import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        // Create a max-heap (PriorityQueue) based on frequency
        PriorityQueue<Map.Entry<Integer, Character>> pq = new PriorityQueue<>(
            (entry1, entry2) -> entry2.getKey() - entry1.getKey()
        );

        // Initialize the priority queue with non-zero counts
        if (a > 0) pq.offer(new HashMap.SimpleEntry<>(a, 'a'));
        if (b > 0) pq.offer(new HashMap.SimpleEntry<>(b, 'b'));
        if (c > 0) pq.offer(new HashMap.SimpleEntry<>(c, 'c'));

        // Build the answer string
        StringBuilder ans = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Character> top = pq.poll();

            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != top.getValue()) {
                // Add at most 2 of the maximum frequency character
                int times = Math.min(top.getKey(), 2);
                for (int i = 0; i < times; ++i) {
                    ans.append(top.getValue());
                }
                top = new HashMap.SimpleEntry<>(top.getKey() - times, top.getValue());
                if (top.getKey() > 0) {
                    pq.offer(top);
                }
            } else if (!pq.isEmpty()) {
                // Add at most 1 of the next maximum frequency character
                Map.Entry<Integer, Character> top2 = pq.poll();
                ans.append(top2.getValue());
                top2 = new HashMap.SimpleEntry<>(top2.getKey() - 1, top2.getValue());
                if (top2.getKey() > 0) {
                    pq.offer(top2);
                }
                // Return the max char we popped out earlier to the pq
                pq.offer(top);
            } else {
                break;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
        System.out.println(longestDiverseString(7, 1, 0));
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        // Create a frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Create a max-heap (PriorityQueue) based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        // Add all characters with their frequencies to the priority queue
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
        }

        // Build the answer string
        StringBuilder ans = new StringBuilder();
        Map.Entry<Character, Integer> hidden = null;

        while (!pq.isEmpty()) {
            if (ans.length() == 0) {
                hidden = pq.poll();
                ans.append(hidden.getKey());
                hidden.setValue(hidden.getValue() - 1);
            } else {
                Map.Entry<Character, Integer> top = pq.poll();
                ans.append(top.getKey());
                top.setValue(top.getValue() - 1);

                if (hidden != null && hidden.getValue() > 0) {
                    pq.offer(hidden);
                }

                hidden = top;
            }
        }

        // If the final string's length doesn't match the original string's length,
        // return ""
        if (ans.length() != s.length()) {
            return "";
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println(reorganizeString(s1));
        String s2 = "aaab";
        System.out.println(reorganizeString(s2));
    }
}

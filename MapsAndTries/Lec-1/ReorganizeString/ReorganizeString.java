import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // count freq of all character in String
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.putIfAbsent(ch, 0);
            freq.put(ch, freq.get(ch) + 1);
        }

        // push all characters in maxheap
        PriorityQueue<Info> maxHeap = new PriorityQueue<>(new Compare());
        // push all characters into heap, where freq > 0
        for (char i = 'a'; i <= 'z'; i++) {
            if (freq.containsKey(i) && freq.get(i) > 0) {
                char ch = i;
                Info temp = new Info(ch, freq.get(ch));
                maxHeap.add(temp);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (maxHeap.size() > 1) {
            Info first = maxHeap.poll();
            Info second = maxHeap.poll();

            ans.append(first.val);
            first.count--;
            ans.append(second.val);
            second.count--;

            if (first.count > 0) {
                maxHeap.add(first);
            }

            if (second.count > 0) {
                maxHeap.add(second);
            }
        }

        // if 1 element bacha h, toh alag se handle karo
        if (maxHeap.size() == 1) {
            Info first = maxHeap.poll();

            ans.append(first.val);
            first.count--;

            if (first.count != 0) {
                // answer not possible
                return "";
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}

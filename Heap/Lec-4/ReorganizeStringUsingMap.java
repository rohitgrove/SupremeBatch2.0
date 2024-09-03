import java.util.HashMap;
import java.util.PriorityQueue;

class Info {
    char val;
    int count;

    Info(char ch, int cnt) {
        this.val = ch;
        this.count = cnt;
    }
}

class Compare implements java.util.Comparator<Info> {
    @Override
    public int compare(Info a, Info b) {
        return b.count - a.count; // Max-Heap based on count
    }
}

public class ReorganizeStringUsingMap {
    public static String reorganizeString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequency of all characters in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Push all characters into the max heap
        PriorityQueue<Info> maxHeap = new PriorityQueue<>(new Compare());
        for (char ch : freq.keySet()) {
            if (freq.get(ch) > 0) {
                maxHeap.add(new Info(ch, freq.get(ch)));
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

        // Handle the last remaining character
        if (maxHeap.size() == 1) {
            Info last = maxHeap.poll();
            ans.append(last.val);
            last.count--;

            if (last.count > 0) {
                return ""; // Impossible to reorganize
            }
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
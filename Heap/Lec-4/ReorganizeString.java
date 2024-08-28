import java.util.PriorityQueue;
import java.util.Comparator;

class Info {
    public char val;
    public int count;

    public Info(char ch, int cnt) {
        this.val = ch;
        this.count = cnt;
    }
}

class Costum implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return o2.count - o1.count;
    }
}

public class ReorganizeString {
    public static String reorganizeString(String s) {
        int freq[] = new int[26];

        // count freq of all character in String
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        // push all characters in maxheap
        PriorityQueue<Info> maxHeap = new PriorityQueue<>(new Costum());
        // push all characters into heap, where freq > 0
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                char ch = (char) (i + 'a');
                Info temp = new Info(ch, freq[i]);
                maxHeap.add(temp);
            }
        }

        String ans = "";
        while (maxHeap.size() > 1) {
            Info first = maxHeap.poll();
            Info second = maxHeap.poll();

            ans += first.val;
            first.count--;
            ans += second.val;
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
            
            ans += first.val;
            first.count--;
            
            if (first.count != 0) {
                // answer not possible
                return "";
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println(reorganizeString(s1));
        String s2 = "aaab";
        System.out.println(reorganizeString(s2));
    }
}

import java.util.PriorityQueue;
import java.util.Comparator;

class Info {
    public char val;
    public int count;

    public Info(char val, int count) {
        this.val = val;
        this.count = count;
    }
}

class Compare implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return o2.count - o1.count;
    }
}

public class ReorganizeString {
    public static String reorganizeString(String str) {
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        PriorityQueue<Info> maxheap = new PriorityQueue<>(new Compare());
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                Info temp = new Info((char) (i + 'a'), freq[i]);
                maxheap.offer(temp);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (maxheap.size() > 1) {
            Info first = maxheap.poll();
            ans.append(first.val);
            first.count--;

            Info second = maxheap.poll();
            ans.append(second.val);
            second.count--;

            if (first.count > 0) {
                maxheap.offer(first);
            }

            if (second.count > 0) {
                maxheap.offer(second);
            }
        }

        if (maxheap.size() == 1) {
            Info first = maxheap.poll();
            ans.append(first.val);
            first.count--;

            if (first.count != 0) {
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
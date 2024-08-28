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

public class LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Info> maxHeap = new PriorityQueue<>(new Costum());
        if (a > 0) {
            Info temp = new Info('a', a);
            maxHeap.add(temp);
        }
        if (b > 0) {
            Info temp = new Info('b', b);
            maxHeap.add(temp);
        }
        if (c > 0) {
            Info temp = new Info('c', c);
            maxHeap.add(temp);
        }

        String ans = "";
        while (maxHeap.size() > 1) {
            Info first = maxHeap.poll();
            Info second = maxHeap.poll();

            if (first.count >= 2) {
                ans += first.val;
                ans += first.val;
                first.count -= 2;
            } else {
                ans += first.val;
                first.count--;
            }

            if (second.count >= 2 && second.count >= first.count) {
                ans += second.val;
                ans += second.val;
                second.count -= 2;
            } else {
                ans += second.val;
                second.count--;
            }

            if (first.count > 0) {
                maxHeap.add(first);
            }

            if (second.count > 0) {
                maxHeap.add(second);
            }
        }

        if (maxHeap.size() == 1) {
            Info first = maxHeap.poll();
            if (first.count >= 2) {
                ans += first.val;
                ans += first.val;
                first.count -= 2;
            } else {
                ans += first.val;
                first.count --;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
        System.out.println(longestDiverseString(7, 1, 0));
    }
}

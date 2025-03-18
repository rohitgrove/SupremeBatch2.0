import java.util.PriorityQueue;

public class LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        // make PQ.
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());

        if (a > 0) {
            pq.offer(new Info('a', a));
        }
        if (b > 0) {
            pq.offer(new Info('b', b));
        }
        if (c > 0) {
            pq.offer(new Info('c', c));
        }

        // build answer string
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Info top = pq.poll();

            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != top.val) {
                // add at most 2 freq. of maximum freq. char
                int times = Math.min(top.count, 2);
                for (int i = 0; i < times; ++i) {
                    ans.append(top.val);
                }
                top.count -= times;
                if (top.count > 0) {
                    pq.offer(top);
                }
            } else if (!pq.isEmpty()) {
                // add at most 1 freq. of maximum freq. char
                Info top2 = pq.poll();
                ans.append(top2.val);
                top2.count--;
                if (top2.count > 0) {
                    pq.offer(top2);
                }
                // return to the pq the max char we popped out in if clause:
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
        System.out.println(longestDiverseString(3, 4, 7));
    }
}
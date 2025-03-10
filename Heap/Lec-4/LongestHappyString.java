import java.util.PriorityQueue;

public class LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Info> maxHeap = new PriorityQueue<>(new Compare());

        if (a > 0) {
            maxHeap.offer(new Info('a', a));
        }

        if (b > 0) {
            maxHeap.offer(new Info('b', b));
        }

        if (c > 0) {
            maxHeap.offer(new Info('c', c));
        }

        StringBuilder ans = new StringBuilder();

        while (maxHeap.size() > 1) {
            Info first = maxHeap.poll();
            Info second = maxHeap.poll();

            if (first.count >= 2) {
                ans.append(first.val);
                ans.append(first.val);
                first.count -= 2;
            } else {
                ans.append(first.val);
                first.count--;
            }

            if (second.count >= 2 && second.count >= first.count) {
                ans.append(second.val);
                ans.append(second.val);
                second.count -= 2;
            } else {
                ans.append(second.val);
                second.count--;
            }

            if (first.count > 0) {
                maxHeap.offer(first);
            }

            if (second.count > 0) {
                maxHeap.offer(second);
            }
        }

        if (maxHeap.size() == 1) {
            Info first = maxHeap.poll();

            if (first.count >= 2) {
                ans.append(first.val);
                ans.append(first.val);
                first.count -= 2;
            } else {
                ans.append(first.val);
                first.count--;
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
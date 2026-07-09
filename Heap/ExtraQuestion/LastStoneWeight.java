import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                y = y - x;
                pq.offer(y);
            }
        }
    
        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        int stones[] = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }
}

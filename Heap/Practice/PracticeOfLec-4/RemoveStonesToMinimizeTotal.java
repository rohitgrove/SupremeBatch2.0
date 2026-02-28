import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < piles.length; i++) {
            maxHeap.offer(piles[i]);
        }

        while (k-- > 0) {
            int topElement = maxHeap.poll();

            topElement = topElement - (topElement / 2);

            maxHeap.offer(topElement);
        }

        int ans = 0;

        while (!maxHeap.isEmpty()) {
            int topElement = maxHeap.poll();
            ans += topElement;
        }

        return ans;
    }

    public static void main(String[] args) {
        int piles1[] = { 5, 4, 9 };
        System.out.println(minStoneSum(piles1, 2));
        int piles2[] = { 4, 3, 6, 7 };
        System.out.println(minStoneSum(piles2, 3));
    }
}
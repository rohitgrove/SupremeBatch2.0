import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < piles.length; i++) {
            int element = piles[i];
            maxHeap.offer(element);
        }

        while (k-- > 0) {
            int topElement = maxHeap.poll();

            topElement = (int) (topElement - Math.floor(topElement / 2));

            maxHeap.offer(topElement);
        }

        int sum = 0;
        while (!maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            sum += top;
        }

        return sum;
    }

    public static void main(String[] args) {
        int piles1[] = { 5, 4, 9 };
        System.out.println(minStoneSum(piles1, 2));
        int piles2[] = { 4, 3, 6, 7 };
        System.out.println(minStoneSum(piles2, 3));
    }
}
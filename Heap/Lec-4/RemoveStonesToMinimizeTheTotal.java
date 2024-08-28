import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < piles.length; i++) {
            int element = piles[i];
            maxHeap.add(element);
        }

        while (k-- > 0) {
            int topElement = maxHeap.poll();
            
            topElement = topElement - topElement / 2;
            maxHeap.add(topElement);
        }
        int sum = 0;

        while (!maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            sum += top;
        }

        return sum;
    }

    public static void main(String[] args) {
        int piles1[] = { 5, 4, 9 }, k1 = 2;
        System.out.println(minStoneSum(piles1, k1));
        int piles2[] = { 4, 3, 6, 7 }, k2 = 3;
        System.out.println(minStoneSum(piles2, k2));
    }
}
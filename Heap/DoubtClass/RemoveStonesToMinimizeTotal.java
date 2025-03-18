import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int val : piles) {
            maxHeap.offer(val);
        }

        while (k-- > 0) { 
            int top = maxHeap.poll();

            top -= top / 2;
            maxHeap.offer(top);
        }

        int sum = 0;

        while (!maxHeap.isEmpty()) { 
            sum += maxHeap.poll();
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
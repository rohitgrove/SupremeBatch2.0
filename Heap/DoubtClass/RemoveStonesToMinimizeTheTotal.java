import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

        public static int minStoneSum(int[] piles, int k) {
            // Create a max-heap (PriorityQueue with reverse order)
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
            // Add all elements from piles to the priority queue
            for (int val : piles) {
                pq.offer(val);
            }
    
            // Perform the operation k times
            while (k-- > 0) {
                int top = pq.poll();
                top -= top / 2; // Reduce the top element by half
                pq.offer(top);  // Add the modified value back to the priority queue
            }
    
            // Calculate the sum of all elements in the priority queue
            int sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
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
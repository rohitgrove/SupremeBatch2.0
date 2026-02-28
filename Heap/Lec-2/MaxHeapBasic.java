import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapBasic {
    public static void main(String[] args) {
        // create max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // insertion
        pq.offer(10);
        pq.offer(20);
        pq.offer(30);
        pq.offer(40);
        pq.offer(50);

        System.out.println("Top element of Heap: " + pq.peek());

        pq.poll();

        System.out.println("Top element of Heap: " + pq.peek());

        System.out.println("size of max heap: " + pq.size());
        if (pq.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }
    }
}
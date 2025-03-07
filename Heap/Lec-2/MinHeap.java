import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        // create max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // insertion
        pq.offer(100);
        pq.offer(90);
        pq.offer(70);

        System.out.println("Top elemet of heap: " + pq.peek());
        pq.poll();
        System.out.println("Top elemet of heap: " + pq.peek());
        System.out.println("Size: "+ pq.size());

        if (pq.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }
    }
}

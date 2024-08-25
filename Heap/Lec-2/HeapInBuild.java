import java.util.Collections;
import java.util.PriorityQueue;

public class HeapInBuild {
    public static void main(String[] args) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(50);

        System.out.println("Top element of max Heap: " + pq.peek());

        pq.poll();

        System.out.println("Top element of max Heap: "+ pq.peek());

        System.out.println("Size of max Heap: "+pq.size());
        if (pq.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }

        // min heap
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(100);
        pq1.add(90);
        pq1.add(70);

        System.out.println("Top element of min heap: "+pq1.peek());
        pq1.poll();
        System.out.println("Top element of min Heap: "+ pq1.peek());
        
        System.out.println("Size of max Heap: "+pq1.size());
        if (pq1.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }

    }
}

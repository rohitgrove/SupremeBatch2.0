import java.util.LinkedList;
import java.util.Queue;

public class BasicsOfQueue {
    public static void main(String[] args) {
        // creation
        Queue<Integer> q = new LinkedList<>();

        // insetion
        q.offer(5);

        // size
        System.out.println("Size of Queue: " + q.size());

        // empty
        if (q.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }

        // remove
        q.poll();

        // size
        System.out.println("Size of Queue: " + q.size());

        // empty
        if (q.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }

        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println("Front element of Queue is: " + q.peek());
    }
}
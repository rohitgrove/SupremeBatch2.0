import java.util.LinkedList;
import java.util.Queue;

public class QueueInBuild {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // insertion
        q.add(1);

        // size
        System.out.println("Size of queue: " + q.size());

        // empty
        if (q.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }

        // remove
        q.poll();

        // size
        System.out.println("Size of queue: " + q.size());

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Front element of Queue is: " + q.peek());
        Integer lastElement = ((LinkedList<Integer>) q).getLast();
        System.out.println("Last element of Queue is: " + lastElement);
    }
}
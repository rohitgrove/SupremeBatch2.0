import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueueUsingRec {
    public static void reverseQueue(Queue<Integer> q) {
        // base element
        if (q.isEmpty()) {
            return;
        }

        int element = q.poll();

        reverseQueue(q);

        q.offer(element);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        q.offer(60);
        System.out.println(q);

        reverseQueue(q);

        System.out.println(q);
    }
}

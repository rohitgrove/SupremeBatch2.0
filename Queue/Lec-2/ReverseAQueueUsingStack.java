import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueueUsingStack {
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        // one by one queue se element lo and element lo and stack me daalo
        while (!q.isEmpty()) {
            s.push(q.poll());
        }

        // one by one stack se element lo and element lo and queue me daalo
        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
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
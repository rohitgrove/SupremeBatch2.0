import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseAQueue {
    public static void reverseQueueUsingItr(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        // one by one queue se element lo and stack me dallo
        while (!q.isEmpty()) {
            int frontElement = q.poll();
            st.push(frontElement);
        }

        // one by one stack se element lo and queue me dallo
        while (!st.isEmpty()) {
            int topElement = st.pop();
            q.add(topElement);
        }
    }

    public static void reverseQueueUsingRec(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }

        int temp = q.poll();
        reverseQueueUsingRec(q);
        q.add(temp);
    }

    public static void reverse(Queue<Integer> q) {
        reverseQueueUsingRec(q);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}

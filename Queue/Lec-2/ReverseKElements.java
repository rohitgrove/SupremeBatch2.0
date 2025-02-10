import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void reverseFirstK(Queue<Integer> q, int k) {
        int n = q.size();
        if (k > n || k == 0) {
            return;
        }
        Stack<Integer> st = new Stack<>();
        // push first k element into stack
        for (int i = 0; i < k; i++) {
            int temp = q.poll();
            st.push(temp);
        }

        // push all k element into queue
        while (!st.isEmpty()) {
            int temp = st.pop();
            q.offer(temp);
        }

        // pop and push first (n - k) elements into queue
        for (int i = 0; i < (n - k); i++) {
            int temp = q.poll();
            q.offer(temp);
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

        reverseFirstK(q, 4);

        System.out.println(q);
    }
}

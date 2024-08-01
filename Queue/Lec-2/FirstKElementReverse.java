import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstKElementReverse {
    public static void reverseFirstK(Queue<Integer> q, int k) { //tc: O(n)
        Stack<Integer> st = new Stack<>();
        int n = q.size();
        // push first k element into stack
        if (k > n || k == 0) {
            return;
        }

        for (int i = 0; i < k; i++) {
            st.push(q.poll());
        }
        // push all j element into queue
        while (!st.isEmpty()) {
            int temp = st.pop();
            q.add(temp);
        }
        // poll ans push first (n-k) elements into queue again

        for (int i = 0; i < (n - k); i++) {
            int temp = q.poll();
            q.add(temp);
        }
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
        reverseFirstK(q, 2);
        System.out.println(q);
    }
}

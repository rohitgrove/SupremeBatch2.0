import java.util.Deque;
import java.util.ArrayDeque;

public class DequeInBuild {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(10);
        dq.addFirst(20);
        // dq.pollLast();
        dq.pollFirst();

        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());

        System.out.println(dq.size());
    }    
}

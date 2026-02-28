import java.util.Deque;
import java.util.LinkedList;
public class BasicsOfDeque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(10);
        dq.offerFirst(20);
        // dq.pollLast();
        dq.pollFirst();

        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        System.out.println(dq.size());
    }
}

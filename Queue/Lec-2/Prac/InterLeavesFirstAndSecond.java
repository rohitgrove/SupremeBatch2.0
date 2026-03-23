import java.util.LinkedList;
import java.util.Queue;

public class InterLeavesFirstAndSecond {
    public static void interleaveFirstAndSecond(Queue<Integer> first) {
        Queue<Integer> second = new LinkedList<>();
        int size = first.size();

        for (int i = 0; i < size / 2; i++) {
            second.offer(first.poll());
        }

        System.out.println(first);
        System.out.println(second);

        for (int i = 0; i < size / 2; i++) {
            int temp = second.poll();
            first.offer(temp);

            temp = first.poll();
            first.offer(temp);
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

        interleaveFirstAndSecond(q);

        System.out.println(q);
    }
}

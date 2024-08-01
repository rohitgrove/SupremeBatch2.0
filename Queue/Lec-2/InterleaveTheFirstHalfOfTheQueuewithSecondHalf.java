import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTheFirstHalfOfTheQueuewithSecondHalf {
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> first) {
        Queue<Integer> second = new LinkedList<>();
        int n = first.size();

        // Push first half into second queue
        for (int i = 0; i < n / 2; i++) {
            int temp = first.poll();
            second.add(temp);
        }

        // Merge back into original queue
        while (!second.isEmpty()) {
            int temp = second.poll();
            first.add(temp);
            temp = first.poll();
            first.add(temp);
        }
        return new ArrayList<>(first);
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(1);
        System.out.println(q1);
        System.out.println(rearrangeQueue(q1.size(), q1));
        Queue<Integer> q2 = new LinkedList<>();
        q2.add(10);
        q2.add(20);
        q2.add(30);
        q2.add(40);
        q2.add(50);
        q2.add(60);
        System.out.println(q2);
        System.out.println(rearrangeQueue(q2.size(), q2));
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfCircularGame {
    public static int findTheWinner(int n, int k) {
        // All player should go into a queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            // simulate the game
            for (int i = 1; i < k; i++) {
                int player = q.peek();
                q.poll();

                // it is not elemented
                q.offer(player);
            }

            // kth player must be elemented.
            q.poll();
        }

        return q.peek();
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfCircular {
    public static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            // simulate the game
            for (int i = 1; i < k; i++) {
                int player = q.peek();
                q.poll();

                // it is not eleminated yet/
                q.add(player);
            }

            // kth player must be eleminated
            q.poll();
        }

        return q.peek();
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }
}

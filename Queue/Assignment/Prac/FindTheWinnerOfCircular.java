import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfCircular {
    public static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            for (int i = 1; i < k; i++) {
                int frontElement = q.peek();
                q.poll();

                q.add(frontElement);
            }
            q.poll();
        }

        return q.peek();
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }
}

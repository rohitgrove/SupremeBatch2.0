import java.util.Queue;
import java.util.LinkedList;

class Pair<T, U> {
    public T first;
    public U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfPepoleAwareOfSecret {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int M = (int) (1e9 + 7);
        int curr = 0; // active spreader
        int ans = 1; // persons who know about secret

        // uss din, kitne new logo ko secret pata laga
        Queue<Pair<Integer, Integer>> delayQ = new LinkedList<>();
        Queue<Pair<Integer, Integer>> forgetQ = new LinkedList<>();
        delayQ.add(new Pair<>(1, 1));
        forgetQ.add(new Pair<>(1, 1));
        for (int i = 1; i <= n; i++) {
            // step 1: active spreader and person know about secret kam karo
            if (!forgetQ.isEmpty() && forgetQ.peek().first + forget <= i) {
                int no = forgetQ.poll().second;
                ans = (ans - no + M) % M;
                curr = (curr - no + M) % M;
            }

            // step 2: make new active spreaders
            if (!delayQ.isEmpty() && delayQ.peek().first + delay <= i) {
                curr = (curr + delayQ.poll().second) % M; // active kar diya
            }

            // step 3: spread the secret

            if (curr > 0) {
                ans = (ans + curr) % M;
                delayQ.add(new Pair(i, curr));
                forgetQ.add(new Pair(i, curr));
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int n1 = 6, delay1 = 2, forget1 = 4;
        System.out.println(peopleAwareOfSecret(n1, delay1, forget1));
        int n2 = 4, delay2 = 1, forget2 = 3;
        System.out.println(peopleAwareOfSecret(n2, delay2, forget2));
    }
}
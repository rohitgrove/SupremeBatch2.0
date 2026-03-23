import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int days;
    public int person;

    public Pair(int days, int person) {
        this.days = days;
        this.person = person;
    }
}

public class NumberOfPeopleAwareOfASecret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int M = (int) (1e9 + 7);
        int curr = 0; // active spreader
        int ans = 1; // persons who know about secret

        // uss din, kitne new logo ko secret pata laga
        Queue<Pair> delayQ = new LinkedList<>();
        Queue<Pair> forgetQ = new LinkedList<>();
        delayQ.add(new Pair(1, 1));
        forgetQ.add(new Pair(1, 1));
        for (int i = 1; i <= n; i++) {
            // step 1: active spreader and person know about secret kam karo
            if (!forgetQ.isEmpty() && forgetQ.peek().days + forget <= i) {
                int no = forgetQ.poll().person;
                ans = (ans - no + M) % M;
                curr = (curr - no + M) % M;
            }

            // step 2: make new active spreaders
            if (!delayQ.isEmpty() && delayQ.peek().days + delay <= i) {
                curr = (curr + delayQ.poll().person) % M; // active kar diya
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
        System.out.println(peopleAwareOfSecret(6, 2, 4));
        System.out.println(peopleAwareOfSecret(4, 1, 3));
        System.out.println(peopleAwareOfSecret(7, 2, 4));
    }
}

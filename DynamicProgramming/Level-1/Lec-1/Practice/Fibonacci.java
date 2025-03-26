import java.util.Arrays;

public class Fibonacci {
    public static int solveUsingRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans = solveUsingRec(n - 1) + solveUsingRec(n - 2);
        return ans;
    }

    public static int solveUsingMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solveUsingMemo(n - 1, dp) + solveUsingMemo(n - 2, dp);
        return dp[n];
    }

    public static int solveUsingTabulation(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int solveUsingSO(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int prev = 0;
        int curr = 1;
        int next = 0;

        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }

        return next;
    }

    public static int fib(int n) {
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, dp);

        return solveUsingSO(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(6));
    }
}
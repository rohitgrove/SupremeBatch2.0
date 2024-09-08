import java.util.Arrays;

public class Fibbonaci {
    public static int solveRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans = solveRec(n - 1) + solveRec(n - 2);
        return ans;
    }

    public static int solveMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solveMemo(n - 1, dp) + solveMemo(n - 2, dp);
        return dp[n];
    }

    public static int solveTab(int n) {
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

    public static int solveSpaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int prev = 0;
        int curr = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = curr + prev;
            prev = curr;
            curr = ans;
        }

        return ans;
    }

    public static int fib(int n) {
        // return solveRec(n);
        
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int ans = solveMemo(n, dp);
        // return ans;

        // int ans = solveTab(n);
        // return ans;

        int ans = solveSpaceOptimization(n);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
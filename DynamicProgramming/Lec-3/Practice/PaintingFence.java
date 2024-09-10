import java.util.Arrays;

public class PaintingFence {
    public static int solveUsingRecursion(int n, int k) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        int same = solveUsingRecursion(n - 2, k) * (k - 1);
        int diff = solveUsingRecursion(n - 1, k) * (k - 1);
        return same + diff;
    }

    public static int solveUsingMem(int n, int k, int dp[]) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int same = solveUsingMem(n - 2, k, dp) * (k - 1);
        int diff = solveUsingMem(n - 1, k, dp) * (k - 1);
        dp[n] = same + diff;
        return dp[n];
    }

    public static int solveUsingTabulation(int n, int k) {
        int dp[] = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {
            int same = dp[i - 2] * (k - 1);
            int diff = dp[i - 1] * (k - 1);
            dp[i] = same + diff;
        }

        return dp[n];
    }

    public static int solveUsingTabulationSO(int n, int k) {
        int prev1 = k;
        int prev2 = k * k;

        int curr;
        for (int i = 3; i <= n; i++) {
            int same = prev1 * (k - 1);
            int diff = prev2 * (k - 1);
            curr = same + diff;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }

    public static int countWays(int n, int k) {
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        return solveUsingTabulationSO(n, k);
    }

    public static void main(String[] args) {
        System.out.println(countWays(3, 3)); // 24
        System.out.println(countWays(3, 2)); // 6
        System.out.println(countWays(2, 4)); // 16
    }
}
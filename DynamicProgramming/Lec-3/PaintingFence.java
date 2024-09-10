// import java.util.Arrays;

public class PaintingFence {
    public static int solveUsingRec(int n, int k) {
        // base case
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }

        int same = solveUsingRec(n - 2, k) * (k - 1);
        int diff = solveUsingRec(n - 1, k) * (k - 1);
        int ans = same + diff;
        return ans;
    }

    public static int solveUsingMemo(int n, int k, int dp[]) {
        // base case
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int same = solveUsingMemo(n - 2, k, dp) * (k - 1);
        int diff = solveUsingMemo(n - 1, k, dp) * (k - 1);
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
        int prev2 = k;
        int prev1 = k * k;

        int curr;
        for (int i = 3; i <= n; i++) {
            int same = prev2 * (k - 1);
            int diff = prev1 * (k - 1);
            curr = same + diff;
            // shifting
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
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
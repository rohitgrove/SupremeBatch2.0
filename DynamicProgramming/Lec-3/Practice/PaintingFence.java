import java.util.Arrays;

public class PaintingFence {
    public static int solveUsingRec(int n, int k) {
        if (n == 1) {
            return k;
        }

        if(n == 2) {
            return k * k;
        }

        int ans = (solveUsingRec(n - 1, k) + solveUsingRec(n - 2, k)) * (k - 1);
        return ans;
    }

    public static int solveUsingMemo(int n, int k, int dp[]) {
        if (n == 1) {
            return k;
        }

        if(n == 2) {
            return k * k;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = (solveUsingMemo(n - 1, k, dp) + solveUsingMemo(n - 2, k, dp)) * (k - 1);
        return dp[n];
    }

    public static int solveUsingTabulation(int n, int k) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        int dp[] = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }

        return dp[n];
    }

    public static int solveUsingTabulationSO(int n, int k) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        int prev2 = k;
        int prev1 = k * k;
        int curr;

        for (int i = 3; i <= n; i++) {
            curr = (prev1 + prev2) * (k - 1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static int countWays(int n, int k) {
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, k, dp);
        return solveUsingTabulationSO(n, k);
    }

    public static void main(String[] args) {
        System.out.println(countWays(2, 4)); // 16
        System.out.println(countWays(3, 2)); // 6
        System.out.println(countWays(4, 3)); // 66
        System.out.println(countWays(3, 3)); // 24
    }
}

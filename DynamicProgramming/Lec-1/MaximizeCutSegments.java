import java.util.Arrays;

public class MaximizeCutSegments {
    public static int solveUsingRec(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int option1 = 1 + solveUsingRec(n - x, x, y, z);
        int option2 = 1 + solveUsingRec(n - y, x, y, z);
        int option3 = 1 + solveUsingRec(n - z, x, y, z);
        return Math.max(option1, Math.max(option2, option3));
    }

    public static int solveUsingMemo(int n, int x, int y, int z, int dp[]) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[n] != Integer.MIN_VALUE) {
            return dp[n];
        }

        int option1 = 1 + solveUsingMemo(n - x, x, y, z, dp);
        int option2 = 1 + solveUsingMemo(n - y, x, y, z, dp);
        int option3 = 1 + solveUsingMemo(n - z, x, y, z, dp);
        dp[n] = Math.max(option1, Math.max(option2, option3));
        return dp[n];
    }

    public static int maximizeCuts(int n, int x, int y, int z) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int ans = solveUsingMemo(n, x, y, z, dp);
        return ans < 0 ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(maximizeCuts(4, 2, 1, 1));
        System.out.println(maximizeCuts(5, 5, 3, 2));
    }
}

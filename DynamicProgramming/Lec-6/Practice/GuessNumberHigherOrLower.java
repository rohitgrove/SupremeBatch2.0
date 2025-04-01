import java.util.Arrays;

public class GuessNumberHigherOrLower {
    public static int solveUsingRec(int start, int end) {
        if (start >= end) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solveUsingRec(start, i - 1), solveUsingRec(i + 1, end)));
        }

        return ans;
    }

    public static int solveUsingMemo(int start, int end, int dp[][]) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solveUsingMemo(start, i - 1, dp), solveUsingMemo(i + 1, end, dp)));
        }

        dp[start][end] = ans;
        return ans;
    }

    public static int solveUsingTabulation(int n) {
        int dp[][] = new int[n + 2][n + 1];

        for (int start_index = n; start_index >= 1; start_index--) {
            for (int end_index = 1; end_index <= n; end_index++) {
                if (start_index >= end_index) {
                    continue;
                }
                int ans = Integer.MAX_VALUE;

                for (int i = start_index; i <= end_index; i++) {
                    ans = Math.min(ans, i + Math.max(dp[start_index][i - 1], dp[i + 1][end_index]));
                }

                dp[start_index][end_index] = ans;
            }
        }

        return dp[1][n];
    }

    public static int getMoneyAmount(int n) {
        // int start = 1;
        // int end = n;
        // int ans = solveUsingRec(start, end);
        // int dp[][] = new int[n + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(start, end, dp);

        int ans = solveUsingTabulation(n);
        return ans;
    }

    public static void main(String[] args) {
        System.err.println(getMoneyAmount(10));
    }
}
import java.util.Arrays;

public class GuesNumberHigherOrLower {
    public static int solveUsingRecursion(int start, int end) {
        // base case
        if (start >= end) {
            // range se bhar ya sirf ek hi number hai
            // zero penalty
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solveUsingRecursion(start, i - 1), solveUsingRecursion(i + 1, end)));
        }
        return ans;
    }

    public static int solveUsingMemo(int start, int end, int dp[][]) {
        if (start >= end) {
            // range se bhar ya sirf ek hi number hai
            // zero penalty
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
        return dp[start][end];
    }

    public static int solveUsingTabulation(int n) {
        int dp[][] = new int[n + 2][n + 1];

        for (int start_index = n - 1; start_index >= 1; start_index--) {
            for (int end_index = 1; end_index <= n; end_index++) {
                if (start_index >= end_index) {
                    // invalid range
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
        int start = 1;
        int end = n;
        // int dp[][] = new int[n + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        int ans = solveUsingTabulation(n);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
        System.out.println(getMoneyAmount(1));
        System.out.println(getMoneyAmount(2));
    }
}
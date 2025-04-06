import java.util.Arrays;

public class PerfectSquare {
    public static int solveUsingRecursion(int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int i = 1;
        int end = (int) Math.sqrt(n);
        while (i <= end) {
            int perfectSquare = i * i;
            int numberOfPerfectSquares = 1 + solveUsingRecursion(n - perfectSquare);
            if (numberOfPerfectSquares < ans) {
                ans = numberOfPerfectSquares;
            }
            i++;
        }
        return ans;
    }

    public static int solveUsingMemo(int n, int dp[]) {
        // base case
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;
        int i = 1;
        int end = (int) Math.sqrt(n);
        while (i <= end) {
            int perfectSquare = i * i;
            int numberOfPerfectSquares = 1 + solveUsingMemo(n - perfectSquare, dp);
            if (numberOfPerfectSquares < ans) {
                ans = numberOfPerfectSquares;
            }
            i++;
        }
        dp[n] = ans;
        return dp[n];
    }

    public static int solveUsingTabulation(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            int ans = Integer.MAX_VALUE;
            int start = 1;
            int end = (int) Math.sqrt(i);

            while (start <= end) {
                int perfectSquare = start * start;
                int numberOfPerfectSquares = 1 + dp[i - perfectSquare];

                if (numberOfPerfectSquares < ans) {
                    ans = numberOfPerfectSquares;
                }
                ++start;
            }

            dp[i] = ans;
        }

        return dp[n];
    }

    public static int numSquares(int n) {
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, dp) - 1;
        return solveUsingTabulation(n) - 1;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
import java.util.Arrays;

public class PerfectSquare {
    public static int solveUsingRec(int n) {
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
            int squareOfaNumber = 1 + solveUsingRec(n - perfectSquare);
            if (squareOfaNumber < ans) {
                ans = squareOfaNumber;
            }
            i++;
        }
        return ans;
    }

    public static int solveUsingMemo(int n, int dp[]) {
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
            int squareOfaNumber = 1 + solveUsingMemo(n - perfectSquare, dp);
            if (squareOfaNumber < ans) {
                ans = squareOfaNumber;
            }
            i++;
        }
        dp[n] = ans;
        return dp[n];
    }

    public static int solveUsingTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int sq = 1; sq <= n; sq++) {
            int ans = Integer.MAX_VALUE;
            int i = 1;
            int end = (int) Math.sqrt(sq);
            while (i <= end) {
                int perfectSquare = i * i;
                int squareOfaNumber = 1 + dp[sq - perfectSquare];
                if (squareOfaNumber < ans) {
                    ans = squareOfaNumber;
                }
                i++;
            }
            dp[sq] = ans;
        }
        return dp[n];
    }

    public static int numSquare(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveUsingTabulation(n) - 1;
    }

    public static void main(String[] args) {
        System.out.println(numSquare(12));
        System.out.println(numSquare(13));
    }
}
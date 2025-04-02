import java.util.Arrays;

public class MaximizeTheCutSegments {
    public static int solveUsingRec(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        // maine x len ka 1 segment cut krlia and baaki recursion dekhlega
        int option1 = 1 + solveUsingRec(n - x, x, y, z);
        // maine y len ka 1 segment cut krlia and baaki recursion dekhlega
        int option2 = 1 + solveUsingRec(n - y, x, y, z);
        // maine z len ka 1 segment cut krlia and baaki recursion dekhlega
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

        int result = solveUsingMemo(n, x, y, z, dp);

        return result < 0 ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(maximizeCuts(4, 2, 1, 1));
        System.out.println(maximizeCuts(5, 5, 3, 2));
        System.out.println(maximizeCuts(7, 8, 9, 10));
    }
}

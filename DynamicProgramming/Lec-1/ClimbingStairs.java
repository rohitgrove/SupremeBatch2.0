import java.util.Arrays;

public class ClimbingStairs {
    public static int solveUsingRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int step1 = solveUsingRec(n - 1);
        int step2 = solveUsingRec(n - 2);
        return step1 + step2;
    }

    public static int solveUsingMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int step1 = solveUsingMemo(n - 1, dp);
        int step2 = solveUsingMemo(n - 2, dp);
        dp[n] = step1 + step2;
        return dp[n];
    }

    public static int solveUsingTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index <= n; index++) {
            int step1 = dp[index - 1];
            int step2 = dp[index - 2];
            dp[index] = step1 + step2;
        }

        return dp[n];
    }

    public static int solveUsingTabulationSpaceOptimization(int n) {
        int prev = 1;
        int curr = 1;

        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev + curr;
            prev = curr;
            curr = ans;
        }

        return ans;
    }

    public static int climbStairs(int n) {
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, dp);
        return solveUsingTabulationSpaceOptimization(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}

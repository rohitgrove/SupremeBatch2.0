import java.util.Arrays;

public class Fibbonacci {
    public static int solveUsingRec(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        // rec relation
        int ans = solveUsingRec(n - 1) + solveUsingRec(n - 2);
        return ans;
    }

    // top down approach
    // rec + memoisation appraoch
    public static int solveUsingMem(int n, int[] dp) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        // step3: if ans already exist using dp array
        if (dp[n] != -1) {
            return dp[n];
        }

        // rec relation
        // step2: store and return using dp array
        dp[n] = solveUsingMem(n - 1, dp) + solveUsingMem(n - 2, dp);
        return dp[n];
    }

    public static int solveUsingTabulation(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // Step1: create dp array
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        // step2: analyse base case and fill dp array
        dp[0] = 0;
        dp[1] = 1;

        // fill the reamaining dp array
        // size = n + 1
        // index -> 0 => n
        // index fill ho chuka hai -> 0 and 1
        // bacha konsa index = 2 -> n;
        for (int index = 2; index < dp.length; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        return dp[n];
    }

    public static int solveUsingSpaceOptimized(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prev = 0;
        int curr = 1;

        int ans = 0;
        for (int index = 2; index <= n; index++) {
            ans = curr + prev;
            prev = curr;
            curr = ans;
        }

        return ans;
    }

    public static int fib(int n) {
        // return solveUsingRec(n);
        // create sp array
        // memo
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int ans = solveUsingMem(n, dp);
        // int ans = solveUsingTabulation(n);
        int ans = solveUsingSpaceOptimized(n);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
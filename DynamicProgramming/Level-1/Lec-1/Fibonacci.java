import java.util.Arrays;

public class Fibonacci {
    public static int solveUsingRec(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        // rec relation
        int ans = solveUsingRec(n - 1) + solveUsingRec(n - 2);
        return ans;
    }

    // top-down approach
    // rec + memoization approach
    public static int solveUsingMemo(int n, int dp[]) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // step 3: if ans already exist them return ans
        if (dp[n] != -1) {
            return dp[n];
        }

        // rec relation
        // step 2: store and return using dp
        dp[n] = solveUsingMemo(n - 1, dp) + solveUsingMemo(n - 2, dp);
        return dp[n];
    }

    public static int solveUsingTabulation(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // step1: create dp array
        int dp[] = new int[n + 1];

        // step2: analyze base case and fill dp array
        dp[0] = 0;
        dp[1] = 1;

        // step3: fill the remaining dp array
        // array size = n+1
        // index move from 0 to n
        // 0 and 1 index ko already fill krlia h
        // 2 index se n index tak abhi filled nahi h
        for (int index = 2; index <= n; index++) {
            // copy paste karo recursive logic ko
            // repalce recursive calls with dp array
            // make sure dp array is using looping variable
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        // return ans;
        return dp[n];
    }

    public static int solveUsingTabulationSpaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int prev = 0;
        int curr = 1;

        int ans = 0;

        for (int i = 2; i <= n; i++) {
            ans = curr + prev;
            // prev and curr ko ek step aage move karna
            prev = curr;
            curr = ans;
        }

        return ans;
    }

    public static int fib(int n) {
        // return solveUsingRec(n);

        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(n, dp);

        return solveUsingTabulationSpaceOptimization(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(6));
    }
}
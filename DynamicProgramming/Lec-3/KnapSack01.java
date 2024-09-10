import java.util.Arrays;

public class KnapSack01 {
    public static int solveUsingRecursion(int capacity, int wt[], int profit[], int index, int n) {
        if (index == n - 1) {
            if (wt[index] <= capacity) {
                return profit[index];
            } else {
                return 0;
            }
        }

        // inc / exc
        int include = 0;
        if (wt[index] <= capacity) {
            include = profit[index] + solveUsingRecursion(capacity - wt[index], wt, profit, index + 1, n);
        }

        int exclude = 0 + solveUsingRecursion(capacity, wt, profit, index + 1, n);

        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMem(int capacity, int wt[], int profit[], int index, int n, int dp[][]) {
        // base case
        if (index == n - 1) {
            if (wt[index] <= capacity) {
                return profit[index];
            } else {
                return 0;
            }
        }

        if (dp[capacity][index] != -1) {
            return dp[capacity][index];
        }

        // inc / exc
        int include = 0;
        if (wt[index] <= capacity) {
            include = profit[index] + solveUsingMem(capacity - wt[index], wt, profit, index + 1, n, dp);
        }

        int exclude = 0 + solveUsingMem(capacity, wt, profit, index + 1, n, dp);

        dp[capacity][index] = Math.max(include, exclude);
        return dp[capacity][index];
    }

    public static int solveUsingTabulation(int capacity, int wt[], int profit[], int n) {
        int dp[][] = new int[capacity + 1][n + 1];

        for (int c = 0; c <= capacity; c++) {
            for (int index = n - 1; index >= 0; index--) {
                int include = 0;
                if (wt[index] <= c) {
                    include = profit[index] + dp[c - wt[index]][index + 1];
                }
                int exclude = 0 + dp[c][index + 1];
                dp[c][index] = Math.max(include, exclude);
            }
        }

        return dp[capacity][0];
    }

    public static int solveUsingTabulationSO(int capacity, int wt[], int profit[], int n) {
        int[] next = new int[capacity + 1];
        int[] curr = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int c = 0; c <= capacity; c++) {
                int include = 0;
                if (wt[index] <= c) {
                    include = profit[index] + next[c - wt[index]];
                }
                int exclude = 0 + next[c];
                curr[c] = Math.max(include, exclude);
            }
            // shifting
            next = curr.clone();
        }

        return curr[capacity];
    }

    public static int solveUsingTabulationSO2(int capacity, int wt[], int profit[], int n) {
        int[] next = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int c = capacity; c >= 0; c--) {
                int include = 0;
                if (wt[index] <= c) {
                    include = profit[index] + next[c - wt[index]];
                }
                int exclude = 0 + next[c];
                next[c] = Math.max(include, exclude);
            }
        }

        return next[capacity];
    }

    public static int knapSack(int capacity, int wt[], int profit[]) {
        // int dp[][] = new int[capacity + 1][wt.length + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        int ans = solveUsingTabulationSO2(capacity, wt, profit, profit.length);
        return ans;
    }

    public static void main(String[] args) {
        int W1 = 4, val1[] = { 1, 2, 3 }, wt1[] = { 4, 5, 1 };
        System.out.println(knapSack(W1, wt1, val1));
        int W2 = 3, val2[] = { 1, 2, 3 }, wt2[] = { 4, 5, 6 };
        System.out.println(knapSack(W2, wt2, val2));
        int W3 = 50, val3[] = { 60, 100, 120 }, wt3[] = { 10, 20, 30 };
        System.out.println(knapSack(W3, wt3, val3));
    }
}
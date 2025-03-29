import java.util.Arrays;

public class KnapSack01 {
    public static int solveUsingRec(int capacity, int profit[], int wt[], int index, int n) {
        // base case
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
            include = profit[index] + solveUsingRec(capacity - wt[index], profit, wt, index + 1, n);
        }
        int exclude = 0 + solveUsingRec(capacity, profit, wt, index + 1, n);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int capacity, int profit[], int wt[], int index, int n, int dp[][]) {
        // base case
        if (index == n - 1) {
            if (wt[index] <= capacity) {
                return profit[index];
            } else {
                return 0;
            }
        }

        // already exists
        if (dp[capacity][index] != -1) {
            return dp[capacity][index];
        }

        // inc / exc
        int include = 0;
        if (wt[index] <= capacity) {
            include = profit[index] + solveUsingMemo(capacity - wt[index], profit, wt, index + 1, n, dp);
        }
        int exclude = 0 + solveUsingMemo(capacity, profit, wt, index + 1, n, dp);
        dp[capacity][index] = Math.max(include, exclude);
        return dp[capacity][index];
    }

    public static int solveUsingTabulation(int capacity, int profit[], int wt[]) {
        int n = wt.length;
        int dp[][] = new int[capacity + 1][n + 1];

        for (int cap = 0; cap <= capacity; cap++) {
            for (int index = n - 1; index >= 0; index--) {
                // inc / exc
                int include = 0;
                if (wt[index] <= cap) {
                    include = profit[index] + dp[cap - wt[index]][index + 1];
                }
                int exclude = 0 + dp[cap][index + 1];
                dp[cap][index] = Math.max(include, exclude);
            }
        }

        return dp[capacity][0];
    }

    public static int solveUsingTabulationSO1(int capacity, int profit[], int wt[]) {
        int n = wt.length;
        int next[] = new int[capacity + 1];
        int curr[] = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int cap = 0; cap <= capacity; cap++) {
                // inc / exc
                int include = 0;
                if (wt[index] <= cap) {
                    include = profit[index] + next[cap - wt[index]];
                }
                int exclude = 0 + next[cap];
                curr[cap] = Math.max(include, exclude);
            }
            // shifting
            next = curr.clone();
        }

        return curr[capacity];
    }

    public static int solveUsingTabulationSO2(int capacity, int profit[], int wt[]) {
        int n = wt.length;
        int next[] = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int cap = capacity; cap >= 0; cap--) {
                // inc / exc
                int include = 0;
                if (wt[index] <= cap) {
                    include = profit[index] + next[cap - wt[index]];
                }
                int exclude = 0 + next[cap];
                next[cap] = Math.max(include, exclude);
            }
        }

        return next[capacity];
    }

    public static int knapsack(int capacity, int profit[], int wt[]) {
        // int index = 0;
        // int n = wt.length;
        // return solveUsingRec(capacity, profit, wt, index, n);
        // int dp[][] = new int[capacity + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(capacity, profit, wt, index, n, dp);
        return solveUsingTabulationSO2(capacity, profit, wt);
    }

    public static void main(String[] args) {
        int capacity1 = 50, weight1[] = { 10, 20, 30 }, profit1[] = { 60, 100, 120 }; // 220
        System.out.println(knapsack(capacity1, profit1, weight1));
        int capacity2 = 5, weight2[] = { 5, 4, 2, 3 }, profit2[] = { 10, 40, 30, 50 }; // 80
        System.out.println(knapsack(capacity2, profit2, weight2));
        int capacity3 = 6, weight3[] = { 1, 2, 3 }, profit3[] = { 10, 15, 40 }; // 65
        System.out.println(knapsack(capacity3, profit3, weight3));
    }
}

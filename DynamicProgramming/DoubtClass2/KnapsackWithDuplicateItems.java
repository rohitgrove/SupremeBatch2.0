
public class KnapsackWithDuplicateItems {
    public static int solveUsingRec(int capacity, int profit[], int wt[], int index, int n) {
        // base case
        if (index == n - 1) {
            return (capacity / wt[n - 1]) * profit[n - 1];
        }

        // inc / exc
        int include = 0;
        if (wt[index] <= capacity) {
            include = profit[index] + solveUsingRec(capacity - wt[index], profit, wt, index, n);
        }
        int exclude = 0 + solveUsingRec(capacity, profit, wt, index + 1, n);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int capacity, int profit[], int wt[], int index, int n, int dp[][]) {
        // base case
        if (index == n - 1) {
            return (capacity / wt[n - 1]) * profit[n - 1];
        }

        // already exists
        if (dp[capacity][index] != -1) {
            return dp[capacity][index];
        }

        // inc / exc
        int include = 0;
        if (wt[index] <= capacity) {
            include = profit[index] + solveUsingMemo(capacity - wt[index], profit, wt, index, n, dp);
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
                    include = profit[index] + dp[cap - wt[index]][index];
                }
                int exclude = 0 + dp[cap][index + 1];
                dp[cap][index] = Math.max(include, exclude);
            }
        }

        return dp[capacity][0];
    }

    public static int solveUsingTabulationSO(int capacity, int profit[], int wt[]) {
        int n = wt.length;
        int next[] = new int[capacity + 1];
        int curr[] = new int[capacity + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int cap = 0; cap <= capacity; cap++) {
                // inc / exc
                int include = 0;
                if (wt[index] <= cap) {
                    include = profit[index] + curr[cap - wt[index]];
                }
                int exclude = 0 + next[cap];
                curr[cap] = Math.max(include, exclude);
            }
            // shifting
            next = curr.clone();
        }

        return curr[capacity];
    }

    public static int knapSack(int profit[], int wt[], int capacity) {
        // int index = 0;
        // int n = wt.length;
        // return solveUsingRec(capacity, profit, wt, index, n);
        // int dp[][] = new int[capacity + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(capacity, profit, wt, index, n, dp);
        return solveUsingTabulationSO(capacity, profit, wt);
    }

    public static void main(String[] args) {
        int val1[] = { 1, 1 }, wt1[] = { 2, 1 }, capacity1 = 3;
        System.out.println(knapSack(val1, wt1, capacity1));
        int val2[] = { 6, 1, 7, 7 }, wt2[] = { 1, 3, 4, 5 }, capacity2 = 8;
        System.out.println(knapSack(val2, wt2, capacity2));
        int val3[] = { 6, 8, 7, 100 }, wt3[] = { 2, 3, 4, 5 }, capacity3 = 1;
        System.out.println(knapSack(val3, wt3, capacity3));
    }
}
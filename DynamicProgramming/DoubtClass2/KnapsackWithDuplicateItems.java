import java.util.Arrays;

public class KnapsackWithDuplicateItems {
    public static int solveUsingRec(int idx, int W, int val[], int wt[]) {
        if (idx == 0) {
            // Dukan par gye, Last item to pick
            return ((W / wt[0]) * val[0]);
        }

        int include = 0;
        if (wt[idx] <= W) {
            include = val[idx] + solveUsingRec(idx, W - wt[idx], val, wt);
        }
        int exclude = solveUsingRec(idx - 1, W, val, wt);
        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int idx, int W, int val[], int wt[], int dp[][]) {
        if (idx == 0) {
            return ((W / wt[0]) * val[0]);
        }

        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }

        int include = 0;
        if (wt[idx] <= W) {
            include = val[idx] + solveUsingMemo(idx, W - wt[idx], val, wt, dp);
        }
        
        int exclude = solveUsingMemo(idx - 1, W, val, wt, dp);
        dp[idx][W] = Math.max(include, exclude);
        return dp[idx][W];
    }

    public static int knapSack(int N, int W, int val[], int wt[]) {
        int dp[][] = new int[N][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveUsingMemo(N - 1, W, val, wt, dp);
    }

    public static void main(String[] args) {
        int N1 = 2, W1 = 3, val1[] = { 1, 1 }, wt1[] = { 2, 1 };
        System.out.println(knapSack(N1, W1, val1, wt1));
        int N2 = 4, W2 = 8, val2[] = { 6, 1, 7, 7 }, wt2[] = { 1, 3, 4, 5 };
        System.out.println(knapSack(N2, W2, val2, wt2));
    }
}
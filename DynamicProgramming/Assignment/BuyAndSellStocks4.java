import java.util.Arrays;

public class BuyAndSellStocks4 {
    public static int solveUsingRecursion(int[] prices, int idx, int buy, int limit) {
        if (idx >= prices.length) {
            return 0;
        }

        if (limit == 0) {
            return 0;
        }

        int profit;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingRecursion(prices, idx + 1, 0, limit);
            int skipProfit = solveUsingRecursion(prices, idx + 1, 1, limit);
            profit = Math.max(buyItProfit, skipProfit);
        } else {
            int sellItProfit = prices[idx] + solveUsingRecursion(prices, idx + 1, 1, limit - 1);
            int skipProfit = solveUsingRecursion(prices, idx + 1, 0, limit);
            profit = Math.max(sellItProfit, skipProfit);
        }

        return profit;
    }

    public static int solveUsingMemo(int[] prices, int idx, int buy, int limit, int dp[][][]) {
        if (idx >= prices.length) {
            return 0;
        }

        if (limit == 0) {
            return 0;
        }

        if (dp[idx][buy][limit] != -1) {
            return dp[idx][buy][limit];
        }

        int profit;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingMemo(prices, idx + 1, 0, limit, dp);
            int skipProfit = solveUsingMemo(prices, idx + 1, 1, limit, dp);
            profit = Math.max(buyItProfit, skipProfit);
        } else {
            int sellItProfit = prices[idx] + solveUsingMemo(prices, idx + 1, 1, limit - 1, dp);
            int skipProfit = solveUsingMemo(prices, idx + 1, 0, limit, dp);
            profit = Math.max(sellItProfit, skipProfit);
        }

        dp[idx][buy][limit] = profit;
        return dp[idx][buy][limit];
    }

    public static int solveUsingTabulation(int prices[], int k) {
        int dp[][][] = new int[prices.length + 1][2][k + 1];

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int limit = 1; limit <= k; limit++) {
                    int profit;
                    if (buy == 1) {
                        int buyItProfit = ~(prices[idx] - 1) + dp[idx + 1][0][limit];
                        int skipProfit = dp[idx + 1][1][limit];
                        profit = Math.max(buyItProfit, skipProfit);
                    } else {
                        int sellItProfit = prices[idx] + dp[idx + 1][1][limit - 1];
                        int skipProfit = dp[idx + 1][0][limit];
                        profit = Math.max(sellItProfit, skipProfit);
                    }

                    dp[idx][buy][limit] = profit;
                }
            }
        }

        return dp[0][1][k];
    }

    public static int solveUsingTabulationSO(int[] prices, int k) {
        int[][][] dp = new int[2][2][k + 1];

        for (int i = prices.length - 1; i >= 0; --i) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int limit = 1; limit <= k; ++limit) {
                    int profit;
                    if (buy == 1) {
                        int buyItProfit = -prices[i] + dp[1][0][limit];
                        int skipProfit = dp[1][1][limit];
                        profit = Math.max(buyItProfit, skipProfit);
                    } else {
                        int sellItProfit = prices[i] + dp[1][1][limit - 1];
                        int skipProfit = dp[1][0][limit];
                        profit = Math.max(sellItProfit, skipProfit);
                    }
                    dp[0][buy][limit] = profit;
                }
            }
            dp[1] = dp[0].clone();
        }
        return dp[0][1][k];
    }

    public static int maxProfit(int k, int[] prices) {
        // return solveUsingRecursion(prices, 0, 1, k);
        // int dp[][][] = new int[prices.length + 1][2][k + 1];
        // for (int[][] grp : dp) {
        // for (int[] row : grp) {
        // Arrays.fill(row, -1);
        // }
        // }

        // return solveUsingMemo(prices, 0, 1, k, dp);
        // return solveUsingTabulation(prices, k);
        return solveUsingTabulationSO(prices, k);
    }

    public static void main(String[] args) {
        int prices1[] = { 2, 4, 1 };
        System.out.println(maxProfit(2, prices1));
        int prices2[] = { 3, 2, 6, 5, 0, 3 };
        System.out.println(maxProfit(2, prices2));
    }
}

import java.util.Arrays;

public class BuyAndSellStocks3 {
    public static int solveUsingRec(int prices[], int index, int buy, int limit) {
        if (index == prices.length) {
            return 0;
        }

        if (limit == 0) {
            return 0;
        }

        int profit = 0;
        if (buy == 1) {
            int buyItProfit = ~(prices[index] - 1) + solveUsingRec(prices, index + 1, 0, limit);
            int skipProfit = solveUsingRec(prices, index + 1, 1, limit);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItProfit = prices[index] + solveUsingRec(prices, index + 1, 1, limit - 1);
            int skipProfit = solveUsingRec(prices, index + 1, 0, limit);
            profit = Math.max(skipProfit, sellItProfit);
        }

        return profit;
    }

    public static int solveUsingMemo(int prices[], int index, int buy, int limit, int dp[][][]) {
        if (index == prices.length) {
            return 0;
        }

        if (limit == 0) {
            return 0;
        }

        if (dp[index][buy][limit] != -1) {
            return dp[index][buy][limit];
        }

        int profit = 0;
        if (buy == 1) {
            int buyItProfit = ~(prices[index] - 1) + solveUsingMemo(prices, index + 1, 0, limit, dp);
            int skipProfit = solveUsingMemo(prices, index + 1, 1, limit, dp);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItProfit = prices[index] + solveUsingMemo(prices, index + 1, 1, limit - 1, dp);
            int skipProfit = solveUsingMemo(prices, index + 1, 0, limit, dp);
            profit = Math.max(skipProfit, sellItProfit);
        }

        dp[index][buy][limit] = profit;
        return dp[index][buy][limit];
    }

    public static int solveUsingTabulation(int prices[]) {
        int dp[][][] = new int[prices.length + 1][2][3];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int limit = 1; limit < 3; limit++) {
                    int profit = 0;
                    if (buy == 1) {
                        int buyItProfit = ~(prices[index] - 1) + dp[index + 1][0][limit];
                        int skipProfit = dp[index + 1][1][limit];
                        profit = Math.max(skipProfit, buyItProfit);
                    } else {
                        int sellItProfit = prices[index] + dp[index + 1][1][limit - 1];
                        int skipProfit = dp[index + 1][0][limit];
                        profit = Math.max(skipProfit, sellItProfit);
                    }

                    dp[index][buy][limit] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public static int solveUsingTabulationSO(int[] prices, int buy, int limit) {
        int[][][] dp = new int[2][2][3];

        for (int i = prices.length - 1; i >= 0; --i) {
            for (buy = 0; buy < 2; ++buy) {
                for (limit = 1; limit < 3; ++limit) {
                    int profit = 0;
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
        return dp[0][1][2];
    }

    public static int maxProfit(int[] prices) {
        // int dp[][][] = new int[prices.length][2][3];
        // for (int[][] group : dp) {
        // for (int[] row : group) {
        // Arrays.fill(row, -1);
        // }
        // }

        return solveUsingTabulationSO(prices, 1, 2);
    }

    public static void main(String[] args) {
        int prices1[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(prices1));
        int prices2[] = { 1, 2, 3, 4, 5 };
        System.out.println(maxProfit(prices2));
        int prices3[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices3));
    }
}

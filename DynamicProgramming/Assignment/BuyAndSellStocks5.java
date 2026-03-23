import java.util.Arrays;

public class BuyAndSellStocks5 {
    public static int solveUsingRecursion(int[] prices, int idx, int buy, int fee) {
        if (idx >= prices.length) {
            return 0;
        }

        int profit;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingRecursion(prices, idx + 1, 0, fee);
            int skipProfit = solveUsingRecursion(prices, idx + 1, 1, fee);
            profit = Math.max(buyItProfit, skipProfit);
        } else {
            int sellItProfit = prices[idx] + solveUsingRecursion(prices, idx + 1, 1, fee) - fee;
            int skipProfit = solveUsingRecursion(prices, idx + 1, 0, fee);
            profit = Math.max(sellItProfit, skipProfit);
        }

        return profit;
    }

    public static int solveUsingMemo(int prices[], int idx, int buy, int fee, int dp[][]) {
        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingMemo(prices, idx + 1, 0, fee, dp);
            int skipProfit = solveUsingMemo(prices, idx + 1, 1, fee, dp);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItprofit = prices[idx] + solveUsingMemo(prices, idx + 1, 1, fee, dp) - fee;
            int skipItProfit = solveUsingMemo(prices, idx + 1, 0, fee, dp);
            profit = Math.max(skipItProfit, sellItprofit);
        }

        return dp[idx][buy] = profit;
    }

    public static int solveUsingTabulation(int prices[], int fee) {
        int dp[][] = new int[prices.length + 1][2];

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy--) {
                int profit;
                if (buy == 1) {
                    int buyItProfit = ~(prices[idx] - 1) + dp[idx + 1][0];
                    int skipProfit = dp[idx + 1][1];
                    profit = Math.max(buyItProfit, skipProfit);
                } else {
                    int sellItProfit = prices[idx] + dp[idx][1] - fee;
                    int skipProfit = dp[idx + 1][0];
                    profit = Math.max(sellItProfit, skipProfit);
                }

                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int solveUsingTabulationSO1(int prices[], int fee) {
        int dp[][] = new int[2][2];

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy--) {
                int profit;
                if (buy == 1) {
                    int buyItProfit = ~(prices[idx] - 1) + dp[1][0];
                    int skipProfit = dp[1][1];
                    profit = Math.max(buyItProfit, skipProfit);
                } else {
                    int sellItProfit = prices[idx] + dp[0][1] - fee;
                    int skipProfit = dp[1][0];
                    profit = Math.max(sellItProfit, skipProfit);
                }

                dp[0][buy] = profit;
            }
            dp[1] = dp[0];
        }

        return dp[0][1];
    }

    public static int solveUsingTabulationSO2(int prices[], int fee) {
        int next[] = new int[2];
        int curr[] = new int[2];

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy--) {
                int profit;
                if (buy == 1) {
                    int buyItProfit = ~(prices[idx] - 1) + next[0];
                    int skipProfit = next[1];
                    profit = Math.max(buyItProfit, skipProfit);
                } else {
                    int sellItProfit = prices[idx] + curr[1] - fee;
                    int skipProfit = next[0];
                    profit = Math.max(sellItProfit, skipProfit);
                }

                curr[buy] = profit;
            }

            next = curr.clone();
        }

        return next[1];
    }

    public static int maxProfit(int[] prices, int fee) {
        // return solveUsingRecursion(prices, 0, 1, fee);

        // int dp[][] = new int[prices.length + 1][2];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(prices, 0, 1, fee, dp);
        return solveUsingTabulationSO2(prices, fee);
    }

    public static void main(String[] args) {
        int prices1[] = { 1, 3, 2, 8, 4, 9 };
        System.out.println(maxProfit(prices1, 2));
        int prices2[] = { 1, 3, 7, 5, 10, 3 };
        System.out.println(maxProfit(prices2, 3));
    }
}

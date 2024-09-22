public class BuyAndSellStock2 {
    public static int solveUsingRec(int[] prices, int idx, int buy) {
        if (idx >= prices.length) {
            return 0;
        }

        int profit = 0;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingRec(prices, idx + 1, 0);
            int skipProfit = solveUsingRec(prices, idx + 1, 1);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItProfit = prices[idx] + solveUsingRec(prices, idx + 1, 1);
            int skipProfit = solveUsingRec(prices, idx + 1, 0);
            profit = Math.max(skipProfit, sellItProfit);
        }

        return profit;
    }

    public static int solveUsingMemo(int prices[], int idx, int buy, int dp[][]) {
        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit = 0;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingMemo(prices, idx + 1, 0, dp);
            int skipProfit = solveUsingMemo(prices, idx + 1, 1, dp);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItprofit = prices[idx] + solveUsingMemo(prices, idx + 1, 1, dp);
            int skipItProfit = solveUsingMemo(prices, idx + 1, 0, dp);
            profit = Math.max(skipItProfit, sellItprofit);
        }

        return dp[idx][buy] = profit;
    }

    public static int solveUsingTabulation(int[] prices) {
        int dp[][] = new int[prices.length + 1][2];
        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int buyItProfit = ~(prices[index] - 1) + dp[index + 1][0];
                    int skipProfit = dp[index + 1][1];
                    profit = Math.max(buyItProfit, skipProfit);
                } else {
                    int sellItprofit = prices[index] + dp[index + 1][1];
                    int skipItProfit = dp[index + 1][0];
                    profit = Math.max(skipItProfit, sellItprofit);
                }
                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int solveUsingTabulationSO(int prices[]) {
        int curr[] = new int[2];
        int next[] = new int[2];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int buyItProfit = ~(prices[index] - 1) + next[0];
                    int skipProfit = next[1];
                    profit = Math.max(buyItProfit, skipProfit);
                } else {
                    int sellItprofit = prices[index] + next[1];
                    int skipItProfit = next[0];
                    profit = Math.max(skipItProfit, sellItprofit);
                }
                curr[buy] = profit;
            }
            next = curr;
        }

        return next[1];
    }

    public static int maxProfit(int[] prices) {
        // int dp[][] = new int[prices.length][2];
        // for (int i = 0; i < dp.length; i++) {
        // dp[i][0] = -1;
        // dp[i][1] = -1;
        // }
        return solveUsingTabulationSO(prices);
    }

    public static void main(String[] args) {
        int prices1[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices1));
        int prices2[] = { 1, 2, 3, 4, 5 };
        System.out.println(maxProfit(prices2));
        int prices3[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices3));
    }
}

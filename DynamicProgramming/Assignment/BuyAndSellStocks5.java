import java.util.Arrays;

public class BuyAndSellStocks5 {
    public static int solveUsingRec(int[] prices, int idx, int buy, int fee) {
        if (idx >= prices.length) {
            return 0;
        }

        int profit = 0;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingRec(prices, idx + 1, 0, fee);
            int skipProfit = solveUsingRec(prices, idx + 1, 1, fee);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItProfit = prices[idx] + solveUsingRec(prices, idx + 1, 1, fee) - fee;
            int skipProfit = solveUsingRec(prices, idx + 1, 0, fee);
            profit = Math.max(skipProfit, sellItProfit);
        }

        return profit;
    }

    public static int solveUsingMemo(int prices[], int idx, int buy, int fee, int dp[][][]) {
        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][buy][fee] != -1) {
            return dp[idx][buy][fee];
        }

        int profit = 0;
        if (buy == 1) {
            int buyItProfit = ~(prices[idx] - 1) + solveUsingMemo(prices, idx + 1, 0, fee, dp);
            int skipProfit = solveUsingMemo(prices, idx + 1, 1, fee, dp);
            profit = Math.max(skipProfit, buyItProfit);
        } else {
            int sellItprofit = prices[idx] + solveUsingMemo(prices, idx + 1, 1, fee, dp) - fee;
            int skipItProfit = solveUsingMemo(prices, idx + 1, 0, fee, dp);
            profit = Math.max(skipItProfit, sellItprofit);
        }

        return dp[idx][buy][fee] = profit;
    }

    public static int solveUsingTabulation(int[] prices, int fee) {
        int dp[][] = new int[prices.length + 1][2];
        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int buyItProfit = ~(prices[index] - 1) + dp[index + 1][0];
                    int skipProfit = dp[index + 1][1];
                    profit = Math.max(buyItProfit, skipProfit);
                } else {
                    int sellItprofit = prices[index] + dp[index + 1][1] - fee;
                    int skipItProfit = dp[index + 1][0];
                    profit = Math.max(skipItProfit, sellItprofit);
                }
                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int solveUsingTabulationSO(int prices[], int fee) {
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
                    int sellItprofit = prices[index] + next[1] - fee;
                    int skipItProfit = next[0];
                    profit = Math.max(skipItProfit, sellItprofit);
                }
                curr[buy] = profit;
            }
            next = curr;
        }

        return next[1];
    }

    public static int maxProfit(int[] prices, int fee) {
        int dp[][][] = new int[prices.length + 1][2][fee + 1];
        for (int[][] group : dp) {
            for (int[] row : group) {
                Arrays.fill(row, -1);
            }
        }
        return solveUsingTabulationSO(prices, fee);
    }

    public static void main(String[] args) {
        int prices1[] = { 1, 3, 2, 8, 4, 9 };
        int fee1 = 2;
        System.out.println(maxProfit(prices1, fee1));
        int prices2[] = { 1, 3, 7, 5, 10, 3 };
        int fee2 = 3;
        System.out.println(maxProfit(prices2, fee2));
    }
}

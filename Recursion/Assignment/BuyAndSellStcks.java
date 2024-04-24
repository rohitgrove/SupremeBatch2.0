public class BuyAndSellStcks {
    static class MaxProfitHelper {
        int maxProfit;
        int minPrice;
        public MaxProfitHelper(int maxProfit, int minPrice) {
            this.maxProfit = maxProfit;
            this.minPrice = minPrice;
        }
    }
    public static int maxProfit(int[] prices) {
        MaxProfitHelper helper = new MaxProfitHelper(Integer.MIN_VALUE, Integer.MAX_VALUE);
        maxProfitFinder(prices, 0, helper);
        return helper.maxProfit;
    }

    public static void maxProfitFinder(int[] prices, int index, MaxProfitHelper helper) {
        // base case
        if (index == prices.length) {
            return;
        }
        // sol for one case
        if (prices[index] < helper.minPrice) {
            helper.minPrice = prices[index];
        }
        int todaysProfit = prices[index] - helper.minPrice;
        if (todaysProfit > helper.maxProfit) {
            helper.maxProfit = todaysProfit;
        }

        maxProfitFinder(prices, index + 1, helper);
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}

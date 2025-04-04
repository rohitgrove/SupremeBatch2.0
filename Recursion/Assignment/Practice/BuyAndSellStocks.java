public class BuyAndSellStocks {
    public static int solve(int prices[], int idx, int minPrice, int maxProfit) {
        if (idx == prices.length) {
            return maxProfit;
        }

        if (prices[idx] < minPrice) {
            minPrice = prices[idx];
        }

        int todayProfit = prices[idx] - minPrice;

        if (todayProfit > maxProfit) {
            maxProfit = todayProfit;
        }

        return solve(prices, idx + 1, minPrice, maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        return solve(prices, 0, minPrice, maxPrice);
    }
    public static void main(String[] args) {
        int prices1[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices1));
        int prices2[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices2));
    }
}

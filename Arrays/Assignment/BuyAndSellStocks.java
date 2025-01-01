public class BuyAndSellStocks {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int todaysProfit = prices[i] - minPrice;

            if (todaysProfit > maxProfit) {
                maxProfit = todaysProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int prices1[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices1));
        int prices2[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices2));
    }
}

public class CoinChange {
    public static int solve(int[] coins, int amount) {
        // Base case
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            // current coin ko sir tabhi use karenge
            // jab uski value <= amount hogi
            if (coin <= amount) {
                int recAns = solve(coins, amount - coin);
                if (recAns != Integer.MAX_VALUE) {
                    mini = Math.min(mini, 1 + recAns);
                }
            }
        }
        return mini;
    }

    public static int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int coins1[] = { 1, 2, 5 }, amount1 = 11;
        System.out.println(coinChange(coins1, amount1));
        int coins2[] = {2}, amount2 = 3;
        System.out.println(coinChange(coins2, amount2));
    }
}

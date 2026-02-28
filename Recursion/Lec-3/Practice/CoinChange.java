public class CoinChange {
    public static int solve(int coins[], int amount) {
        if (amount == 0) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (coin <= amount) {
                int recKaAnswer = solve(coins, amount - coin);
                if (recKaAnswer != Integer.MAX_VALUE) {
                    mini = Math.min(recKaAnswer + 1, mini);
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
        int coins1[] = { 1, 2, 5 }, amount = 11;
        System.out.println(coinChange(coins1, amount));
        int coins2[] = { 6, 8, 5 };
        System.out.println(coinChange(coins2, amount));
    }
}
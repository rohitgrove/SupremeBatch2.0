public class CoinChange {
    public static int solve(int coins[], int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int aageKaAns = solve(coins, amount - coins[i]);
                if (aageKaAns != Integer.MAX_VALUE) {
                    mini = Math.min(amount, 1 + aageKaAns);
                } 
            }
        }

        return mini;
    }

    public static int coinChange(int coins[], int amount) {
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
        int coins3[] = {1}, amount3 = 0;
        System.out.println(coinChange(coins3, amount3));
    }
}
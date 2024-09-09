import java.util.Arrays;

public class CoinChange {
    public static int solveRec(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int recursionKaAnswer = solveRec(coins, amount - coins[i]);
                if (recursionKaAnswer != Integer.MAX_VALUE) {
                    int ans = recursionKaAnswer + 1;
                    mini = Math.min(mini, ans);                                    
                }
            }
        }

        return mini;
    }

    public static int solveDP(int coins[], int amount, int dp[]) {
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int recursionKaAnswer = solveDP(coins, amount - coins[i], dp);
                if (recursionKaAnswer != Integer.MAX_VALUE) {
                    int ans = recursionKaAnswer + 1;
                    mini = Math.min(mini, ans);                                    
                }
            }
        }

        dp[amount] = mini;
        return dp[amount];
    }

    public static int solveTab(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int value = 1; value <= amount; value++) {
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (value - coins[i] >= 0) {
                    int recursionKaAnswer =  dp[value - coins[i]];
                    if (recursionKaAnswer != Integer.MAX_VALUE) {
                        int ans = recursionKaAnswer + 1;
                        mini = Math.min(mini, ans);                                    
                    }
                }
            }

            dp[value] = mini;
        }

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        // int ans = solveRec(coins, amount);
        // int dp[] = new int[amount + 1];
        // Arrays.fill(dp, -1);
        int ans = solveTab(coins, amount); 
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 }, amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}

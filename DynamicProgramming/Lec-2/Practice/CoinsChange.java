import java.util.Arrays;

public class CoinsChange {
    public static int solveUsingRec(int coins[], int amount) {
        if (amount == 0) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int recursionKaAnswer = solveUsingRec(coins, amount - coins[i]);
                if (recursionKaAnswer != Integer.MAX_VALUE) {
                    int ans = recursionKaAnswer + 1;
                    mini = Math.min(ans, mini);
                }
            }
        }

        return mini;
    }

    public static int solveUsingMemo(int coins[], int amount, int dp[]) {
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int recursionKaAnswer = solveUsingMemo(coins, amount - coins[i], dp);
                if (recursionKaAnswer != Integer.MAX_VALUE) {
                    int ans = recursionKaAnswer + 1;
                    mini = Math.min(ans, mini);
                }
            }
        }

        dp[amount] = mini;
        return dp[amount];
    }

    public static int solveUsingTabulation(int coins[], int amount) {
        int dp[] = new int[amount + 1];

        dp[0] = 0;

        for (int value = 1; value <= amount; value++) {
            int mini = Integer.MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                if (value - coins[i] >= 0) {
                    int recursionKaAnswer = solveUsingMemo(coins, value - coins[i], dp);
                    if (recursionKaAnswer != Integer.MAX_VALUE) {
                        int ans = recursionKaAnswer + 1;
                        mini = Math.min(ans, mini);
                    }
                }
            }
    
            dp[value] = mini;
        }

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        // int ans = solveUsingRec(coins, amount);
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = solveUsingMemo(coins, amount, dp);
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

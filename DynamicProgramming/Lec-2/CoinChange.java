import java.util.Arrays;

public class CoinChange {
    public static int solveUsingRec(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }

        // recursive relation
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            // find ans using ith coin
            // call recursive only for valid amounts i.e >= 0 wale amounts
            if (amount - coins[i] >= 0) {
                int recursionKaAnswer = solveUsingRec(coins, amount - coins[i]);
                // if a valid answer
                if (recursionKaAnswer != Integer.MAX_VALUE) {
                    // considering usage of ith coin
                    int ans = recursionKaAnswer + 1;
                    mini = Math.min(mini, ans);
                }
            }
        }

        return mini;
    }

    public static int solveUsingMemo(int[] coins, int amount, int[] dp) {
        // base case
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        // recursive relation
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            // find ans using ith coin
            // call recursive only for valid amounts i.e >= 0 wale amounts
            if (amount - coins[i] >= 0) {
                int recursionKaAnswer = solveUsingMemo(coins, amount - coins[i], dp);
                // if a valid answer
                if (recursionKaAnswer != Integer.MAX_VALUE) {
                    // considering usage of ith coin
                    int ans = recursionKaAnswer + 1;
                    mini = Math.min(mini, ans);
                }
            }
        }
        dp[amount] = mini;
        return dp[amount];
    }

    public static int solveUsingTabulation(int coins[], int amount) {
        // step1
        int dp[] = new int[amount + 1];
        // step2: base case analyse
        dp[0] = 0;

        // for loop
        for (int value = 1; value <= amount; value++) {
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                // find ans using ith coin
                // call recursive only for valid amounts i.e >= 0 wale amounts
                if (value - coins[i] >= 0) {
                    int recursionKaAnswer = dp[value - coins[i]];
                    // if a valid answer
                    if (recursionKaAnswer != Integer.MAX_VALUE) {
                        // considering usage of ith coin
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
        // int ans = solveUsingRec(coins, amount);
        // int dp[] = new int[amount + 1];
        // Arrays.fill(dp, -1);
        int ans = solveUsingTabulation(coins, amount);
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


public class CoinChange2 {
    public static int solveUsingRec(int[] coins, int idx, int amount) {
        if (idx < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int take = 0;
        if (amount >= coins[idx]) {
            take = solveUsingRec(coins, idx, amount - coins[idx]);
        }
        int leave = solveUsingRec(coins, idx - 1, amount);
        return take + leave;
    }

    public static int solveUsingMemo(int[] coins, int idx, int amount, int[][] memo) {
        if (idx < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }

        int take = 0;
        if (amount >= coins[idx]) {
            take = solveUsingMemo(coins, idx, amount - coins[idx], memo);
        }
        int leave = solveUsingMemo(coins, idx - 1, amount, memo);
        return memo[idx][amount] = take + leave;
    }

    public static int solveUsingTabulation(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int idx = 1; idx < coins.length + 1; idx++) {
            for (int amt = 1; amt < amount + 1; amt++) {
                int take = 0;
                if (amt >= coins[idx - 1]) {
                    take = dp[idx][amt - coins[idx - 1]];
                }
                int leave = dp[idx - 1][amt];
                dp[idx][amt] = take + leave;
            }
        }
        return dp[coins.length][amount];
    }

    public static int solveUsingTabulationSO(int amount, int[] coins) {
        int[] next = new int[amount + 1];
        int[] curr = new int[amount + 1];
        next[0] = 1;
        curr[0] = 1;
        for (int idx = 1; idx < coins.length + 1; idx++) {
            for (int amt = coins[idx - 1]; amt < amount + 1; amt++) {
                int take = curr[amt - coins[idx - 1]];
                int leave = next[amt];
                curr[amt] = take + leave;
            }
            next = curr.clone();
        }
        return next[amount];
    }

    public static int change(int amount, int[] coins) {
        // int[][] memo = new int[coins.length][amount + 1];
        // for (int[] row : memo) {
        // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(coins, coins.length - 1, amount, memo);
        return solveUsingTabulation(amount, coins);
    }

    public static void main(String[] args) {
        int amount = 5, coins[] = { 1, 2, 5 };
        System.out.println(change(amount, coins));
    }
}
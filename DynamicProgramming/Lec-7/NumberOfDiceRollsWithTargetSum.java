import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    public static int solveUsingRecursion(int n, int k, int target, int diceUsed, int currSum) {
        if (diceUsed == n && currSum == target) {
            return 1;
        }

        if (diceUsed == n && currSum != target) {
            return 0;
        }

        if (currSum == target && diceUsed != n) {
            return 0;
        }

        int ans = 0;
        for (int face = 0; face <= k; face++) {
            ans = ans + solveUsingRecursion(n, k, target, diceUsed + 1, currSum + face);
        }

        return ans;
    }

    static long MOD = 1000000007;

    public static long solveUsingMemo(int n, int k, int target, int usedDice, int currSum, long[][] dp) {
        // Base case
        if (currSum == target && usedDice == n) {
            return 1;
        }
        if (currSum != target && usedDice == n) {
            return 0;
        }
        if (currSum > target || usedDice > n) {
            return 0;
        }

        // Step 3: If ans already exists, then return ans
        if (dp[usedDice][currSum] != -1) {
            return dp[usedDice][currSum];
        }

        // Step 2: Store ans and return ans using DP array
        // Recursive call
        long ans = 0;
        for (int face = 1; face <= k; face++) {
            long recAns = solveUsingMemo(n, k, target, usedDice + 1, currSum + face, dp);
            ans = (ans + recAns) % MOD;
        }

        dp[usedDice][currSum] = ans;
        return ans;
    }

    public static int solveUsingTabulation(int n, int k, int target) {
        long[][] dp = new long[n + 1][target + 1];

        dp[n][target] = 1;

        for (int usedDice = n - 1; usedDice >= 0; usedDice--) {
            for (int currSum = target; currSum >= 0; currSum--) {
                long ans = 0;
                for (int face = 1; face <= k; face++) {
                    if (currSum + face <= target) {
                        // Corner Case
                        ans = (ans % MOD + (dp[usedDice + 1][currSum + face] % MOD)) % MOD;
                    }
                }
                dp[usedDice][currSum] = ans;
            }
        }
        return (int) dp[0][0];
    }

    public static int solveUsingTabulationSO(int n, int k, int target) {
        long curr[] = new long[target + 1];
        long next[] = new long[target + 1];

        next[target] = 1;

        for (int usedDice = n - 1; usedDice >= 0; usedDice--) {
            for (int currSum = target; currSum >= 0; currSum--) {
                long ans = 0;
                for (int face = 1; face <= k; face++) {
                    if (currSum + face <= target) {
                        // Corner Case
                        ans = (ans % MOD + (next[currSum + face] % MOD)) % MOD;
                    }
                }
                curr[currSum] = ans;
            }

            next = curr.clone();
        }
        return (int) next[0];
    }

    public static int numRollsToTarget(int n, int k, int target) {
        // int usedDice = 0;
        // int currSum = 0;
        // return solveUsingRecursion(n, k, target, currSum, currSum);
        // Step 1: Create DP array
        // long[][] dp = new long[n + 1][target + 1];
        // for (long[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        return (int) solveUsingTabulationSO(n, k, target);
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(30, 30, 500));
    }
}

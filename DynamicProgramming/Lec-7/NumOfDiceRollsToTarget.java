import java.util.Arrays;

public class NumOfDiceRollsToTarget {
    static int MOD = 1000000007;

    public static int solveUsingRecursion(int n, int k, int target) {
        if (target < 0) {
            return 0;
        }

        if (target == 0 && n == 0) {
            return 1;
        }

        if (target != 0 && n == 0) {
            return 0;
        }

        if (target == 0 && n != 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += solveUsingRecursion(n - 1, k, target - i);
        }
        return ans;
    }

    public static int solveUsingMemo(int n, int k, int target, int dp[][]) {
        if (target == 0 && n == 0) {
            return 1;
        }

        if (target != 0 && n == 0) {
            return 0;
        }

        if (target == 0 && n != 0) {
            return 0;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            int recKaAnswer = 0;
            if (target - i >= 0) {
                recKaAnswer = solveUsingMemo(n - 1, k, target - i, dp);
            }
            ans = (ans % MOD + recKaAnswer) % MOD;
        }

        dp[n][target] = ans;
        return dp[n][target];
    }

    public static int numRollsToTarget(int n, int k, int target) {
        // int dp[][] = new int[n + 1][target + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(n, k, target, dp);
        // return ans;

        // int diceUsed = 0;
        // int currSum = 0;
        // int dp[][] = new int[n + 1][target + 1];

        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // int ans = solveUsingMemo(n, k, target, diceUsed, currSum, dp);
        // return ans;

        int ans = solveUsingTabulationSO(n, k, target);
        return ans;
    }

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
        for (int face = 1; face <= k; face++) {
            ans = ans + solveUsingRecursion(n, k, target, diceUsed + 1, currSum + face);
        }

        return ans;
    }

    public static int solveUsingMemo(int n, int k, int target, int diceUsed, int currSum, int dp[][]) {
        if (diceUsed == n && currSum == target) {
            return 1;
        }

        if (diceUsed == n && currSum != target) {
            return 0;
        }

        if (currSum == target && diceUsed != n) {
            return 0;
        }

        if (dp[diceUsed][currSum] != -1) {
            return dp[diceUsed][currSum];
        }

        int ans = 0;
        for (int face = 1; face <= k; face++) {
            int recKaAnswer = 0;
            if (currSum + face <= target) {
                recKaAnswer = solveUsingMemo(n, k, target, diceUsed + 1, currSum + face, dp) % MOD;
            }

            ans = (ans % MOD + recKaAnswer) % MOD;
        }

        dp[diceUsed][currSum] = ans;
        return dp[diceUsed][currSum];
    }

    public static int solveUsingTabulation(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];

        dp[n][target] = 1;

        for (int dice = n - 1; dice >= 0; dice--) {
            for (int sum = target - 1; sum >= 0; sum--) {
                int ans = 0;
                for (int face = 1; face <= k; face++) {
                    int recKaAnswer = 0;
                    if (sum + face <= target) {
                        recKaAnswer = dp[dice + 1][sum + face] % MOD;
                    }
        
                    ans = (ans % MOD + recKaAnswer) % MOD;
                }
        
                dp[dice][sum] = ans;
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int n, int k, int target) {
        int curr[] = new int[target + 1];
        int next[] = new int[target + 1];
        next[target] = 1;

        for (int dice = n - 1; dice >= 0; dice--) {
            for (int sum = target - 1; sum >= 0; sum--) {
                int ans = 0;
                for (int face = 1; face <= k; face++) {
                    int recKaAnswer = 0;
                    if (sum + face <= target) {
                        recKaAnswer = next[sum + face] % MOD;
                    }
        
                    ans = (ans % MOD + recKaAnswer) % MOD;
                }
        
                curr[sum] = ans;
            }
            next = curr.clone();
        }

        return next[0];
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(30, 30, 500));
    }
}

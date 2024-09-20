import java.util.Arrays;

public class StoneGame3 {
    public static int solveUsingRec(int[] stoneValue, int idx) {
        if (idx == stoneValue.length) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        int total = 0;
        for (int X = 1; X <= 3; X++) {
            if (idx + X - 1 >= stoneValue.length) {
                break;
            }
            total += stoneValue[idx + X - 1];
            ans = Math.max(ans, total - solveUsingRec(stoneValue, idx + X));
        }

        return ans;
    }

    public static int solveUsingMemo(int stoneValue[], int idx, int dp[]) {
        if (idx == stoneValue.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ans = Integer.MIN_VALUE;
        int total = 0;
        for (int X = 1; X <= 3; X++) {
            if (idx + X - 1 >= stoneValue.length) {
                break;
            }
            total += stoneValue[idx + X - 1];
            ans = Math.max(ans, total - solveUsingMemo(stoneValue, idx + X, dp));
        }

        dp[idx] = ans;
        return dp[idx];
    }

    public static int solveUsingTabulation(int[] stoneValue) {
        int dp[] = new int[stoneValue.length + 1];

        for (int idx = stoneValue.length - 1; idx >= 0; idx--) {
            int ans = Integer.MIN_VALUE;
            int total = 0;
            for (int X = 1; X <= 3; X++) {
                if (idx + X - 1 >= stoneValue.length) {
                    break;
                }
                total += stoneValue[idx + X - 1];
                ans = Math.max(ans, total - dp[idx + X]);
            }
    
            dp[idx] = ans;
        }

        return dp[0];
    }

    public static String stoneGameIII(int[] stoneValue) {
        // int dp[] = new int[stoneValue.length + 1];
        // Arrays.fill(dp, -1);
        int ans = solveUsingTabulation(stoneValue); // A-B
        if (ans > 0) {
            return "Alice";
        }
        if (ans < 0) {
            return "Bob";
        }

        return "Tie";
    }

    public static void main(String[] args) {
        int stoneValue1[] = { 1, 2, 3, 7 };
        System.out.println(stoneGameIII(stoneValue1));
        int stoneValue2[] = { 1, 2, 3, -9 };
        System.out.println(stoneGameIII(stoneValue2));
        int stoneValue3[] = { 1, 2, 3, 6 };
        System.out.println(stoneGameIII(stoneValue3));
    }
}

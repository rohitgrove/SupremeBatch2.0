import java.util.Arrays;

public class StoneGame2 {
    public static int solveUsingRecursion(int[] piles, int idx, int M, boolean alice) {
        if (idx == piles.length) {
            return 0;
        }

        int ans = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (idx + X - 1 >= piles.length) {
                break;
            }
            total += piles[idx + X - 1];
            if (alice) {
                ans = Math.max(ans, total + solveUsingRecursion(piles, idx + X, Math.max(X, M), !alice));
            } else {
                ans = Math.min(ans, solveUsingRecursion(piles, idx + X, Math.max(X, M), !alice));
            }
        }

        return ans;
    }

    public static int solveUsingMemo(int[] piles, int idx, int M, boolean alice, int dp[][][]) {
        if (idx == piles.length) {
            return 0;
        }

        if (dp[idx][M][alice ? 1 : 0] != -1) {
            return dp[idx][M][alice ? 1 : 0];
        }

        int ans = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (idx + X - 1 >= piles.length) {
                break;
            }
            total += piles[idx + X - 1];
            if (alice) {
                ans = Math.max(ans, total + solveUsingMemo(piles, idx + X, Math.max(X, M), !alice, dp));
            } else {
                ans = Math.min(ans, solveUsingMemo(piles, idx + X, Math.max(X, M), !alice, dp));
            }
        }

        dp[idx][M][alice ? 1 : 0] = ans;
        return dp[idx][M][alice ? 1 : 0];
    }

    public static int solveUsingTabulation(int[] piles) {
        int dp[][][] = new int[piles.length + 1][piles.length + 1][2];

        for (int idx = piles.length - 1; idx >= 0; idx--) {
            for (int M = piles.length; M >= 0; M--) {
                for (int alice = 0; alice <= 1; alice++) {
                    int ans = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    int total = 0;
            
                    for (int X = 1; X <= 2 * M; X++) {
                        if (idx + X - 1 >= piles.length) {
                            break;
                        }
                        total += piles[idx + X - 1];
                        if (alice == 1) {
                            ans = Math.max(ans, total + dp[idx + X][Math.max(X, M)][alice == 1 ? 0 : 1]);
                        } else {
                            ans = Math.min(ans, dp[idx + X][Math.max(X, M)][alice == 1 ? 0 : 1]);
                        }
                    }
            
                    dp[idx][M][alice] = ans;
                }
            }
        }

        return dp[0][1][1];
    }

    public static int stoneGameII(int[] piles) {
        // return solveUsingRecursion(piles, 0, 1, true);

        // int dp[][][] = new int[piles.length + 1][piles.length + 1][2];
        // for (int[][] cube : dp) {
        //     for (int[] row : cube) {
        //         Arrays.fill(row, -1);
        //     }
        // }

        // return solveUsingMemo(piles, 0, 1, true, dp);

        return solveUsingTabulation(piles);
    }

    public static void main(String[] args) {
        int piles1[] = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameII(piles1));
        int piles2[] = { 1, 2, 3, 4, 5, 100 };
        System.out.println(stoneGameII(piles2));
    }
}

import java.util.Arrays;

public class StoneGame2 {
    public static int solveUsingRec(int[] piles, int i, int M, boolean alice) {
        if (i == piles.length) {
            return 0;
        }

        int ans = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (i + X - 1 >= piles.length) {
                break;
            }
            total += piles[i + X - 1];
            if (alice) {
                ans = Math.max(ans, total + solveUsingRec(piles, i + X, Math.max(X, M), !alice));
            } else {
                ans = Math.min(ans, solveUsingRec(piles, i + X, Math.max(X, M), !alice));
            }
        }

        return ans;
    }

    public static int solveUsingMemo(int piles[], int i, int M, boolean alice, int dp[][][]) {
        if (i == piles.length) {
            return 0;
        }

        if (dp[i][M][alice ? 1 : 0] != -1) {
            return dp[i][M][alice ? 1 : 0];
        }

        int ans = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (i + X - 1 >= piles.length) {
                break;
            }
            total += piles[i + X - 1];
            if (alice) {
                ans = Math.max(ans, total + solveUsingMemo(piles, i + X, Math.max(X, M), !alice, dp));
            } else {
                ans = Math.min(ans, solveUsingMemo(piles, i + X, Math.max(X, M), !alice, dp));
            }
        }

        return dp[i][M][alice ? 1 : 0] = ans;
    }

    public static int solveUsingTabulation(int piles[]) {
        int dp[][][] = new int[piles.length + 1][piles.length + 1][2];

        for (int i = piles.length - 1; i >= 0; i--) {
            for (int M = piles.length; M >= 1; M--) {
                for (int alice = 0; alice <= 1; alice++) {

                    int ans = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    int total = 0;
            
                    for (int X = 1; X <= 2 * M; X++) {
                        if (i + X - 1 >= piles.length) {
                            break;
                        }
                        total += piles[i + X - 1];
                        if (alice == 1) {
                            ans = Math.max(ans, total + dp[i + X][Math.max(X, M)][alice == 1 ? 0 : 1]);
                        } else {
                            ans = Math.min(ans, dp[i + X][Math.max(X, M)][alice == 0 ? 1 : 0]);
                        }
                    }
            
                    dp[i][M][alice == 1 ? 1 : 0] = ans;                    
                }
            }
        }

        return dp[0][1][1];
    }

    public static int stoneGameII(int[] piles) {
        // int dp[][][] = new int[piles.length + 1][piles.length + 1][2];

        // for (int[][] box : dp) {
        //     for (int[] row : box) {
        //         Arrays.fill(row, -1);
        //     }
        // }
        return solveUsingTabulation(piles);
    }

    public static void main(String[] args) {
        int piles1[] = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameII(piles1));
        int piles2[] = { 1, 2, 3, 4, 5, 100 };
        System.out.println(stoneGameII(piles2));
    }
}

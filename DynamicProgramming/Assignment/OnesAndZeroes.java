import java.util.Arrays;

public class OnesAndZeroes {
    public static void convertStrsToNumStrs(String strs[], int[][] numStrs) {
        for (int str = 0; str < strs.length; str++) {
            String currStr = strs[str];
            int zeros = 0, ones = 0;
            for (int i = 0; i < currStr.length(); i++) {
                char ch = currStr.charAt(i);
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            numStrs[str] = new int[] { zeros, ones };
        }
    }

    public static int solveUsingRecursion(int[][] numStrs, int idx, int m, int n) {
        if (idx == numStrs.length) {
            return 0;
        }

        int zeros = numStrs[idx][0];
        int ones = numStrs[idx][1];
        int include = 0, exclude;

        if (m - zeros >= 0 && n - ones >= 0) {
            include = 1 + solveUsingRecursion(numStrs, idx + 1, m - zeros, n - ones);
        }
        exclude = solveUsingRecursion(numStrs, idx + 1, m, n);
        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int[][] numStrs, int idx, int m, int n, int dp[][][]) {
        if (idx == numStrs.length) {
            return 0;
        }

        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }

        int zeros = numStrs[idx][0];
        int ones = numStrs[idx][1];
        int include = 0, exclude;

        if (m - zeros >= 0 && n - ones >= 0) {
            include = 1 + solveUsingMemo(numStrs, idx + 1, m - zeros, n - ones, dp);
        }
        exclude = solveUsingMemo(numStrs, idx + 1, m, n, dp);
        dp[idx][m][n] = Math.max(include, exclude);
        return dp[idx][m][n];
    }

    public static int solveUsingTabluation(int[][] numStrs, int m, int n) {
        int dp[][][] = new int[numStrs.length + 1][m + 1][n + 1];

        for (int idx = numStrs.length - 1; idx >= 0; idx--) {
            for (int m_idx = 0; m_idx <= m; m_idx++) {
                for (int n_idx = 0; n_idx <= n; n_idx++) {
                    int zeros = numStrs[idx][0];
                    int ones = numStrs[idx][1];
                    int include = 0, exclude;

                    if (m_idx - zeros >= 0 && n_idx - ones >= 0) {
                        include = 1 + dp[idx + 1][m_idx - zeros][n_idx - ones];
                    }
                    exclude = dp[idx + 1][m_idx][n_idx];
                    dp[idx][m_idx][n_idx] = Math.max(include, exclude);
                }
            }
        }

        return dp[0][m][n];
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int numStrs[][] = new int[strs.length][];
        convertStrsToNumStrs(strs, numStrs);

        // return solveUsingRecursion(numStrs, 0, m, n);

        // int dp[][][] = new int[strs.length + 1][m + 1][n + 1];

        // for (int[][] grp : dp) {
        // for (int[] row : grp) {
        // Arrays.fill(row, -1);
        // }
        // }

        // return solveUsingMemo(numStrs, 0, m, n, dp);

        return solveUsingTabluation(numStrs, m, n);
    }

    public static void main(String[] args) {
        String strs1[] = { "10", "0001", "111001", "1", "0" };
        System.out.println(findMaxForm(strs1, 5, 3));
        String strs2[] = { "10", "0", "1" };
        System.out.println(findMaxForm(strs2, 1, 1));
    }
}

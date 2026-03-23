public class UniquePaths {
    public static int solveUsingRecursion(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 1;
        }

        int down = solveUsingRecursion(i + 1, j, n, m);
        int right = solveUsingRecursion(i, j + 1, n, m);

        return down + right;
    }

    public static int solveUsingMemo(int i, int j, int n, int m, int dp[][]) {
        if (i == n || j == m) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = solveUsingMemo(i + 1, j, n, m, dp);
        int right = solveUsingMemo(i, j + 1, n, m, dp);

        dp[i][j] = down + right;
        return dp[i][j];
    }

    public static int solveUsingTabulation(int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = m; j >= 1; j--) {
                if (i == n || j == m) {
                    dp[i][j] = 1;
                } else {
                    int down = dp[i + 1][j];
                    int right = dp[i][j + 1];

                    dp[i][j] = down + right;
                }
            }
        }

        return dp[1][1];
    }

    public static int solveUsingTabulationSO1(int n, int m) {
        int next[] = new int[m + 1];
        int curr[] = new int[m + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = m; j >= 1; j--) {
                if (i == n || j == m) {
                    curr[j] = 1;
                } else {
                    int down = next[j];
                    int right = curr[j + 1];

                    curr[j] = down + right;
                }
            }
            next = curr.clone();
        }

        return next[1];
    }

    public static int solveUsingTabulationSO2(int n, int m) {
        int next[] = new int[n + 1];
        int curr[] = new int[n + 1];
        for (int j = m; j >= 1; j--) {
            for (int i = n; i >= 1; i--) {
                if (i == n || j == m) {
                    curr[i] = 1;
                } else {
                    int down = curr[i + 1];
                    int right = next[i];

                    curr[i] = down + right;
                }
            }
            next = curr.clone();
        }

        return next[1];
    }

    public static int uniquePaths(int m, int n) {
        // return solveUsingRecursion(1, 1, n, m);

        // int dp[][] = new int[n + 1][m + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(1, 1, n, m, dp);
        return solveUsingTabulationSO2(n, m);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
    }
}
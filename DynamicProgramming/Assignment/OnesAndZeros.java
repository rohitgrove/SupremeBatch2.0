import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    public int noOfZeros;
    public int noOfOnes;

    public Pair(int noOfZeros, int noOfOnes) {
        this.noOfZeros = noOfZeros;
        this.noOfOnes = noOfOnes;
    }
}

public class OnesAndZeros {
    public static void convertStrsToNumStrs(String strs[], ArrayList<Pair> numStrs) {
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

            numStrs.add(new Pair(zeros, ones));
        }
    }

    public static int solveUsingRec(ArrayList<Pair> numStrs, int i, int m, int n) {
        if (i == numStrs.size()) {
            return 0;
        }

        int zeros = numStrs.get(i).noOfZeros;
        int ones = numStrs.get(i).noOfOnes;
        int include = 0, exclude = 0;

        if (m - zeros >= 0 && n - ones >= 0) {
            include = 1 + solveUsingRec(numStrs, i + 1, m - zeros, n - ones);
        }
        exclude = solveUsingRec(numStrs, i + 1, m, n);
        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(ArrayList<Pair> numStrs, int i, int m, int n, int dp[][][]) {
        if (i == numStrs.size()) {
            return 0;
        }

        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }

        int zeros = numStrs.get(i).noOfZeros;
        int ones = numStrs.get(i).noOfOnes;
        int include = 0, exclude = 0;
        if (m - zeros >= 0 && n - ones >= 0) {
            include = 1 + solveUsingMemo(numStrs, i + 1, m - zeros, n - ones, dp);
        }
        exclude = solveUsingMemo(numStrs, i + 1, m, n, dp);
        return dp[i][m][n] = Math.max(include, exclude);
    }

    public static int solveUsingTabulation(ArrayList<Pair> numStrs, int m, int n) {
        int dp[][][] = new int[numStrs.size() + 1][m + 1][n + 1];
        for (int i = numStrs.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int zeros = numStrs.get(i).noOfZeros;
                    int ones = numStrs.get(i).noOfOnes;
                    int include = 0, exclude = 0;
                    if (j - zeros >= 0 && k - ones >= 0) {
                        include = 1 + dp[i + 1][j - zeros][k - ones];
                    }
                    exclude = dp[i + 1][j][k];
                    dp[i][j][k] = Math.max(include, exclude);
                }
            }
        }

        return dp[0][m][n];
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        ArrayList<Pair> numStrs = new ArrayList<>(); // {no. of 0's, no. of 1's}
        convertStrsToNumStrs(strs, numStrs);

        // int dp[][][] = new int[numStrs.size() + 1][m + 1][n + 1];
        // for (int[][] group : dp) {
        // for (int[] row : group) {
        // Arrays.fill(row, -1);
        // }
        // }
        // return solveUsingMemo(numStrs, 0, m, n, dp);

        return solveUsingTabulation(numStrs, m, n);
    }

    public static void main(String[] args) {
        String strs1[] = { "10", "0001", "111001", "1", "0" };
        int m1 = 5, n1 = 3;
        System.out.println(findMaxForm(strs1, m1, n1));
        String strs2[] = { "10", "0", "1" };
        int m2 = 1, n2 = 1;
        System.out.println(findMaxForm(strs2, m2, n2));
    }
}

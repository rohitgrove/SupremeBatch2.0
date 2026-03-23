import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RussianDoll {
    public static int solveUsingRecursion(int[][] env, int prev, int curr) {
        if (curr == env.length) {
            return 0;
        }

        int include = Integer.MIN_VALUE;
        if (prev == -1 || env[prev][0] < env[curr][0] && env[prev][1] < env[curr][1]) {
            include = 1 + solveUsingRecursion(env, curr, curr + 1);
        }
        int exclude = solveUsingRecursion(env, prev, curr + 1);
        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int env[][], int prev, int curr, int dp[][]) {
        if (curr == env.length) {
            return 0;
        }

        if (dp[prev + 1][curr] != -1) {
            return dp[prev + 1][curr];
        }

        int include = Integer.MIN_VALUE;
        if (prev == -1 || (env[prev][0] < env[curr][0] && env[prev][1] < env[curr][1])) {
            include = 1 + solveUsingMemo(env, curr, curr + 1, dp);
        }

        int exclude = solveUsingMemo(env, prev, curr + 1, dp);

        dp[prev + 1][curr] = Math.max(include, exclude);
        return dp[prev + 1][curr];
    }

    public static int solveUsingTabulation(int env[][]) {
        int dp[][] = new int[env.length + 1][env.length + 1];

        for (int curr_index = env.length - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || (env[prev_index][0] < env[curr_index][0] && env[prev_index][1] < env[curr_index][1])) {
                    include = 1 + dp[curr_index + 1][curr_index + 1];
                }

                int exlude = 0 + dp[curr_index + 1][prev_index + 1];

                dp[curr_index][prev_index + 1] = Math.max(include, exlude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int env[][]) {
        int nextRow[] = new int[env.length + 1];
        int currRow[] = new int[env.length + 1];

        for (int curr_index = env.length - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || (env[prev_index][0] < env[curr_index][0] && env[prev_index][1] < env[curr_index][1])) {
                    include = 1 + nextRow[curr_index + 1];
                }

                int exlude = 0 + nextRow[prev_index + 1];

                currRow[prev_index + 1] = Math.max(include, exlude);
            }
            // shifting
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveUsingBS(int env[][]) {
        Arrays.sort(env, new BSCompare());
        List<Integer> ans = new ArrayList<>();
        // initial state
        ans.addLast(env[0][1]);

        for (int i = 1; i < env.length; i++) {
            if (env[i][1] > ans.getLast()) {
                ans.addLast(env[i][1]);
            } else {
                // just bada nummber exist karta hai
                int index = Collections.binarySearch(ans, env[i][1]);
                if (index < 0) {
                    index = -(index + 1);
                }
                // replace
                ans.set(index, env[i][1]);
            }
        }

        return ans.size();
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        // return solveUsingRecursion(envelopes, -1, 0);

        // int dp[][] = new int[envelopes.length + 1][envelopes.length + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(envelopes, -1, 0, dp);

        // return solveUsingTabulation(envelopes);
        return solveUsingBS(envelopes);
    }

    public static void main(String[] args) {
        int envelopes1[][] = { { 5, 4 },
                { 6, 4 },
                { 6, 7 },
                { 2, 3 } };

        System.out.println(maxEnvelopes(envelopes1));

        int envelopes2[][] = { { 1, 1 },
                { 1, 1 },
                { 1, 1 } };

        System.out.println(maxEnvelopes(envelopes2));
    }
}

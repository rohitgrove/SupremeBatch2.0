import java.util.Arrays;

public class ReducingDishes {
    public static int solveUsingRecursion(int[] satisfaction, int idx, int time) {
        if (idx >= satisfaction.length) {
            return 0;
        }

        int include = (satisfaction[idx] * time) + solveUsingRecursion(satisfaction, idx + 1, time + 1);
        int exclude = solveUsingRecursion(satisfaction, idx + 1, time);

        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int[] satisfaction, int idx, int time, int dp[][]) {
        if (idx >= satisfaction.length) {
            return 0;
        }

        if (dp[idx][time] != -1) {
            return dp[idx][time];
        }

        int include = (satisfaction[idx] * time) + solveUsingMemo(satisfaction, idx + 1, time + 1, dp);
        int exclude = solveUsingMemo(satisfaction, idx + 1, time, dp);

        dp[idx][time] = Math.max(include, exclude);
        return dp[idx][time];
    }

    public static int solveUsingTabluation(int satisfaction[]) {
        int dp[][] = new int[satisfaction.length + 1][satisfaction.length + 2];

        for (int idx = satisfaction.length - 1; idx >= 0; idx--) {
            for (int time = satisfaction.length; time >= 1; time--) {
                int include = (satisfaction[idx] * time) + dp[idx + 1][time + 1];
                int exclude = dp[idx + 1][time];

                dp[idx][time] = Math.max(include, exclude);
            }
        }

        return dp[0][1];
    }

    public static int solveUsingTabluationSO(int satisfaction[]) {
        int next[] = new int[satisfaction.length + 2];
        int curr[] = new int[satisfaction.length + 2];

        for (int idx = satisfaction.length - 1; idx >= 0; idx--) {
            for (int time = satisfaction.length; time >= 1; time--) {
                int include = (satisfaction[idx] * time) + next[time + 1];
                int exclude = next[time];

                curr[time] = Math.max(include, exclude);
            }
            next = curr.clone();
        }

        return next[1];
    }

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        // return solveUsingRecursion(satisfaction, 0, 1);

        // int dp[][] = new int[satisfaction.length + 1][satisfaction.length + 2];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(satisfaction, 0, 1, dp);
        return solveUsingTabluationSO(satisfaction);
    }

    public static void main(String[] args) {
        int satisfaction1[] = { -1, -8, 0, 5, -9 };
        System.out.println(maxSatisfaction(satisfaction1));
        int satisfaction2[] = { 4, 3, 2 };
        System.out.println(maxSatisfaction(satisfaction2));
    }
}

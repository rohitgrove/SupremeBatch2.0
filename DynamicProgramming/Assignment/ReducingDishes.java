import java.util.Arrays;

public class ReducingDishes {
    public static int solveUsingRec(int[] satisfaction, int idx, int time) {
        if (idx == satisfaction.length) {
            return 0;
        }

        int includeLikeTimeCoeff = time * satisfaction[idx] + solveUsingRec(satisfaction, idx + 1, time + 1);
        int excludeLikeTimeCoeff = solveUsingRec(satisfaction, idx + 1, time);
        return Math.max(includeLikeTimeCoeff, excludeLikeTimeCoeff);
    }

    public static int solveUsingMemo(int satisfaction[], int idx, int time, int dp[][]) {
        if (idx == satisfaction.length) {
            return 0;
        }

        if (dp[idx][time] != -1) {
            return dp[idx][time];
        }

        int includeLikeTimeCoeff = satisfaction[idx] * time + solveUsingMemo(satisfaction, idx + 1, time + 1, dp);
        int excludeLikeTimeCoeff = solveUsingMemo(satisfaction, idx + 1, time, dp);

        dp[idx][time] = Math.max(includeLikeTimeCoeff, excludeLikeTimeCoeff);
        return dp[idx][time];
    }

    public static int solveUsingTabulation(int[] satisfaction) {
        int dp[][] = new int[satisfaction.length + 1][satisfaction.length + 2];
        for (int idx = satisfaction.length - 1; idx >= 0; idx--) {
            for (int time = satisfaction.length; time >= 1; time--) {
                int includeLikeTimeCoeff = satisfaction[idx] * time + dp[idx + 1][time + 1];
                int excludeLikeTimeCoeff = dp[idx + 1][time];

                dp[idx][time] = Math.max(includeLikeTimeCoeff, excludeLikeTimeCoeff); 
            }
        }

        return dp[0][1];
    }

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int dp[][] = new int[satisfaction.length + 1][satisfaction.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveUsingTabulation(satisfaction);
    }

    public static void main(String[] args) {
        int satisfaction1[] = { -1, -8, 0, 5, -9 };
        System.out.println(maxSatisfaction(satisfaction1));
        int satisfaction2[] = { 4, 3, 2 };
        System.out.println(maxSatisfaction(satisfaction2));
        int satisfaction3[] = { -1, -4, -5 };
        System.out.println(maxSatisfaction(satisfaction3));
    }
}

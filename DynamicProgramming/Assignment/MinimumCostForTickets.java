import java.util.Arrays;

public class MinimumCostForTickets {
    public static int solveUsingRecursion(int days[], int costs[], int idx) {
        // base case
        if (idx >= days.length) {
            return 0;
        }

        // sol for a case
        // 1 Day pass taken
        int cost1 = costs[0] + solveUsingRecursion(days, costs, idx + 1);

        // 7 Day pass taken
        int passEndDay = days[idx] + 7 - 1;
        int j = idx;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost7 = costs[1] + solveUsingRecursion(days, costs, j);

        // 30 Day pass taken
        passEndDay = days[idx] + 30 - 1;
        j = idx;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost30 = costs[2] + solveUsingRecursion(days, costs, j);

        return Math.min(cost1, Math.min(cost7, cost30));
    }

    public static int solveUsingMemo(int days[], int costs[], int idx, int dp[]) {
        // base case
        if (idx >= days.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // sol for a case
        // 1 Day pass taken
        int cost1 = costs[0] + solveUsingMemo(days, costs, idx + 1, dp);

        // 7 Days pass taken
        int passEndDay = days[idx] + 7 - 1;
        int j = idx;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost7 = costs[1] + solveUsingMemo(days, costs, j, dp);

        // 30 Days pass taken
        passEndDay = days[idx] + 30 - 1;
        j = idx;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost30 = costs[2] + solveUsingMemo(days, costs, j, dp);

        dp[idx] = Math.min(cost1, Math.min(cost7, cost30));
        return dp[idx];
    }

    public static int solveUsingTabulation(int[] days, int[] costs) {
        int dp[] = new int[days.length + 1];

        for (int idx = days.length - 1; idx >= 0; idx--) {
            int cost1 = costs[0] + dp[idx + 1];

            int passEndDay = days[idx] + 7 - 1;
            int j = idx;
            while (j < days.length && days[j] <= passEndDay) {
                j++;
            }
            int cost7 = costs[1] + dp[j];
    
            passEndDay = days[idx] + 30 - 1;
            j = idx;
            while (j < days.length && days[j] <= passEndDay) {
                j++;
            }
            int cost30 = costs[2] + dp[j];
    
            dp[idx] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[0];
    }

    public static int mincostTickets(int[] days, int[] costs) {
        // return solveUsingRecursion(days, costs, 0);
        // int dp[] = new int[days.length];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(days, costs, 0, dp);
        return solveUsingTabulation(days, costs);
    }

    public static void main(String[] args) {
        int days1[] = { 1, 4, 6, 7, 8, 20 }, costs1[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days1, costs1));
        int days2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, costs2[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days2, costs2));
    }
}

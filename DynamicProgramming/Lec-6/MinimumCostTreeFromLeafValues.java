import java.util.*;

public class MinimumCostTreeFromLeafValues {
    public static int solveUsingRecursion(int[] arr, Map<Pair<Integer, Integer>, Integer> maxi, int s, int e) {
        // base case
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            // i is used here for partitioning
            ans = Math.min(ans, (maxi.get(new Pair<>(s, i)) * maxi.get(new Pair<>(i + 1, e))) + 
                               solveUsingRecursion(arr, maxi, s, i) + 
                               solveUsingRecursion(arr, maxi, i + 1, e));
        }
        return ans;
    }

    public static int solveUsingMem(int[] arr, Map<Pair<Integer, Integer>, Integer> maxi, int s, int e, int[][] dp) {
        // base case
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return 0;
        }
        if (dp[s][e] != -1) {
            return dp[s][e];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            // i is used here for partitioning
            ans = Math.min(ans, (maxi.get(new Pair<>(s, i)) * maxi.get(new Pair<>(i + 1, e))) + 
                               solveUsingMem(arr, maxi, s, i, dp) + 
                               solveUsingMem(arr, maxi, i + 1, e, dp));
        }
        dp[s][e] = ans;
        return dp[s][e];
    }

    public static int solveUsingTabulation(int[] arr, Map<Pair<Integer, Integer>, Integer> maxi) {
        int n = arr.length;
        int[][] dp = new int[n + 2][n + 1];

        for (int s_index = n; s_index >= 0; s_index--) {
            for (int e_index = 0; e_index <= n - 1; e_index++) {
                if (s_index >= e_index) {
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int i = s_index; i < e_index; i++) {
                    // i is used here for partitioning
                    ans = Math.min(ans, (maxi.get(new Pair<>(s_index, i)) * maxi.get(new Pair<>(i + 1, e_index))) + 
                                       dp[s_index][i] + dp[i + 1][e_index]);
                }
                dp[s_index][e_index] = ans;
            }
        }

        return dp[0][n - 1];
    }

    public static int mctFromLeafValues(int[] arr) {
        // pre-computation
        TreeMap<Pair<Integer, Integer>, Integer> maxi = new TreeMap<>(new customComparator());
        
        for (int i = 0; i < arr.length; i++) {
            maxi.put(new Pair<>(i, i), arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                maxi.put(new Pair<>(i, j), Math.max(arr[j], maxi.get(new Pair<>(i, j - 1))));
            }
        }
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveUsingTabulation(arr, maxi);
    }


    static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static class customComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            if (!p1.first.equals(p2.first)) {
                return p1.first - p2.first;
            }
            return p1.second - p2.second;
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 2, 4};
        System.out.println(mctFromLeafValues(arr));
    }
}

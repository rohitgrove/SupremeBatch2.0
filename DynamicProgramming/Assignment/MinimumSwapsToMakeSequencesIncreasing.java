import java.util.Arrays;

public class MinimumSwapsToMakeSequencesIncreasing {
    public static int solveUsingRecursion(int nums1[], int nums2[], int idx, int p1, int p2) {
        if (idx == nums1.length) {
            return 0;
        }

        int swap = Integer.MAX_VALUE, noswap = Integer.MAX_VALUE;
        // swap cond
        if (p1 < nums2[idx] && p2 < nums1[idx]) {
            swap = 1 + solveUsingRecursion(nums1, nums2, idx + 1, nums2[idx], nums1[idx]);
        }

        if (p1 < nums1[idx] && p2 < nums2[idx]) {
            noswap = solveUsingRecursion(nums1, nums2, idx + 1, nums1[idx], nums2[idx]);
        }

        return Math.min(swap, noswap);
    }

    public static int solveUsingMemo(int nums1[], int nums2[], int idx, int p1, int p2, int dp[][], int isSwap) {
        if (idx == nums1.length) {
            return 0;
        }

        if (dp[idx][isSwap] != -1) {
            return dp[idx][isSwap];
        }

        int swap = Integer.MAX_VALUE, noswap = Integer.MAX_VALUE;
        // swap cond
        if (p1 < nums2[idx] && p2 < nums1[idx]) {
            swap = 1 + solveUsingMemo(nums1, nums2, idx + 1, nums2[idx], nums1[idx], dp, 1);
        }

        if (p1 < nums1[idx] && p2 < nums2[idx]) {
            noswap = solveUsingMemo(nums1, nums2, idx + 1, nums1[idx], nums2[idx], dp, 0);
        }

        dp[idx][isSwap] = Math.min(swap, noswap);
        return dp[idx][isSwap];
    }

    public static int solveUsingTabluation(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length + 1][2];

        for (int idx = nums1.length - 1; idx >= 1; idx--) {
            for (int isSwap = 1; isSwap >= 0; isSwap--) {
                int p1 = nums1[idx - 1];
                int p2 = nums2[idx - 1];

                if (isSwap == 1) {
                    int temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
                int swap = Integer.MAX_VALUE, noswap = Integer.MAX_VALUE;
                // swap cond
                if (p1 < nums2[idx] && p2 < nums1[idx]) {
                    swap = 1 + dp[idx + 1][1];
                }

                if (p1 < nums1[idx] && p2 < nums2[idx]) {
                    noswap = dp[idx + 1][0];
                }

                dp[idx][isSwap] = Math.min(swap, noswap);
            }
        }

        return Math.min(1 + dp[1][1], dp[1][0]);
    }

    public static int solveUsingTabluationSO(int[] nums1, int[] nums2) {
        int next[] = new int[2];
        int curr[] = new int[2];

        for (int idx = nums1.length - 1; idx >= 1; idx--) {
            for (int isSwap = 1; isSwap >= 0; isSwap--) {
                int p1 = nums1[idx - 1];
                int p2 = nums2[idx - 1];

                if (isSwap == 1) {
                    int temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
                int swap = Integer.MAX_VALUE, noswap = Integer.MAX_VALUE;
                // swap cond
                if (p1 < nums2[idx] && p2 < nums1[idx]) {
                    swap = 1 + next[1];
                }

                if (p1 < nums1[idx] && p2 < nums2[idx]) {
                    noswap = next[0];
                }

                curr[isSwap] = Math.min(swap, noswap);
            }
            next = curr.clone();
        }

        return Math.min(1 + next[1], next[0]);
    }

    public static int minSwap(int[] nums1, int[] nums2) {
        // return solveUsingRecursion(nums1, nums2, 0, -1, -1);
        // int dp[][] = new int[nums1.length][2];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(nums1, nums2, 0, -1, -1, dp, 0);

        return solveUsingTabluationSO(nums1, nums2);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 5, 4 }, nums2[] = { 1, 2, 3, 7 };
        System.out.println(minSwap(nums1, nums2));
        int nums3[] = { 0, 3, 5, 8, 9 }, nums4[] = { 2, 1, 4, 6, 9 };
        System.out.println(minSwap(nums3, nums4));
    }
}
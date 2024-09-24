public class MinimumSwapsToMakeSequenceIncreasing {
    public static int solveUsingRec(int[] nums1, int[] nums2, int idx, int prev1, int prev2) {
        if (idx == nums1.length) {
            return 0;
        }

        int swap = Integer.MAX_VALUE, noSwap = Integer.MAX_VALUE;
        // no swap
        if (prev1 < nums1[idx] && prev2 < nums2[idx]) {
            noSwap = solveUsingRec(nums1, nums2, idx + 1, nums1[idx], nums2[idx]);
        }

        // swap count
        if (prev2 < nums1[idx] && prev1 < nums2[idx]) {
            swap = 1 + solveUsingRec(nums1, nums2, idx + 1, nums2[idx], nums1[idx]);
        }

        return Math.min(swap, noSwap);
    }

    public static int solveUsingMemo(int nums1[], int nums2[], int idx, int prev1, int prev2, int dp[][], int isSwap) {
        if (idx == nums1.length) {
            return 0;
        }

        if (dp[idx][isSwap] != -1) {
            return dp[idx][isSwap];
        }

        int swap = Integer.MAX_VALUE, noSwap = Integer.MAX_VALUE;

        if (prev1 < nums1[idx] && prev2 < nums2[idx]) {
            noSwap = solveUsingMemo(nums1, nums2, idx + 1, nums1[idx], nums2[idx], dp, 1);
        }

        if (prev1 < nums2[idx] && prev2 < nums1[idx]) {
            swap = 1 + solveUsingMemo(nums1, nums2, idx + 1, nums2[idx], nums1[idx], dp, 0);
        }

        return dp[idx][isSwap] = Math.min(swap, noSwap);
    }

    public static int solveUsingTabulation(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 1; index--) {
            for (int swapped = 1; swapped >= 0; swapped--) {
                int ans = Integer.MAX_VALUE;
                int prev1 = nums1[index - 1];
                int prev2 = nums2[index - 1];

                // catch
                if (swapped == 1) {
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }

                // noswap
                if (nums1[index] > prev1 && nums2[index] > prev2) {
                    ans = dp[index + 1][0];
                }

                // swap case
                if (nums1[index] > prev2 && nums2[index] > prev1) {
                    ans = Math.min(ans, 1 + dp[index + 1][1]);
                }
  
                dp[index][swapped] = ans;
            }
        }

        return dp[1][0];
    }

    public static int solveUsingTabulationSO(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int swap = 0;
        int noSwap = 0;
        int currSwap = 0;
        int currNoSwap = 0;

        for (int index = n - 1; index >= 1; index--) {
            for (int swapped = 1; swapped >= 0; swapped--) {
                int ans = Integer.MAX_VALUE;
                int prev1 = nums1[index - 1];
                int prev2 = nums2[index - 1];

                // catch
                if (swapped == 1) {
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }

                // no swap case
                if (nums1[index] > prev1 && nums2[index] > prev2) {
                    ans = noSwap;
                }

                // swap case
                if (nums1[index] > prev2 && nums2[index] > prev1) {
                    ans = Math.min(ans, 1 + swap);
                }

                if (swapped == 1) {
                    currSwap = ans;
                } else {
                    currNoSwap = ans;
                }
            }
            swap = currSwap;
            noSwap = currNoSwap;
        }

        return Math.min(swap, noSwap);
    }

    public static int[] insertAtBeginning(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        newArr[0] = value;
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        return newArr;
    }

    public static int minSwap(int[] nums1, int[] nums2) {
        // return solveUsingRec(nums1, nums2, 0, -1, -1);
        // int dp[][] = new int[nums1.length][2];
        // for (int[] row : dp) {
        // row[0] = -1;
        // row[1] = -1;
        // }

        // return solveUsingMemo(nums1, nums2, 0, -1, -1, dp, 0);
        nums1 = insertAtBeginning(nums1, -1);
        nums2 = insertAtBeginning(nums2, -1);

        return solveUsingTabulationSO(nums1, nums2);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 5, 4 }, nums2[] = { 1, 2, 3, 7 };
        System.out.println(minSwap(nums1, nums2));
    }
}

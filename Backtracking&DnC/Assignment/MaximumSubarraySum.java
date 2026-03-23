public class MaximumSubarraySum {
    public static int maxSumArrayHelper(int nums[], int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int maxLeftBorderSum = Integer.MIN_VALUE, maxRightBorderSum = Integer.MIN_VALUE;
        int mid = start + (end - start) / 2;

        int maxLeftSum = maxSumArrayHelper(nums, start, mid);
        int maxRightSum = maxSumArrayHelper(nums, mid + 1, end);

        // Max cross border sum
        int leftBorderSum = 0, rightBorderSum = 0;
        for (int i = mid; i >= start; i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        for (int i = mid + 1; i <= end; i++) {
            rightBorderSum += nums[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        int crossBorderSum = maxLeftBorderSum + maxRightBorderSum;
        return Math.max(maxLeftSum, Math.max(maxRightSum, crossBorderSum));
    }

    public static int maxSubArray(int[] nums) {
        return maxSumArrayHelper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int nums1[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums1));
        int nums2[] = { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums2));
    }
}

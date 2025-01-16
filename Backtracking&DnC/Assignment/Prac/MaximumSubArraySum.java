public class MaximumSubArraySum {
    public static int maxSubArrayHelper(int nums[], int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int maxLeftBoderSum = Integer.MIN_VALUE, maxRightBorderSum = Integer.MIN_VALUE;
        int mid = start + (end - start) / 2;
        int maxLeftSum = maxSubArrayHelper(nums, start, mid);
        int maxRightSum = maxSubArrayHelper(nums, mid + 1, end);

        int leftBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = mid; i >= start; i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > maxLeftBoderSum) {
                maxLeftBoderSum = leftBorderSum;
            }
        }

        for (int i = mid + 1; i <= end; i++) {
            rightBorderSum += nums[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        int crossBorderSum = maxLeftBoderSum + maxRightBorderSum;
        return Math.max(crossBorderSum, Math.max(maxLeftSum, maxRightSum));
    }

    public static int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int nums1[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums1));
        int nums2[] = { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums2));
    }

}
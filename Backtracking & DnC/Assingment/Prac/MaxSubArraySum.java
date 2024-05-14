public class MaxSubArraySum {
    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Maximum contiguous sum is " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }   
    
    public static int maxSubArrayHelper(int nums[], int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int maxLeftBorderSum = Integer.MIN_VALUE, maxRightBorderSum = Integer.MIN_VALUE;

        int mid = start + (end - start) / 2;
        int maxLeftSum = maxSubArrayHelper(nums, start, mid);
        int maxRightSum = maxSubArrayHelper(nums, mid + 1, end);

        int leftBorderSum = 0;
        for (int i = mid; i >= start; i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int rightBorderSum = 0;
        for (int i = mid + 1 ; i <= end; i++) {
            rightBorderSum += nums[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        int crossBorder = maxLeftBorderSum + maxRightBorderSum;
        return Math.max(Math.max(maxRightSum, maxLeftSum), crossBorder);
    }
}

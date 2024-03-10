public class MaximumAvgSubArray {
    public static double bruteForce(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = k - 1;
        while (j < nums.length) {
            int sum = 0;
            for (int y = i; y <= j; ++y) {
                sum += nums[y];
            }
            maxSum = Math.max(maxSum, sum);
            ++i;
            ++j;
        }

        double maxAvg = maxSum / (double) k;
        return maxAvg;
    }

    public static double slidingWindow(int[] nums, int k) {
        int j = k - 1;
        int i = 0;
        int sum = 0;
        for (int y = i; y <= j; y++) {
            sum += nums[y];
        }

        int maxSum = sum;
        j++;
        while (j < nums.length) {
            sum -= nums[i++];
            sum += nums[j++];
            maxSum = Math.max(maxSum, sum);
        }
        double maxAvg = maxSum / (double) k;
        return maxAvg;
    }

    public static double findMaxAverage(int nums[], int k) {
        return slidingWindow(nums, k);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 }, k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
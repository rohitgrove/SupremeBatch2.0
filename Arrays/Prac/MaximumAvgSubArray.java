public class MaximumAvgSubArray {
    public static double findMaxSubAvg(int nums[], int k) {
        return slidingWindow(nums, k);
    }

    public static double bruteForce(int nums[], int k) {
        int i = 0, j = k - 1;
        int maxSum = Integer.MIN_VALUE;
        while (j < nums.length) {
            int sum = 0;
            for (int y = i; y <= j; ++y) {
                sum += nums[y];
            }
            ++i;
            ++j;

            maxSum = Math.max(maxSum, sum);
        }

        double ans = maxSum / (double) k;
        return ans;
    }

    public static double slidingWindow(int nums[], int k) {
        int i = 0, j = k - 1;
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

    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 }, k = 4;
        System.out.println(findMaxSubAvg(nums, k));
    }
}
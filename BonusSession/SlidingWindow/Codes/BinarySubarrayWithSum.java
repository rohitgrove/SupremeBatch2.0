public class BinarySubarrayWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int s = 0;
        int e = 0;
        int sum = 0;
        int prefixZero = 0;
        int countZero = 0;

        while (e < nums.length) {
            sum = sum + nums[e];
            // minimise
            while (s < e && (sum > goal || nums[s] == 0)) {
                // ans
                if (nums[s] == 1) {
                    prefixZero = 0;
                } else {
                    prefixZero += 1;
                }
                // sum
                sum = sum - nums[s];
                // start
                s++;
            }
            // verification
            if (sum == goal) {
                countZero += prefixZero + 1;
            }
            e++;
        }

        return countZero;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1 }, goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}

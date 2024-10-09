public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int s = 0;
        int e = 0;
        int sum = 0;
        int prefixZero = 0;
        int count = 0;

        while (e < nums.length) {
            sum = sum + nums[e];
            // minimize
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
                count += prefixZero + 1;
            }
            e++;
        }

        return count;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 0, 1, 0, 1 }, goal1 = 2;
        System.out.println(numSubarraysWithSum(nums1, goal1));
        int nums2[] = { 0, 0, 0, 0, 0 }, goal2 = 0;
        System.out.println(numSubarraysWithSum(nums2, goal2));
    }
}

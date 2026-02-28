public class HouseRobber {
    public static int solve(int nums[], int idx) {
        if (idx >= nums.length) {
            return 0;
        }
    
    
        // sol for 1 case;
        int robAmt1 = nums[idx] + solve(nums, idx + 2);
        int robAmt2 = 0 + solve(nums, idx + 1);

        return Math.max(robAmt1, robAmt2);
    }

    public static int rob(int[] nums) {
        return solve(nums, 0);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
    }
}
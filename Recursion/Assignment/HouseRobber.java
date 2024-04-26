public class HouseRobber {
    public static int solve(int nums[], int index) {
        if (index >= nums.length) {
            return 0;
        }
        int robAmt1 = nums[index] + solve(nums, index + 2);
        int robAmt2 = 0 + solve(nums, index + 1);
        return Math.max(robAmt1, robAmt2);
    }

    public static int rob(int nums[]) {
        return solve(nums, 0);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
    }
}

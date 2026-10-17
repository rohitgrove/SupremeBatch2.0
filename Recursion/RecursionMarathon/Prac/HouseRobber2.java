public class HouseRobber2 {
    public static int solve(int nums[], int idx, int end) {
        if (idx > end) {
            return 0;
        }

        int inc = nums[idx] + solve(nums, idx + 2, end);
        int exc = 0 + solve(nums, idx + 1, end);
        return Math.max(inc, exc);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int option1 = solve(nums, 0, nums.length - 2);
        int option2 = solve(nums, 1, nums.length - 1);
        return Math.max(option1, option2);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 3, 2 };
        System.out.println(rob(nums1));
        int nums2[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums2));
    }
}

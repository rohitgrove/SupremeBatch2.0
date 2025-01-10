public class HouseRobber {
    public static int solve(int nums[], int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        // chori karlo -> ith index pr
        int option1 = nums[idx] + solve(nums, idx + 2);

        // chori mat karo -> ith index pr
        int option2 = solve(nums, idx + 1);
        return Math.max(option1, option2);
    }

    public static int rob(int[] nums) {
        int ans = solve(nums, 0);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
    }
}

public class HouseRobber2 {
    public static int solve(int nums[], int s, int e) {
        if (s > e) {
            return 0;
        }

        int option1 = nums[s] + solve(nums, s + 2, e);
        int option2 = solve(nums, s + 1, e);

        return Math.max(option1, option2);
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
        int nums3[] = { 1, 2, 3 };
        System.out.println(rob(nums3));
    }
}

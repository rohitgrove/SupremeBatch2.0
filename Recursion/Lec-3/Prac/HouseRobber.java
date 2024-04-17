public class HouseRobber {
    public static int solve(int nums[], int index) {
        if (index >= nums.length) {
            return 0;
        }

        int option1 = nums[index] + solve(nums, index + 2);
        int option2 = solve(nums, index + 1);
        return Math.max(option1, option2);
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

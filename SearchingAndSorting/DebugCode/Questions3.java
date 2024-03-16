public class Questions3 {
    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, ans = start;
        while (nums[start] > nums[end]) {
            int mid = (start + end) >>> 1;
            if (nums[mid] <= nums[start] && nums[mid] <= nums[end])
                end = mid;
            else if (nums[mid] >= nums[start] && nums[mid] >= nums[end])
                start = mid + 1;
            else
                return nums[mid];
            ans = start;
        }
        return nums[ans];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums)); // Output: 0
    }
}

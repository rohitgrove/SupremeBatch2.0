public class Solution4 {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] >= nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums));
        int nums2[] = { 10, 20, 50, 40, 30 };
        System.out.println(findPeakElement(nums2));
    }
}

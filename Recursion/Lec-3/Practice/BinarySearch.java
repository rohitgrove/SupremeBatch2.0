public class BinarySearch {
    public static int solve(int nums[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            return solve(nums, target, mid + 1, end);
        } else {
            return solve(nums, target, start, mid - 1);
        }
    }

    public static int search(int[] nums, int target) {
        return solve(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int nums1[] = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums1, 9));
        System.out.println(search(nums1, 2));
        int nums2[] = { 10, 20, 30, 40, 50, 60, 70 };
        System.out.println(search(nums2, 40));
    }
}

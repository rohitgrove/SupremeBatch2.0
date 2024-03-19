import java.util.Arrays;

public class KDiffPairs {
    public static int findPairs(int nums[], int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else if (binarySearch(nums, i, nums[i] + k)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean binarySearch(int nums[], int s, int target) {
        int start = s + 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 4, 1, 5 }, k1 = 2;
        System.out.println(findPairs(nums1, k1));
        int nums2[] = { 1, 2, 3, 4, 5 }, k2 = 1;
        System.out.println(findPairs(nums2, k2));
        int nums3[] = { 1, 3, 1, 5, 4 }, k3 = 0;
        System.out.println(findPairs(nums3, k3));
    }
}
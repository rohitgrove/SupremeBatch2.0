import java.util.Arrays;
import java.util.HashSet;

public class KDiffPairs {
    public static int twoPointerApproach(int nums[], int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        HashSet<String> ans = new HashSet<>();

        while (j < nums.length) {
            int diff = nums[j] - nums[i];
            if (i != j && diff == k) {
                ans.add(nums[i] + ", " + nums[j]);
                i++;
                j++;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }
        }

        return ans.size();
    }

    public static int bsApproach(int nums[], int k) {
        Arrays.sort(nums);
        HashSet<String> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (bs(nums, nums[i] + k, i + 1) != -1) {
                ans.add(nums[i] + ", " + nums[i] + k);
            }
        }

        return ans.size();
    }

    public static int bs(int nums[], int target, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findPairs(int[] nums, int k) {
        return bsApproach(nums, k);
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
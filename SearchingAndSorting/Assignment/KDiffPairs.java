import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairs {
    public static int findPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Map.Entry<Integer, Integer>> ans = new HashSet<>();

        int i = 0, j = 1;
        while (j < nums.length) {
            int diff = nums[j] - nums[i];
            if (diff == k) {
                ans.add(Map.entry(nums[i], nums[j]));
                ++i;
                ++j;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }
            if (i == j) {
                j++;
            }
        }

        return ans.size();
    }

    public static int findPairs2(int[] nums, int k) {  // tc: O(nlogn)
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i <= n - 2; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            if (binarySearch(i, n, nums, k + nums[i])) {
                ans++;
            }
        }
        return ans;
    }

    public static boolean binarySearch(int s, int n, int nums[], int target) {
        int start = s + 1;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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
        System.out.println(findPairs2(nums1, k1));
        int nums2[] = { 1, 2, 3, 4, 5 }, k2 = 1;
        System.out.println(findPairs2(nums2, k2));
        int nums3[] = { 1, 3, 1, 5, 4 }, k3 = 0;
        System.out.println(findPairs2(nums3, k3));
    }
}
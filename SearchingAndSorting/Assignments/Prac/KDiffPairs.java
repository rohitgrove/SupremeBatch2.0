import java.util.Arrays;
import java.util.HashSet;

public class KDiffPairs {
    public static int twoPointerApproach(int nums[], int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        HashSet<String> set = new HashSet<>();

        while (j < nums.length) {
            int diff = nums[j] - nums[i];
            if (i != j && diff == k) {
                set.add(nums[i] + ", " + nums[j]);
                i++;
                j++;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }
        }

        return set.size();
    }

    public static int binarySearchApproach(int nums[], int k) {
        Arrays.sort(nums);
        HashSet<String> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (bs(nums, i + 1, nums[i] + k) != -1) {
                ans.add(nums[i] + " " + nums[i] + k);
            }
        }
        
        return ans.size();
    }

    public static int bs(int nums[], int start, int target) {
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return -1;
    }

    public static int findPairs(int[] nums, int k) {
        return binarySearchApproach(nums, k);
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
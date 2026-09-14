import java.util.Arrays;
import java.util.HashSet;

public class KDiffPairs {
    public static int twoPointerApproach(int nums[], int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        HashSet<String> set = new HashSet<>();
        while (j < nums.length) {
            if (i != j && nums[j] - nums[i] == k) {
                set.add(nums[i] + ", " + nums[j]);
                i++;
                j++;
            } else if (nums[j] - nums[i] > k) {
                i++;
            } else {
                j++;
            }
        }

        return set.size();
    }

    public static int binarySearchApproach(int nums[], int k) {
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (bs(nums, nums[i] + k, i + 1) != -1) {
                set.add(nums[i] + "," + (nums[i] + k));
            }
        }

        return set.size();
    }

    public static int bs(int[] nums, int target, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int findPairs(int[] nums, int k) {
        return binarySearchApproach(nums, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 4, 1, 5 };
        System.out.println(findPairs(nums1, 2));
        int nums2[] = { 1, 2, 3, 4, 5 };
        System.out.println(findPairs(nums2, 1));
        int nums3[] = { 1, 3, 1, 5, 4 };
        System.out.println(findPairs(nums3, 0));
    }
}

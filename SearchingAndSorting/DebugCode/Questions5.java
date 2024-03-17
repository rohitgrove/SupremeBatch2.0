import java.util.ArrayList;
import java.util.List;

public class Questions5 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                ans.add(nums[i]);
            } else {
                int index = binarySearch(ans, nums[i]);
                ans.set(index, nums[i]);
            }
        }

        return ans.size();
    }

    private int binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == nums.size() - 1 && nums.get(left) < target) {
            left++;
        }

        return left;
    }

    public static void main(String[] args) {
        Questions5 lis = new Questions5();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("Length of LIS: " + lis.lengthOfLIS(nums)); // Output: 4
    }
}

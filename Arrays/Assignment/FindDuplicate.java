import java.util.Arrays;

public class FindDuplicate {
    public static int findDuplicate1(int[] nums) { // tc: nLogn because of Arrays.sort func
        Arrays.sort(nums);

        int ans = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }

    public static int findDuplicate2(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            // already visited
            if (nums[index] < 0) {
                ans = index;
                break;
            }

            // visited
            nums[index] *= -1;
        }
        return ans;
    }

    public static int findDuplicate3(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            swap(nums, 0, nums[0]);
        }

        return nums[0];
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate3(nums1));
        int nums2[] = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate3(nums2));
        int nums3[] = { 3, 3, 3, 3, 3 };
        System.out.println(findDuplicate3(nums3));
    }
}

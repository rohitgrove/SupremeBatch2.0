import java.util.Arrays;

public class FindDuplicate {
    public static int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                ans = index;
                break;
            }

            nums[index] *=  -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate2(nums1));
        int nums2[] = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate2(nums2));
        int nums3[] = { 3, 3, 3, 3, 3 };
        System.out.println(findDuplicate2(nums3));
    }
}

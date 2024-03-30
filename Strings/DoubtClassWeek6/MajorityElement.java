import java.util.Arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;
        return nums[mid];
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums2));
    }
}
public class RemoveDuplicatesFromSortedArr {
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;
        // Two pointers
        while (i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {
                j++;
                nums[j] = nums[i];
                i++;
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums1));
        int nums2[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums2));
    }
}

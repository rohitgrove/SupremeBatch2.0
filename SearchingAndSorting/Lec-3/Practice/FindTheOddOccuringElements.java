public class FindTheOddOccuringElements {
    public static int findOddOccuringElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (start == end) {
                return start;
            }

            if ((mid & 1) == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            }
            mid = start + (end - start) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 10, 2, 2, 5, 5, 2, 5, 5, 20, 20, 11, 11, 10, 10 };
        System.out.println(findOddOccuringElement(nums1));
        int nums2[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(findOddOccuringElement(nums2));
        int nums3[] = { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(findOddOccuringElement(nums3));
        int nums4[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(findOddOccuringElement(nums4));
        int nums5[] = { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(findOddOccuringElement(nums5));
    }
}

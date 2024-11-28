public class FindOddOccurs {
    public static int findOddOccuringElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (s == e) {
                return s;
            }

            if ((mid&1) == 1) {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    s = mid + 2;
                } else {
                    e = mid;
                }
            }

            mid = s + (e - s) / 2;
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
    }
}
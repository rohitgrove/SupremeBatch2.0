public class FindTheOddOccuringElements {
    public static int findOddOccuringElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            // single element
            if (s == e) {
                return s;
            }

            // mid check -> even or odd
            if ((mid&1) == 1) { // (mid&1) == 1 -> true-> odd number
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    // right me jao
                    s = mid + 1;
                } else {
                    // left me jao
                    e = mid - 1;
                }
            } else {
                // even
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    // right me jao
                    s = mid + 2;
                } else {
                    // ya toh main right pr khada hu
                    // ya toh main answer k upper khada hu
                    // that's why e = mid krra hu
                    // kyoki e = mid - 1; se ans lost ho sacta h
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

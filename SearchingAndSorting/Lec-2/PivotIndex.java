public class PivotIndex {
    public static int findPivotIndexAsBiggerElement(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            // corner case
            if (s == e) {
                // single element
                return s;
            }

            if (mid < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid >= 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[s] > nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static int findPivotIndexAsSmallerElement(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (s == e) {
                return s;
            }

            if (nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[s] > nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findPivotIndexAsBiggerElement(nums1) + " " + findPivotIndexAsSmallerElement(nums1));
        int nums2[] = { 12, 14, 16, 2, 4, 6, 8 };
        System.out.println(findPivotIndexAsBiggerElement(nums2) + " " + findPivotIndexAsSmallerElement(nums2));
    }
}
public class FindPivotElement {
    public static int pivotIndexOfBigestNum(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            // Corner case
            if (s == e) {
                // single element
                return s;
            }

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
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

    public static int pivotIndexOfSmallestNum(int nums[]) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            // corner case
            if (s == e) {
                return s;
            }

            int mid = s + (e - s) / 2;

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[s] > nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(pivotIndexOfBigestNum(nums1));
        System.out.println(pivotIndexOfSmallestNum(nums1));
        int nums2[] = { 16, 2, 4, 6, 8, 10 };
        System.out.println(pivotIndexOfBigestNum(nums2));
        System.out.println(pivotIndexOfSmallestNum(nums2));
    }
}
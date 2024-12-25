public class SearchInSortedAndRotated {
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

    public static int search(int[] nums, int target) {
        int pivot = findPivotIndexAsBiggerElement(nums);
        // search in A
        if (nums[0] <= target && target <= nums[pivot]) {
            return binarySearch(nums, target, 0, pivot);
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    public static int binarySearch(int nums[], int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
        int nums1[] = { 1, 3 }, target = 0;
        System.out.println(search(nums1, target));
    }
}

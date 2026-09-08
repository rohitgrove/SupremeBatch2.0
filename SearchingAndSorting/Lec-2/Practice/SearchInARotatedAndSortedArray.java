public class SearchInARotatedAndSortedArray {
    public static int findPivotIdx(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (s == e) {
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

    public static int binarySearch(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        return -1;
    }

    public static int search(int[] nums, int target) {
        int pivotIdx = findPivotIdx(nums);

        if (target >= nums[0] && target <= nums[pivotIdx]) {
            return binarySearch(nums, target, 0, pivotIdx);
        } else {
            return binarySearch(nums, target, pivotIdx + 1, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
    }
}

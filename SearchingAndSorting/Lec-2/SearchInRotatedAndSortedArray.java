public class SearchInRotatedAndSortedArray {
    public static int search(int[] nums, int target) {
        int pivotIdx = pivotIdx(nums);
        if (nums[0] <= target && target <= nums[pivotIdx]) {
            return binarySeach(nums, 0, pivotIdx, target);
        } else {
            return binarySeach(nums, pivotIdx + 1, nums.length - 1, target);
        }
    }

    public static int binarySeach(int nums[], int s, int e, int target) {
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static int pivotIdx(int nums[]) {
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

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 }, target = 0;
        System.out.println(search(nums, target));
    }
}

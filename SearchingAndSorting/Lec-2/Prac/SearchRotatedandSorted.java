public class SearchRotatedandSorted {
    public static int search(int nums[], int target) {
        int pivot = pivotIdx(nums);
        if (nums[pivot] > target && target > nums[0]) {
            return binarySearch(nums, 0, pivot, target);
        } else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }

    public static int binarySearch(int nums[], int s, int e, int target) {
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
            } else if (nums[mid] < nums[s]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 12, 14, 16, 2, 4, 6, 8, 10 }, target = 2;
        System.out.println(search(nums, target));
    }
}
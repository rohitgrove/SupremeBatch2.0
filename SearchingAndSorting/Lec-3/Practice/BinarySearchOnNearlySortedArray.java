public class BinarySearchOnNearlySortedArray {
    public static int nearlySortedArray(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (mid - 1 >= 0 && nums[mid - 1] == target) {
                return mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else if (mid + 1 < nums.length && nums[mid + 1] == target) {
                return mid + 1;
            }
            if (target > nums[mid]) {
                start = mid + 2;
            } else {
                end = mid - 2;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 20, 10, 30, 50, 40, 70, 60 };
        System.out.println(nearlySortedArray(nums, 20));
    }
}

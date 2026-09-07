public class BinarySearch {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

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

    public static void main(String[] args) {
        int nums[] = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));
        System.out.println(search(nums, 2));
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80 };
        System.out.println(search(arr, 61));
    }
}
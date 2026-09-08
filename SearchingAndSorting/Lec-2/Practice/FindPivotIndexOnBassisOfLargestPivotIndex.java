public class FindPivotIndexOnBassisOfLargestPivotIndex {
    public static int findPivotIdx(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (start == end) {
                return start;
            }
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 12, 14, 16, 2, 4, 6, 8, 10 };
        System.out.println(findPivotIdx(nums));
    }
}

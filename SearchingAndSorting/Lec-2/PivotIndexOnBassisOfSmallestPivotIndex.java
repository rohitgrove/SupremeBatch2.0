public class PivotIndexOnBassisOfSmallestPivotIndex {
    public static int findPivotIdx(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] <= nums[end]) {
                return start;
            }
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 12, 14, 16, 2, 4, 6, 8, 10 };
        System.out.println(findPivotIdx(nums));
    }
}

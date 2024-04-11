public class MissingNumber {
    public static int findMissingNum(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            int diff = nums[mid] - mid;
            if (diff == 1) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        if (ans + 1 == 0) {
            return nums.length + 1;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 9 };
        System.out.println(findMissingNum(nums));
    }
}

public class MissingNumber {
    public static int findMissingNum(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int diff = nums[mid] - mid;
            if (diff == 1) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
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

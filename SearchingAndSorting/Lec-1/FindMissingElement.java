public class FindMissingElement {
    public static int findMissingNum(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            int diff = nums[mid] - mid;

            if (diff == 1) {
                // right me jao
                s = mid + 1;
            } else {
                // ans store
                ans = mid;
                // left me jao
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        if (ans + 1 == 0) {
            return nums.length + 1;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(findMissingNum(nums));
    }
}

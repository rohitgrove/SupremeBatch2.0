public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s < e) {
            if (nums[mid] < nums[mid + 1]) {
                // A wali line me hu
                // peak right main exist krti hai
                s = mid + 1;
            } else {
                // yaa toh main B line pr hu
                // ya toh main peak element pr hu
                e = mid;
            }

            // mid update
            mid = s + (e - s) / 2;
        }
        return s;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums));
    }
}

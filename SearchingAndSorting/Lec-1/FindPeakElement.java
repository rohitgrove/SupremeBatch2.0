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

    public static int peakIndexInMountainArray(int[] nums) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                // It must be Peak
                ans = mid;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        System.out.println(peakIndexInMountainArray(nums));
        int nums2[] = { 10, 20, 50, 40, 30 };
        System.out.println(peakIndexInMountainArray(nums2));
    }
}

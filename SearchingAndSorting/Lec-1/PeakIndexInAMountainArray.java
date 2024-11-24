public class PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray1(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // A wali me hu
                // peak right me exist karti h
                s = mid + 1;
            } else {
                // yaa toh B line pr hu
                // ya toh main peak element pr hu
                e = mid;
            }
        }

        return s;
    }

    public static int peakIndexInMountainArray2(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) {
                e = mid - 1;
            } else {
                // It must be Peak
                ans = mid;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 20, 50, 40, 30 };
        System.out.println(peakIndexInMountainArray2(nums1));
        int nums2[] = { 10, 20, 30, 90, 70, 60, 50, 40 };
        System.out.println(peakIndexInMountainArray2(nums2));
    }
}

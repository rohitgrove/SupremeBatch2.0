public class MountainPeak {
    public static int peak(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(peak(nums1));
        int nums2[] = { 10, 20, 50, 40, 30 };
        System.out.println(peak(nums2));
    }
}
public class Pivotindex {
    public static int pivotIndex1(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int lSum = 0;
            int rSum = 0;
            for (int j = 0; j < i; j++) {
                lSum += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                rSum += nums[j];
            }

            if (lSum == rSum) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex2(int nums[]) {
        int lSum[] = new int[nums.length];
        int rSum[] = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            lSum[i] = lSum[i - 1] + nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rSum[i] = rSum[i + 2] + nums[i + 2];
        }

        for (int i = 0; i < nums.length; i++) {
            if (rSum[i] == lSum[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex1(nums1));
        int nums2[] = { 1, 2, 3 };
        System.out.println(pivotIndex1(nums2));
        int nums3[] = { 2, 1, -1 };
        System.out.println(pivotIndex1(nums3));
    }
}

public class PivotIndex {
    public static int bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // tc: O(n2) sc: O(1)
            int lSum = 0;
            int rSum = 0;

            // find lsum excluding current index
            for (int j = 0; j < i; j++) {
                lSum += nums[j];
            }

            // find rsum excluding current index
            for (int j = i + 1; j < nums.length; j++) {
                rSum += nums[j];
            }

            if (lSum == rSum) {
                return i;
            }
        }

        return -1;
    }

    public static int prefixSumApproach(int[] nums) {
        int lsum[] = new int[nums.length];
        int rsum[] = new int[nums.length];

        // calc lsum array
        for (int i = 1; i < nums.length; i++) {
            lsum[i] = lsum[i - 1] + nums[i - 1];
        }

        // calc rsum array
        for (int i = nums.length - 2; i >= 0; i--) {
            rsum[i] = rsum[i + 1] + nums[i + 1];
        }

        // check karte hai
        for (int i = 0; i < rsum.length; i++) {
            if (lsum[i] == rsum[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex(int[] nums) {
        return prefixSumApproach(nums);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(nums1));
        int nums2[] = { 1, 2, 3 };
        System.out.println(pivotIndex(nums2));
        int nums3[] = { 2, 1, -1 };
        System.out.println(pivotIndex(nums3));
    }
}

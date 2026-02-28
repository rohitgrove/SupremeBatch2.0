public class RotateArray {
    public static void rotateBruteForce(int[] nums, int rot) { // tc: O(n2)
        rot = rot % nums.length;

        if (rot < 0) {
            rot += nums.length;
        }

        for (int r = 1; r <= rot; r++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotateOptimizedApproach(int nums[], int rot) {
        rot = rot % nums.length;

        if (rot < 0) {
            rot += nums.length;
        }

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, rot - 1);
        reverse(nums, rot, nums.length - 1);
    }

    public static void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4, 5, 6, 7 }, k1 = 3;
        rotateOptimizedApproach(nums1, k1);
        printArr(nums1);

        int nums2[] = { -1, -100, 3, 99 }, k2 = 2;
        rotateBruteForce(nums2, k2);
        printArr(nums2);
    }
}

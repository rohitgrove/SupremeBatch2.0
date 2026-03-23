public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;   // last index of a
        int i = m - 1;         // pointer for a
        int j = n - 1;         // pointer for b

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[idx] = nums1[i];
                i--;
            } else {
                nums1[idx] = nums2[j];
                j--;
            }
            idx--;
        }

        while (j >= 0) {
            nums1[idx] = nums2[j];
            j--;
            idx--;
        }
    }

    public static void printArr(int nums[]) {
        for (int ele : nums) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 0, 0, 0 }, m1 = 3, nums2[] = { 2, 5, 6 }, n1 = 3;
        merge(nums1, m1, nums2, n1);
        printArr(nums1);
        int nums3[] = { 3, 5, 7, 0, 0, 0, 0 }, m2 = 3, nums4[] = { 1, 2, 6, 8 }, n2 = 4;
        merge(nums3, m2, nums4, n2);
        printArr(nums3);
    }
}

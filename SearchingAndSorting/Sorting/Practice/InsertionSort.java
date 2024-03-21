public class InsertionSort {
    public static void insertionSort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = curr;
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 4, 3, 2, 1 };
        insertionSort(nums1);
        printArr(nums1);
        int nums2[] = { 10, 1, 7, 6, 14, 9 };
        insertionSort(nums2);
        printArr(nums2);
        int nums3[] = { 34, 8, 64, 51, 32, 21 };
        insertionSort(nums3);
        printArr(nums3);
        int nums4[] = { 44, 33, 55, 22, 11 };
        insertionSort(nums4);
        printArr(nums4);
        int nums5[] = { 14, 12, 16, 6, 3, 10 };
        insertionSort(nums5);
        printArr(nums5);
    }
}

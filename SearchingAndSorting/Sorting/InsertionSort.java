public class InsertionSort {
    public static void insertionSort(int nums[]) {
        // i = 0, chhod deta hu
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than
            // key to one position ahead of theri current position
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = num; // insertion
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
        int nums5[] = { 34, 8, 64, 51, 32, 21 };
        insertionSort(nums5);
        printArr(nums5);
    }
}

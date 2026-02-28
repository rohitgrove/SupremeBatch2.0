public class InPlaceMergeSort {
    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        mergeInPlace(nums, start, mid, end);
    }

    public static void mergeInPlace(int[] nums, int start, int mid, int end) {
        int total_len = end - start + 1;
        int gap = (total_len / 2) + (total_len % 2);

        while (gap > 0) {
            int i = start, j = start + gap;
            while (j <= end) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                ++i;
                ++j;
            }
            gap = gap <= 1 ? 0 : (gap / 2) + (gap % 2);
        }
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 1, 6, 9, 4, 5 };
        printArr(sortArray(arr1));
        int arr2[] = { 3, 5, 1, 8, 2, 4 };
        printArr(sortArray(arr2));
        int arr3[] = { 3, 1, 4, 5, 2 };
        printArr(sortArray(arr3));
        int arr4[] = { 2, 4, 1, 6, 9 };
        printArr(sortArray(arr4));
        int arr5[] = { 4, 2, 5, 1, 3 };
        printArr(sortArray(arr5));
        int arr6[] = { 6, 2, 4, 1 };
        printArr(sortArray(arr6));
        int arr7[] = { 5, 3, 2, 6, 4 };
        printArr(sortArray(arr7));
        int arr8[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        printArr(sortArray(arr8));
        int[] arr9 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        printArr(sortArray(arr9));
        int arr10[] = { 8, 4, 2, 1 };
        printArr(sortArray(arr10));
    }
}

public class InPlaceMergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int nums[], int s, int e) {
        if (s >= e) {
            return;
        }

        int mid = s + (e - s) / 2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid + 1, e);
        merge(nums, s, e);
    }

    public static void merge(int nums[], int start, int end) {
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
                i++;
                j++;
            }

            gap = gap <= 1 ? 0 : (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 5, 2, 3, 1 };
        printArr(sortArray(nums));
        int arr[] = { 1, 2, 8, 3, 9, 4, 12, 7, 13, 10 };
        printArr(sortArray(arr));
    }
}

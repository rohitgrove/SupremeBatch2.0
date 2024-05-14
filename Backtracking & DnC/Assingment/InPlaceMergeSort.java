public class InPlaceMergeSort {
    public static void mergeInPlace(int[] nums, int start, int end) {
        int total_Len = end - start + 1;
        int gap = (total_Len / 2) + (total_Len % 2);
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

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        mergeInPlace(nums, start, end);
    }

    public static int[] sortAnArray(int nums[]) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 3, 9, 4, 12, 7, 13, 10 };
        int res[] = sortAnArray(arr);
        printArr(res);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

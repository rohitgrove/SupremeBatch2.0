public class SortAnArray {
    public static void merge(int[] nums, int[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }
        
        for (int p = start; p <= end; p++) {
            nums[p] = temp[p];
        }
    }

    public static void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);

        merge(nums, temp, start, mid, end);
    }

    public static int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int nums1[] = { 5, 2, 3, 1 };
        printArr(sortArray(nums1));
        int nums2[] = { 5, 1, 1, 2, 0, 0 };
        printArr(sortArray(nums2));
    }
}
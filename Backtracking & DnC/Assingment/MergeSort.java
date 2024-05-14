public class MergeSort {
    public static int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int[] mergeSort(int nums[], int s, int e) {
        if (s >= e) {
            return new int[] { nums[s] };
        }

        int mid = s + (e - s) / 2;

        int left[] = mergeSort(nums, s, mid);
        int right[] = mergeSort(nums, mid + 1, e);
        return merge(left, right);
    }

    public static int[] merge(int left[], int right[]) {
        int temp[] = new int[left.length + right.length];
        int leftIdx = 0, rightIdx = 0, tempIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                temp[tempIdx] = left[leftIdx];
                tempIdx++;
                leftIdx++;
            } else {
                temp[tempIdx] = right[rightIdx];
                tempIdx++;
                rightIdx++;
            }
        }

        while (leftIdx < left.length) {
            temp[tempIdx] = left[leftIdx];
            tempIdx++;
            leftIdx++;
        }

        while (rightIdx < right.length) {
            temp[tempIdx] = right[rightIdx];
            tempIdx++;
            rightIdx++;
        }

        return temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 5, 2, 3, 1 };
        printArr(nums);
        printArr(sortArray(nums));
        printArr(nums);
        int arr[] = { 1, 2, 8, 3, 9, 4, 12, 7, 13, 10 };
        printArr(sortArray(arr));
    }
}

public class SortAnArray {
    public static int[] mergeSort(int nums[], int start, int end) {
        if (start >= end) {
            return new int[] { nums[start] };
        }

        int mid = start + (end - start) / 2;
        int leftArr[] = mergeSort(nums, start, mid);
        int rightArr[] = mergeSort(nums, mid + 1, end);
        return merge(leftArr, rightArr);
    }

    public static int[] merge(int leftArr[], int rightArr[]) {
        int temp[] = new int[leftArr.length + rightArr.length];
        int leftIdx = 0, rightIdx = 0, tempIdx = 0;

        while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
            if (leftArr[leftIdx] < rightArr[rightIdx]) {
                temp[tempIdx++] = leftArr[leftIdx++];
            } else {
                temp[tempIdx++] = rightArr[rightIdx++];
            }
        }

        while (leftIdx < leftArr.length) {
            temp[tempIdx++] = leftArr[leftIdx++];
        }

        while (rightIdx < rightArr.length) {
            temp[tempIdx++] = rightArr[rightIdx++];
        }

        return temp;
    }

    public static int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
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
public class MergeTwoBinaryMaxHeap {
    public static void heapify(int arr[], int idx, int n) {
        while (idx < n) {
            int leftIdx = 2 * idx + 1;
            int rightIdx = 2 * idx + 2;

            int largestIdx = idx;
            if (leftIdx < n && arr[largestIdx] < arr[leftIdx]) {
                largestIdx = leftIdx;
            }

            if (rightIdx < n && arr[largestIdx] < arr[rightIdx]) {
                largestIdx = rightIdx;
            }

            if (largestIdx == idx) {
                break;
            } else {
                int temp = arr[idx];
                arr[idx] = arr[largestIdx];
                arr[largestIdx] = temp;
                idx = largestIdx;
            }
        }
    }

    public static int[] mergeHeaps(int[] arr1, int[] arr2, int n, int m) {
        // 1. merge two heap arrays
        int arr3[] = new int[n + m];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, n, arr2.length);

        // 2. let's heapify aaray arr3
        for (int i = (arr3.length / 2) - 1; i >= 0; i--) {
            heapify(arr3, i, arr3.length);
        }
        return arr3;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 5, 6, 2 },
                arr2[] = { 12, 7, 9 },
                n = arr1.length, m = arr2.length;
        printArr(mergeHeaps(arr1, arr2, n, m));
    }
}

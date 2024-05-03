public class QuickSortFromStart {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = partition(arr, start, end);

        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    public static int partition(int arr[], int start, int end) {
        int pivot = arr[start];
        int cnt = 0;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                cnt++;
            }
        }

        int pivotIdx = start + cnt;
        int temp = arr[start];
        arr[start] = arr[pivotIdx];
        arr[pivotIdx] = temp;

        int i = start, j = end;
        while (i < pivotIdx && pivotIdx < j) {
            while (arr[i] <= pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < pivotIdx && j > pivotIdx) {
                temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }

        return pivotIdx;
    }


    public static void main(String[] args) {
        int arr1[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        quickSort(arr1, 0, arr1.length - 1);
        printArr(arr1);
        int arr2[] = { 4, 1, 3, 9, 7 };
        quickSort(arr2, 0, arr2.length - 1);
        printArr(arr2);
        int arr3[] = { 2, 1, 6, 10, 4, 1, 3, 9, 7 };
        quickSort(arr3, 0, arr3.length - 1);
        printArr(arr3);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
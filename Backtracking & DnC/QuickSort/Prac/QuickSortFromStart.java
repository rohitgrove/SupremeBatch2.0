public class QuickSortFromStart {
    public static void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        
        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
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
        int temp = arr[pivotIdx];
        arr[pivotIdx] = arr[start];
        arr[start] = temp;

        int l = start, r = end;
        while (l < pivotIdx && r > pivotIdx) {
            while (arr[l] <= pivot) {
                l++;
            }

            while (arr[r] > pivot) {
                r--;
            }

            if (l < pivotIdx && r > pivotIdx) {
                temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
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
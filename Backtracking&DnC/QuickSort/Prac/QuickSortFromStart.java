public class QuickSortFromStart {
    public static void quickSort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int p = partition(arr, s, e);
        quickSort(arr, s, p - 1);
        quickSort(arr, p + 1, e);
    }

    public static int partition(int arr[], int s, int e) {
        int pivot = arr[s];
        int cnt = 0;
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] < pivot) {
                cnt++;
            }
        }

        int pivotIndex = s + cnt;

        int temp = arr[s];
        arr[s] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int l = s;
        int h = e;

        while (l < pivotIndex && pivotIndex < h) {
            while (arr[l] <= pivot) {
                l++;
            }

            while (arr[h] > pivot) {
                h--;
            }

            if (l < pivotIndex && pivotIndex < h) {
                temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
                l++;
                h--;
            }
        }

        return pivotIndex;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 5, 1, 8, 2, 4 };
        quickSort(arr1, 0, arr1.length - 1);
        printArr(arr1);
        int arr2[] = { 3, 1, 4, 5, 2 };
        quickSort(arr2, 0, arr2.length - 1);
        printArr(arr2);
        int arr3[] = { 2, 4, 1, 6, 9 };
        quickSort(arr3, 0, arr3.length - 1);
        printArr(arr3);
        int arr4[] = { 4, 2, 5, 1, 3 };
        quickSort(arr4, 0, arr4.length - 1);
        int arr5[] = { 6, 2, 4, 1 };
        quickSort(arr5, 0, arr5.length - 1);
        printArr(arr5);
        int arr6[] = { 5, 3, 2, 6, 4 };
        quickSort(arr6, 0, arr6.length - 1);
        printArr(arr6);
        int arr7[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        quickSort(arr7, 0, arr7.length - 1);
        printArr(arr7);
        int[] arr8 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        quickSort(arr8, 0, arr8.length - 1);
        printArr(arr8);
    }
}
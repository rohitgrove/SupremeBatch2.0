public class QuickSortFromMiddle {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start + (end - start) / 2];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }

        return start;
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

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

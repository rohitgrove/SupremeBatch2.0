public class QuickSortPivotFromEnd {
    public static void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int arr[], int start, int end) {
        int pivot = end;
        int i = start - 1;
        int j = start;

        while (j < pivot) {
            if (arr[j] < arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;
        return i;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        quickSort(arr1, 0, arr1.length - 1);
        printArr(arr1);
        int[] arr2 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        quickSort(arr2, 0, arr2.length - 1);
        printArr(arr2);
    }
}
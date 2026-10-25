public class MergeSort {
    public static void mergeSort(int arr[], int s, int e, int temp[]) {
        if (s >= e) {
            return;
        }

        int mid = s + (e - s) / 2;

        mergeSort(arr, s, mid, temp);
        mergeSort(arr, mid + 1, e, temp);
        merge(arr, s, mid, e, temp);
    }

    public static void merge(int arr[], int s, int mid, int e, int temp[]) {
        int idx1 = s;
        int idx2 = mid + 1;
        int idx3 = s;

        while (idx1 <= mid && idx2 <= e) {
            if (arr[idx1] < arr[idx2]) {
                temp[idx3] = arr[idx1];
                idx1++;
                idx3++;
            } else {
                temp[idx3] = arr[idx2];
                idx2++;
                idx3++;
            }
        }

        while (idx1 <= mid) {
            temp[idx3] = arr[idx1];
            idx1++;
            idx3++;
        }

        while (idx2 <= e) {
            temp[idx3] = arr[idx2];
            idx2++;
            idx3++;
        }

        for (int i = s; i <= e; i++) {
            arr[i] = temp[i];
        }
    }

    public static void sortArray(int arr[]) {
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 5, 1, 8, 2, 4 };
        sortArray(arr1);
        printArr(arr1);
        int arr2[] = { 3, 1, 4, 5, 2 };
        sortArray(arr2);
        printArr(arr2);
        int arr3[] = { 2, 4, 1, 6, 9 };
        sortArray(arr3);
        printArr(arr3);
        int arr4[] = { 4, 2, 5, 1, 3 };
        sortArray(arr4);
        printArr(arr4);
        int arr5[] = { 6, 2, 4, 1 };
        sortArray(arr5);
        printArr(arr5);
        int arr6[] = { 5, 3, 2, 6, 4 };
        sortArray(arr6);
        printArr(arr6);
        int arr7[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        sortArray(arr7);
        printArr(arr7);
        int[] arr8 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        sortArray(arr8);
        printArr(arr8);
        int arr9[] = { 2, 1, 6, 9, 4, 5 };
        sortArray(arr9);
        printArr(arr9);
    }
}
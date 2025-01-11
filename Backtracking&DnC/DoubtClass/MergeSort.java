public class MergeSort {
    public static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1;
        // first array = start -> mid
        // second array = mid + 1 -> end
        // merged array => start -> end
        int k = start;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // handle remaining elments in case of diff array size
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // let's copy merged data
        while (start <= end) {
            arr[start] = temp[start];
            start++;
        }
    }

    public static void mergeSort(int[] arr, int temp[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        // divide
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);

        // conqour
        merge(arr, temp, start, mid, end);
    }

    public static void sortArray(int arr[]) {
        int temp[] = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
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
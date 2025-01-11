public class QuickSortFromStart {
    public static void quickSort(int[] arr, int s, int e) {
        // base case
        if (s >= e) {
            return;
        }

        // partition karenge
        int p = partition(arr, s, e);

        // left part sort karo
        quickSort(arr, s, p - 1);

        // right part sort karo
        quickSort(arr, p + 1, e);
    }

    public static int partition(int[] arr, int s, int e) {
        //step1: chooose pivotelement
        int pivot = arr[s];

        //step2: find right position for pivot Element and place it there
        int cnt = 0;
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] <= pivot) {
                cnt++;
            }
        }

        //jab main loop se bahar hua, toh mere paas pivot ki right position ka index ready h
        int pivotIndex = s + cnt;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[s];
        arr[s] = temp;

        //Step3: left me chote and right me bade daal doo
        int i = s, j = e;

        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
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
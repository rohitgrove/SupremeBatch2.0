public class InsertionSprt {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > num) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = num;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 5, 4, 3, 2, 1 };
        insertionSort(arr1);
        printArr(arr1);
        int arr2[] = { 44, 33, 55, 22, 11 };
        insertionSort(arr2);
        printArr(arr2);
        int arr3[] = { 5, 3, 0, -1, 33, 56, 4 };
        insertionSort(arr3);
        printArr(arr3);
        int arr4[] = { 10, 1, 7, 6, 14, 9 };
        insertionSort(arr4);
        printArr(arr4);
    }
}
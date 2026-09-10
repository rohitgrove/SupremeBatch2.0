public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
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
        selectionSort(arr1);
        printArr(arr1);
        int arr2[] = { 44, 33, 55, 22, 11 };
        selectionSort(arr2);
        printArr(arr2);
        int arr3[] = { 5, 3, 0, -1, 33, 56, 4 };
        selectionSort(arr3);
        printArr(arr3);
    }
}

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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
        bubbleSort(arr1);
        printArr(arr1);
        int arr2[] = { 44, 33, 55, 22, 11 };
        bubbleSort(arr2);
        printArr(arr2);
        int arr3[] = { 5, 3, 0, -1, 33, 56, 4 };
        bubbleSort(arr3);
        printArr(arr3);
    }
}
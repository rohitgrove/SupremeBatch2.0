public class HeapSort {
    public static void heapify(int arr[], int n, int index) {
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        int largestKaIndex = index;

        if (leftIndex <= n && arr[leftIndex] > arr[largestKaIndex]) {
            largestKaIndex = leftIndex;
        }
        if (rightIndex <= n && arr[rightIndex] > arr[largestKaIndex]) {
            largestKaIndex = rightIndex;
        }

        if (index != largestKaIndex) {
            int temp = arr[index];
            arr[index] = arr[largestKaIndex];
            arr[largestKaIndex] = temp;
            index = largestKaIndex;
            heapify(arr, n, index);
        }
    }

    public static void buildHeap(int arr[], int n) {
        for (int index = n / 2; index > 0; index--) {
            heapify(arr, n, index);
        }
    }

    public static void heapSort(int arr[], int n) {
        while (n != 1) {
            int temp = arr[1];
            arr[1] = arr[n];
            arr[n] = temp;
            n--;
            heapify(arr, n, 1);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { -1, 5, 10, 15, 20, 25, 12 };
        System.out.println("Before Sort: ");
        printArr(arr);
        buildHeap(arr, arr.length - 1);
        heapSort(arr, arr.length - 1);
        System.out.println("After Sort: ");
        printArr(arr);
    }
}

public class BuildMinHeap {
    public static void heapify(int[] arr, int n, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int smallestKaIndex = index;

        if (leftIndex <= n && arr[leftIndex] < arr[smallestKaIndex]) {
            smallestKaIndex = leftIndex;
        }

        if (rightIndex <= n && arr[rightIndex] < arr[smallestKaIndex]) {
            smallestKaIndex = rightIndex;
        }

        if (index != smallestKaIndex) {
            int temp = arr[index];
            arr[index] = arr[smallestKaIndex];
            arr[smallestKaIndex] = temp;

            index = smallestKaIndex;
            heapify(arr, n, index);
        }
    }

    public static void buildHeap(int arr[], int n) {
        for (int index = n / 2; index >= 0; index--) {
            heapify(arr, n, index);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, 15, 20, 25, 12 };
        System.out.println("Before heapify: ");
        printArr(arr);
        buildHeap(arr, arr.length - 1);
        System.out.println("After heapify: ");
        printArr(arr);
    }
}
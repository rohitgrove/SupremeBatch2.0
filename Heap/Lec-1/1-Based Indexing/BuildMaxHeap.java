public class BuildMaxHeap {
    public static void heapify(int[] arr, int n, int index) {
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        int largestKaIndex = index;

        // teno me se max lao
        if (leftIndex <= n && arr[leftIndex] > arr[largestKaIndex]) {
            largestKaIndex = leftIndex;
        }
        if (rightIndex <= n && arr[rightIndex] > arr[largestKaIndex]) {
            largestKaIndex = rightIndex;
        }
        // after these 2 conditions largestKaIndex will be pointing towards largest
        // elemnt among 3
        if (index != largestKaIndex) {
            int temp = arr[index];
            arr[index] = arr[largestKaIndex];
            arr[largestKaIndex] = temp;
            // ab recursion sambhal lega
            index = largestKaIndex;
            heapify(arr, n, index);
        }
    }

    public static void buildHeap(int arr[], int n) {
        for (int index = n / 2; index > 0; index--) {
            heapify(arr, n, index);
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
        System.out.println("Before heapify: ");
        printArr(arr);
        buildHeap(arr, arr.length - 1);
        System.out.println("After heapify: ");
        printArr(arr);
    }
}
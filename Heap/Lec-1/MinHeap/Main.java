public class Main {
    public static void main(String[] args) {
        Heap h = new Heap(20);
        // insertion
        // h.insert(10);
        // h.insert(20);
        // h.insert(5);
        // h.insert(11);
        // h.insert(6);

        // h.printHeap();

        // System.out.println("answer: " + h.delete());

        // h.printHeap();

        int arr[] = { -1, 12, 25, 20, 15, 10, 5 };
        h.buildHeap(arr, arr.length - 1);
        printHeap(arr, arr.length - 1);
        h.heapSort(arr, arr.length - 1);
        printHeap(arr, arr.length - 1);
    }

    public static void printHeap(int arr[], int size) {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

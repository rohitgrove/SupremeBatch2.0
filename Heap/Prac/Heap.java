public class Heap {
    int arr[];
    int size;
    int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap Overflow");
            return;
        }

        size++;
        int index = size;
        arr[index] = val;

        while (index > 1) {
            int parentIndex = index / 2;

            if (arr[parentIndex] < arr[index]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];
                arr[index] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int delete() {
        int answer = arr[1];

        arr[1] = arr[size];
        size--;

        int index = 1;
        while (index < size) {
            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            int largestIndex = index;
            if (leftIndex <= size && arr[largestIndex] < arr[leftIndex]) {
                largestIndex = leftIndex;
            }

            if (rightIndex <= size && arr[largestIndex] < arr[rightIndex]) {
                largestIndex = rightIndex; 
            }

            if (largestIndex == index) {
                break;
            } else {
                int temp = arr[index];
                arr[index] = arr[largestIndex];
                arr[largestIndex] = temp;
                index = largestIndex;
            }
        }

        return answer;
    }

    public void heapify(int arr[], int n, int index) {
        int leftIdx = 2 * index;
        int rightIdx = 2 * index + 1;
        int largest = index;

        if (largest <= n && arr[largest] < arr[leftIdx]) {
            largest = leftIdx;
        }

        if (largest <= n && arr[largest] < arr[rightIdx]) {
            largest = rightIdx;
        }

        if (index != largest) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            
            index = largest;
            heapify(arr, n, index);
        }
    }

    public void buildHeap(int arr[], int n) {
        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        }
    }
}
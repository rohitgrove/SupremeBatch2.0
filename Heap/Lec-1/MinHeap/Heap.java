public class Heap {
    public int arr[];
    public int capacity;
    int size;

    public Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        if (size == capacity) {
            throw new RuntimeException("Heap Overflow");
        }

        size++;
        int index = size;
        arr[index] = val;

        while (index > 1) {
            int parentIdx = index / 2;
            if (arr[parentIdx] > arr[index]) {
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[index];
                arr[index] = temp;
                index = parentIdx;
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
            int leftIndex = index * 2;
            int rightIndex = index * 2 + 1;

            int smallestIndex = index;

            if (leftIndex <= size && arr[smallestIndex] > arr[leftIndex]) {
                smallestIndex = leftIndex;
            }

            if (rightIndex <= size && arr[smallestIndex] > arr[rightIndex]) {
                smallestIndex = rightIndex;
            }

            if (index == smallestIndex) {
                break;
            } else {
                int temp = arr[index];
                arr[index] = arr[smallestIndex];
                arr[smallestIndex] = temp;
                index = smallestIndex;
            }
        }

        return answer;
    }

    public void heapify(int arr[], int n, int index) {
        int leftIndex = index * 2;
        int rightIndex = index * 2 + 1;

        int smallestIndex = index;

        if (leftIndex <= n && arr[smallestIndex] > arr[leftIndex]) {
            smallestIndex = leftIndex;
        }

        if (rightIndex <= n && arr[smallestIndex] > arr[rightIndex]) {
            smallestIndex = rightIndex;
        }

        if (index != smallestIndex) {
            int temp = arr[index];
            arr[index] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            heapify(arr, n, smallestIndex);
        }
    }

    public void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        }        
    }

    public void heapSort(int arr[], int n) {
        while (n != 1) {
            int temp = arr[1];
            arr[1] = arr[n];
            arr[n] = temp;
            n--;
            heapify(arr, n, 1);
        }
    }
}

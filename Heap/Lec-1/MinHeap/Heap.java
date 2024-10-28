public class Heap {
    public int arr[];
    public int size;
    int capacity;

    public Heap(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void insert(int val) { // t.c O(logn)
        if (size == capacity) {
            System.out.println("Heap OverFlow");
            return;
        }
        // size increase kar jayega
        size++;
        int index = size;
        arr[index] = val;

        // take the value to its correct position
        while (index > 1) {
            int parentIndex = index / 2;
            if (arr[index] < arr[parentIndex]) {
                int temp = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = temp;
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

    public int delete() { // t.c O(logn)
        int answer = arr[1];
        // replacement
        arr[1] = arr[size];
        // last element ko delete karo uski orignal position se
        size--;

        int index = 1;
        while (index < size) {
            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            // find out karna hai, sabse chota kaun hai
            int smallestIndex = index;
            // check karo left child
            if (leftIndex <= size && arr[smallestIndex] > arr[leftIndex]) {
                smallestIndex = leftIndex;
            }

            // check karo right child
            if (rightIndex <= size && arr[smallestIndex] > arr[rightIndex]) {
                smallestIndex = rightIndex;
            }

            // no change
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
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        int smallestIndex = index;

        // teno me se min lao
        if (leftIndex<= n && arr[smallestIndex] > arr[leftIndex]) {
            smallestIndex = leftIndex;
        }

        if (rightIndex <= n && arr[smallestIndex] > arr[rightIndex]) {
            smallestIndex = rightIndex;
        }

        // after these 2 conditions smallestIndex will be pointing towrds smallest
        // element among 3
        if (index != smallestIndex) {
            int temp = arr[index];
            arr[index] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            // abb recursion sumbhal lega
            index = smallestIndex;
            heapify(arr, n, index);
        }
    }

    public void buildHeap(int arr[], int n) { // O(n)
        for (int index = n / 2; index > 0; index--) {
            heapify(arr, n, index);
        }
    }

    public void heapSort(int arr[], int n) { // O(nlogn)
        while (n != 1) {
            int temp = arr[1];
            arr[1] = arr[n];
            arr[n] = temp;
            n--;
            heapify(arr, n, 1);
        }
    }
}
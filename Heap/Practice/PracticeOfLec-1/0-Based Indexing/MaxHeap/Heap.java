public class Heap {
    public int arr[];
    public int capacity;
    public int size;

    public Heap(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int val) {
        if (size == capacity) {
            throw new RuntimeException("Heap Overflow");
        }
        int index = size;
        arr[index] = val;
        size++;

        while (index > 0) {
            int parrentIndex = (index - 1) / 2;
            if (arr[index] > arr[parrentIndex]) {
                int temp = arr[index];
                arr[index] = arr[parrentIndex];
                arr[parrentIndex] = temp;
                index = parrentIndex;
            } else {
                break;
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int deleteFromHeap() {
        if (size == 0) {
            throw new RuntimeException("Heap Underflow");
        }
        int answer = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = 0;
        size--;

        int index = 0;
        while (index < size) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;

            int largestIndex = index;
            if (leftIndex < size && arr[largestIndex] < arr[leftIndex]) {
                largestIndex = leftIndex;
            }

            if (rightIndex < size && arr[largestIndex] < arr[rightIndex]) {
                largestIndex = rightIndex;
            }

            if (index == largestIndex) {
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
}
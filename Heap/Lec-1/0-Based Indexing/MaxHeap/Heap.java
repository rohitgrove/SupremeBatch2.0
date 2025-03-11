public class Heap {
    public int arr[];
    public int capacity;
    public int size;

    public Heap(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        // size = current number of element in heap
        this.size = 0;
    }

    public void insert(int val) { // tc: O(logn)
        if (size == capacity) {
            throw new RuntimeException("Heap Overflow");
        }
        // size increase kar jayega
        size++;
        int index = size - 1;
        arr[index] = val;

        // take the val to its correct postion
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
        // replacement
        arr[0] = arr[size - 1];
        // last element ko delete uski original position
        arr[size - 1] = 0;
        size--;

        int index = 0;
        while (index < size) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;

            // find out karna h, sabse bada kon
            int largestIndex = index;
            // check left child
            if (leftIndex <= size && arr[largestIndex] < arr[leftIndex]) {
                largestIndex = leftIndex;
            }

            // check right child
            if (rightIndex <= size && arr[largestIndex] < arr[rightIndex]) {
                largestIndex = rightIndex;
            }

            // no change
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
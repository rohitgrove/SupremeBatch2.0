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

        size++;
        int index = size;
        arr[index] = val;

        while (index > 1) {
            int parrentIndex = index / 2;
            if (arr[index] < arr[parrentIndex]) {
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
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int deleteFromHeap() {
        int answer = arr[1];
        arr[1] = arr[size];
        arr[size--] = 0;

        int index = 1;
        while (index < size) {
            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            int smallestKaIndex = index;
            if (leftIndex <= size && arr[smallestKaIndex] > arr[leftIndex]) {
                smallestKaIndex = leftIndex;
            }

            if (rightIndex <= size && arr[smallestKaIndex] > arr[rightIndex]) {
                smallestKaIndex = rightIndex;
            }

            if (index == smallestKaIndex) {
                break;
            } else {
                int temp = arr[index];
                arr[index] = arr[smallestKaIndex];
                arr[smallestKaIndex] = temp;
                index = smallestKaIndex;
            }
        }

        return answer;
    }
}
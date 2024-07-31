public class CircularQueue {
    public int arr[];
    public int front, rear, size;

    public CircularQueue(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void add(int val) {
        // overflow
        if ((front == 0 && rear == size - 1) || (rear == front - 1)) {
            throw new RuntimeException("Overflow");
        } else if (front == -1 && rear == -1) {
            // empty case -> first elemeant
            front++;
            rear++;
            arr[rear] = val;
        } else if (rear == size - 1 && front != 0) {
            // circular nature
            rear = 0;
            arr[rear] = val;
        } else {
            // normal flow
            rear++;
            arr[rear] = val;
        }
    }

    public int poll() {
        // underflow
        if (front == -1 && rear == -1) {
            throw new RuntimeException("underflow");
        } else if (rear == front) {
            // single element case
            int temp = arr[front];
            arr[front] = -1;
            front = -1;
            rear = -1;
            return temp;
        } else if (front == size - 1) {
            // circular flow
            int temp = arr[front];
            arr[front] = -1;
            front = 0;
            return temp;
        } else {
            // normal flow
            int temp = arr[front];
            arr[front] = -1;
            front++;
            return temp;
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

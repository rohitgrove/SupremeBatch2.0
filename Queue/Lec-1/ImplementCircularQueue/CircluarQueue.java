public class CircluarQueue {
    public int arr[];
    public int size;
    public int front;
    public int rear;

    public CircluarQueue(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void offer(int val) {
        // overflow
        // emptyCase
        // circular nature
        // normal flow
        if ((front == 0 && rear == size - 1) || (rear == (front - 1))) {
            throw new RuntimeException("CircluarQueue Overflow");
        } else if (isEmpty()) {
            front++;
            rear++;
            arr[rear] = val;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            arr[rear] = val;
        } else {
            rear++;
            arr[rear] = val;
        }
    }

    public void pop() {
        // underflow
        // singleElement
        // circular nature
        // normal flow
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        } else if (front == rear) {
            arr[front] = -1;
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            arr[front] = -1;
            front = 0;
        } else {
            arr[front] = -1;
            front++;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return (rear - front + 1);
        }
    }

    public void print() {
        System.out.println("Printing Queue");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class Deque {
    public int arr[];
    public int size;
    public int front;
    public int rear;

    public Deque(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void offerLast(int val) {
        // OverFlow
        // empty case
        // normal flow
        if ((front == 0 && rear == size - 1) || (rear == (front - 1))) {
            throw new RuntimeException("CircluarDQueue Overflow");
        } else if (front == -1 && rear == -1) {
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

    public void offerFirst(int val) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1))) {
            throw new RuntimeException("CircluarDQueue Overflow");
        } else if (front == -1 && rear == -1) {
            front++;
            rear++;
            arr[front] = val;
        } else if (front == 0 && rear != size - 1) {
            front = size - 1;
            arr[front] = val;
        } else {
            front--;
            arr[front] = val;
        }
    }

    public void pollFirst() {
        if (front == -1 && rear == -1) {
            throw new RuntimeException("Queue Underflow");
        } else if (front == size - 1) {
            // single element
            arr[front] = -1;
            front = 0;
        } else {
            arr[front] = -1;
            front++;
        }
    }

    public void pollLast() {
        // underflow
        // single element
        // normal flow
        if (front == -1 && rear == -1) {
            throw new RuntimeException("Queue Underflow");
        } else if (front == rear) {
            arr[front] = -1;
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            arr[front] = -1;
            front = 0;
        } else if (rear == 0) {
            arr[rear] = -1;
            rear = size - 1;
        } else {
            arr[front] = -1;
            front++;
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
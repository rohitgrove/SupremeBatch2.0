public class MyCircularQueue {
    public int arr[], size, front, rear;

    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            front++;
            rear++;
            arr[rear] = value;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            arr[rear] = value;
        } else {
            rear++;
            arr[rear] = value;
        }

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
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

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear == front - 1);
    }
}

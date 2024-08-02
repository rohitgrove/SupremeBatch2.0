public class MyCircularDeque {
    public int size, front, rear, arr[];

    public MyCircularDeque(int k) {
        size = k;
        front = rear = -1;
        arr = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            front++;
            rear++;
            arr[front] = value;
        } else if (front == 0 && rear != size - 1) {
            front = size - 1;
            arr[front] = value;
        } else {
            front--;
            arr[front] = value;
        }

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            front++;
            rear++;
            arr[rear] = value;
        } else if (front != 0 && rear == size - 1) {
            rear = 0;
            arr[rear] = value;
        } else {
            rear++;
            arr[rear] = value;
        }

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else if (front == rear) {
            arr[front] = -1;
            front = rear = -1;
        } else if (front == size - 1) {
            arr[front] = -1;
            front = 0;
        } else {
            arr[front] = -1;
            front++;
        }

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else if (front == rear) {
            arr[rear] = -1;
            front = rear = -1;
        } else if (rear == 0) {
            arr[rear] = -1;
            rear = size - 1;
        } else {
            arr[rear] = -1;
            rear--;
        }

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[front];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[rear];
        }
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear == front - 1);
    }
}

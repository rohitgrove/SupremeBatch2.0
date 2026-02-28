public class Queue {
    public int arr[];
    public int size;
    public int front;
    public int rear;

    public Queue(int size) {
        arr = new int[size];
        this.size = size;
        rear = -1;
        front = -1;
    }

    public void offer(int val) {
        // check full
        if (rear == size - 1) {
            throw new RuntimeException("Queue Overflow");
        } else if (isEmpty()) {
            // empty case
            front++;
            rear++;
            arr[rear] = val;
        } else {
            // not full
            rear++;
            arr[rear] = val;
        }
    }

    public void pop() {
        // underflow
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        } else if (front == rear) {
            // empty case
            arr[front] = -1;
            front = -1;
            rear = -1;
        } else {
            // normal case
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

    public int getFront() {
        if (front == -1) {
            throw new RuntimeException("no elemenet is queue, cannot give front element");
        }
        return arr[front];
    }

    public int getRear() {
        if (rear == -1) {
            throw new RuntimeException("no elemenet is queue, cannot give rear element");
        }
        return arr[rear];
    }

    public void print() {
        System.out.println("Printing queue");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
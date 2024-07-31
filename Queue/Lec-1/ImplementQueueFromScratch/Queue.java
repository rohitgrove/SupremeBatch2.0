public class Queue {
    public int arr[];   
    public int size;   
    public int front;   
    public int rear;
    
    public Queue(int size) {
        arr = new int[size];
        this.size  = size;
        front = -1;
        rear = -1;
    }

    public void add(int val) {
        // check full
        if (rear == size - 1) {
            throw new RuntimeException("Queue Overflow");
        } else if (front == -1 && rear == -1) {
            // empty case
            front++;
            rear++;
            arr[rear] = val;
        } else {
            // normal case
            rear++;
            arr[rear] = val;
        }
    }

    public int poll() {
        // underflow
        if (front == -1 && rear == -1) {
            throw new RuntimeException("Queue Underflow");
        } else if (front == rear) {
            // empty case -> single element
            int temp = arr[front];
            arr[front] = -1;
            front = -1;
            rear = -1;
            return temp;
        } else {
            // normal case
            int temp = arr[front];
            arr[front] = -1;
            front++;
            return temp;
        }
    }

    public boolean isEmpty() {
        // bhul jata hu
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        if (isEmpty()) {
            return 0;
        } else {
            return rear - front + 1;
        }
    }

    public int peek() {
        if (front == -1) {
            throw new RuntimeException("No element in queue, cannot give front element");
        } else {
            return arr[front];
        }
    }   

    public int getLast() {
        if (rear == -1) {
            throw new RuntimeException("No element in queue, cannot give Last element");
        } else {    
            return arr[rear];
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
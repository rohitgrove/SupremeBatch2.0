public class Deqeue {
    public int[] arr;
    public int size;
    public int front;
    public int rear;

    public Deqeue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public void addFront(int val) {
        /*
         * // overFlow
         * if (front == 0)
         * {
         *      System.out.println("OverFlow");
         *      return;
         * }
         * // empty case
         * else if (front == -1 && rear == -1)
         * {
         *      front++;
         *      rear++;
         *      arr[front] = val;
         * }
         * // normal case
         * else
         * {
         *      front--;
         *      arr[front] = val;
         * }
         */
        if ((front == 0 && rear == size - 1) || (rear == front - 1)) // imp condition
        {
            throw new RuntimeException("Overflow");
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

    public void addBack(int val) {
        /*
         * // overflow
         * if (rear == size - 1)
         * {
         *      System.out.println("OverFlow");
         *      return;
         * }
         * // empty case
         * else if (front == -1 && rear == -1)
         * {
         *      front++;
         *      rear++;
         *      arr[rear] = val;
         * }
         * // normal case
         * else
         * {
         *      rear++;
         *      arr[rear] = val;
         * }
         */
        // The above code is garbage as humme Circular Nature maintain krna he padega
        // over flow
        if ((front == 0 && rear == size - 1) || (rear == front - 1)) // imp condition
        {
            throw new RuntimeException("Overflow");
        }
        // first Ele
        else if (front == -1 && rear == -1) {
            front++;
            rear++;
            arr[rear] = val;
        }
        // circular Nature
        else if (rear == size - 1 && front != 0) {
            rear = 0;
            arr[rear] = val;
        }
        // normal pushing
        else {
            rear++;
            arr[rear] = val;
        }
    }

    public void pollFront() {
        if (rear == -1 && front == -1) {
            throw new RuntimeException("Queue underflow");
        } else if (front == size - 1) {
            // single element
            arr[front] = -1;
            front = 0;
        } else {
            arr[front] = -1;
            front++;
        }
    }

    public void pollBack() {
        // underflow
        if (front == -1 && rear == -1) {
            throw new RuntimeException("Queue underflow");
        }
        // single element
        else if (front == rear) {
            arr[rear] = -1;
            front = -1;
            rear = -1;
        }
        // circular Nature
        else if (rear == 0) {
            arr[rear] = -1;
            rear = size - 1;
        }
        // normal Flow
        else {
            arr[rear] = -1;
            rear--;
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

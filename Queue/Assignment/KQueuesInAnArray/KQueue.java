public class KQueue {
    public int n, k, freespot;
    public int arr[], front[], rear[], next[];

    public KQueue(int n, int k) {
        this.n = n;
        this.k = k;
        freespot = 0;
        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];

        for (int i = 0; i < k; i++) {
            front[i] = rear[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }

        next[n - 1] = -1;
    }

    // push x into qith Queue
    public boolean push(int x, int qi) {
        // overflow
        if (freespot == -1) {
            return false;
        }

        // find dirst free index
        int index = freespot;

        // update freespot
        freespot = next[index];

        // if first element in qi
        if (front[qi] == -1) {
            front[qi] = index;
        } else {
            // link new element to Q's rearest element
            next[rear[qi]] = index;
        }

        // update next
        next[index] = -1;

        // update rear
        rear[qi] = index;
        arr[index] = x;
        return true;
    }

    // pop element from qith Queue
    public int pop(int qi) {
        // underflow
        if (front[qi] == -1) {
            return -1;
        }

        // find index to pop
        int index = front[qi];

        // front update
        front[qi] = next[index];

        // update freespot
        next[index] = freespot;
        freespot = index;

        return arr[index];
    }
}
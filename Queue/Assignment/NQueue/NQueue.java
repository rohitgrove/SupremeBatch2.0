import java.util.Arrays;

public class NQueue {
    int n, k, freespot;
    int[] arr, front, rear, next;

    public NQueue(int n, int k) {
        freespot = 0;
        this.n = n;
        this.k = k;
        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];

        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
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

        // find first free index;
        int index = freespot;

        // update freespot
        freespot = next[index];

        // if first element in qi
        if (front[qi] == -1) {
            front[qi] = index;
        } else {
            // link new element to that q's rearest element
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
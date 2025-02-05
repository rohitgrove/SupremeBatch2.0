public class NStack {
    public int a[], top[], next[];
    public int n; // no. of stacks
    public int size; // size of main array
    public int freeSpot; // tells free space in main array

    public NStack(int n, int size) {
        this.n = n;
        this.size = size;
        a = new int[size];
        top = new int[n];
        next = new int[size];

        for (int i = 0; i < n; i++) {
            top[i] = -1;
        }

        for (int i = 0; i < size; i++) {
            next[i] = i + 1;
        }
        next[size - 1] = -1;
    }

    // push X into mth stack.
    public boolean push(int X, int m) {
        if (freeSpot == -1) {
            return false; // stack overflow
        }

        // 1. find index
        int index = freeSpot;

        // 2. update freespot
        freeSpot = next[index];

        // 3. insert
        a[index] = X;

        // 4. update next
        next[index] = top[m - 1];

        // 5. update top
        top[m - 1] = index;

        return true; // push success.
    }

    // pop from mth stack
    public int pop(int m) {
        if (top[m - 1] == -1) {
            return -1; // stack overflow
        }

        int index = top[m - 1];
        top[m - 1] = next[index];
        int popedElement = a[index];
        next[index] = freeSpot;
        freeSpot = index;

        return popedElement;
    }
}

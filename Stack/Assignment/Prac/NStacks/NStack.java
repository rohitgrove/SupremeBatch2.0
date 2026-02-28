public class NStack {
    public int a[], top[], next[];
    public int size;
    public int n;
    public int freeSpot;

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

    public boolean push(int X, int m) {
        System.out.println(freeSpot);
        if (freeSpot == -1) {
            return false;
        }

        int index = freeSpot;
        freeSpot = next[index];
        a[index] = X;
        next[index] = top[m - 1];
        top[m - 1] = index;
        return true;
    }

    public int pop(int m) {
        if (top[m - 1] == -1) {
            return -1;
        }

        int index = top[m - 1];
        next[index] = top[m - 1];
        int popedElement = a[index];
        next[index] = freeSpot;
        freeSpot = index;
        return popedElement;
    }
}

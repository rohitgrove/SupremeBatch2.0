import java.util.Arrays;

public class NStacks {
    int a[], top[], next[];
    int n; // no. of stacks
    int size; // size of main array
    int freeSpot; // tells free space in main array

    public NStacks(int n, int s) {
        this.n = n;
        size = s;
        freeSpot = 0;
        a = new int[size];
        top = new int[n];
        next = new int[size];

        Arrays.fill(top, -1);

        for (int i = 0; i < a.length; i++) {
            next[i] = i + 1;
        }
        next[size - 1] = -1;
    }

    // push X into mth stack
    public void push(int X, int m) {
        if (freeSpot == -1) {
            throw new RuntimeException("Stack Overflow");
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
    }

    // pop from mth stack
    public int pop(int m) {
        if (top[m - 1] == -1) {
            throw new RuntimeException("Stack Underflow");
        }

        int index = top[m - 1];
        top[m - 1] = next[index];
        int popedElement = a[index];
        next[index] = freeSpot;
        freeSpot = index;
        return popedElement;
    }

    public int peek(int m) {
        if (top[m - 1] == -1) {
            throw new RuntimeException("Stack Underflow");
        }
        return top[m - 1];
    }

    public boolean isEmpty(int m) {
        if (top[m - 1] == -1) {
            return true;
        } else {
            return false;
        }
    }
}

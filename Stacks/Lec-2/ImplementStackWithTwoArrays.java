public class ImplementStackWithTwoArrays {
    int arr[];
    int size;
    int top1;
    int top2;

    public ImplementStackWithTwoArrays(int size) {
        arr = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }

    public void push1(int data) {
        if (top2 - top1 == 1) {
            // sapce not available
            throw new RuntimeException("Overflow");
        } else {
            top1++;
            arr[top1] = data;
        }
    }

    public void push2(int data) {
        if (top2 - top1 == 1) {
            // sapce not available
            throw new RuntimeException("Overflow");
        } else {
            top2--;
            arr[top2] = data;
        }
    }

    public void pop1() {
        if (top1 == -1) {
            throw new RuntimeException("underflow");
        } else {
            arr[top1] = 0;
            top1--;
        }
    }

    public void pop2() {
        if (top2 == size) {
            throw new RuntimeException("underflow");
        } else {
            arr[top2] = 0;
            top2++;
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
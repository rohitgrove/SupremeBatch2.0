public class Stack {
    public int arr[];
    public int size;
    public int top1;
    public int top2;

    public Stack(int size) {
        arr = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }

    public void push1(int data) {
        if (top2 - top1 == 1) {
            // no space avilable
            throw new RuntimeException("Overflow");
        }
        top1++;
        arr[top1] = data;
    }

    public void push2(int data) {
        if (top2 - top1 == 1) {
            // no space avilable
            throw new RuntimeException("Overflow");
        }
        top2--;
        arr[top2] = data;
    }

    public void pop1() {
        if (top1 == -1) {
            // stack is empty
            throw new RuntimeException("Underflow");
        }
        arr[top1] = 0;
        top1--;
    }

    public void pop2() {
        if (top2 == size) {
            // stack is empty
            throw new RuntimeException("Underflow");
        }
        arr[top2] = 0;
        top2++;
    }

    public void print() {
        System.out.println();
        System.out.println("Top1: " + top1);
        System.out.println("Top2: " + top2);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
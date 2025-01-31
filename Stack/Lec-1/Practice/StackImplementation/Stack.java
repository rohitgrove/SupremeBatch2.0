public class Stack {
    public int arr[];
    public int size;
    public int top;

    public Stack(int size) {
        arr = new int[size];
        this.size = size;
        this.top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            throw new RuntimeException("Stack is overflow");
        }
        top++;
        arr[top] = data;
    }

    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is underflow");
        }
        top--;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return arr[top];
    }

    public void print() {
        System.out.println("Top: " + top);
        System.out.println("Top Element: " + peek());
        System.out.print("Stack: ");
        for (int i = 0; i < getSize(); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
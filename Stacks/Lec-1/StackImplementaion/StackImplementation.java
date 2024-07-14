public class StackImplementation {
    public int arr[];
    int size;
    int top;

    public StackImplementation(int size) {
        arr = new int[size];
        this.size = size;
        this.top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            throw new RuntimeException("Stack is Overflow");
        } else {
            top++;
            arr[top] = data;
        }
    }

    public void pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is Underflow");
        } else {
            top--;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int peek() {
        if (top == -1) {
            throw new RuntimeException("You can not access empty Stack");
        } else {
            return arr[top];
        }
    }

    public int size() {
        return top + 1;
    }

    public void print() {
        System.out.println("Top: "+top);
        System.out.println("Top element: "+peek());
        for (int i = 0; i < size(); i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class Stack {
    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            throw new RuntimeException("Stack is already empty");
        }

        int data = top.data;
        top = top.next;
        return data;
    }

    public int size() {
        int len = 0;
        Node temp = top;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }

        return len;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        } 

        return top.data;
    }

    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
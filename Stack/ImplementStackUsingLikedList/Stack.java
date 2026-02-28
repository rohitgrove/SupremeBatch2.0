public class Stack {
    Node head = null;
    Node tail = null;
    int size = 0;

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int pop() {
        int val;
        if (head == null) {
            return -1;
        } else if (size() == 1) {
            val = head.data;
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }

            temp.next = null;
            val = tail.data;
            tail = temp;
        }
        size--;

        return val;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (head == null) {
            return -1;
        } else {
            return tail.data;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        System.out.println("Top Element: " + peek());
        System.out.print("Stack: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println();
    }
}

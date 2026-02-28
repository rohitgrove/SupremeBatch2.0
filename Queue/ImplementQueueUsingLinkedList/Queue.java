public class Queue {
    Node head = null;
    Node tail = null;
    int size = 0;

    public void offer(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        size++;
        tail.next = newNode;
        tail = newNode;
    }

    public void poll() {
        if (head == null) {
            System.out.println("Queue is Empty");
        } else if (size() == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

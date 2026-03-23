public class Deque {
    Node head = null;
    Node tail = null;

    public void offerLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void offerFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void pollFirst() {
        if (head == null) {
            System.out.println("Deque is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void pollLast() {
        if (head == null) {
            head = tail = null;
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;

            while (temp.next != tail) {
                temp = temp.next;
            }

            temp.next = null;
            tail = temp;
        }
    }

    public void print() {
        System.out.println("Printing Queue");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
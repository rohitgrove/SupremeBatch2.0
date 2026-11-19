public class LinkedList {
    public Node head;
    public Node tail;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void insertAtposition(int data, int position) {
        int length = getLength();
        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid position. Position valid only 1 to length + 1");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (length + 1)) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node prev = head;
            Node curr = head;
            while (position != 1) {
                prev = curr;
                curr = curr.next;
                position--;
            }

            prev.next = newNode;
            newNode.next = curr;
        }
    }

    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public int deleteNode(int position) {
        if (head == null) {
            throw new RuntimeException("Cannot delete, coz LL is Empty");
        }

        int size = getLength();
        if (position < 1 || position > (size)) {
            throw new RuntimeException("position is invalid");
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        if (position == 1) {
            int val = head.data;
            head = head.next;
            return val;
        } else if (position == size) {
            Node prev = head;

            while (prev.next != tail) {
                prev = prev.next;
            }

            int val = tail.data;
            prev.next = null;
            tail = prev;
            return val;
        } else {
            Node prev = head;
            while (position != 2) {
                prev = prev.next;
                position--;
            }

            Node curr = prev.next;
            prev.next = curr.next;

            return curr.data;
        }
    }
}
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

    public void insertAtPosition(int data, int position) {
        int len = getLength();
        if (position < 1 || position > (len + 1)) {
            throw new RuntimeException("Index is 1 to length + 1.");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (len + 1)) {
            insertAtTail(data);
        } else {
            Node prev = head;
            Node newNode = new Node(data);
            while (position != 2) {
                prev = prev.next;
                position--;
            }

            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public int getLength() {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }
}

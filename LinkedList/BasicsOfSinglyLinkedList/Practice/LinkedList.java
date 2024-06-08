public class LinkedList {
    public Node head;
    public Node tail;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

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

    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAtPosition(int data, int position) {
        int length = getLength();

        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid index. Valid index is 1 to list size + 1 position");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == length + 1) {
            insertAtTail(data);
        } else {
            Node prev = null;
            Node curr = head;
            while (position != 1) {
                prev = curr;
                curr = curr.next;
                position--;
            }
            Node newNode = new Node(data);
            prev.next = newNode;
            newNode.next = curr;
        }
    }

    public void insertAtPosition2(int data, int position) {
        int length = getLength();

        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid index. Valid index is 1 to list size + 1 position");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == length + 1) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node curr = head;
            while (position != 2) {
                curr = curr.next;
                position--;
            }

            newNode.next = curr.next;
            curr.next = newNode; 
        }
    }
}

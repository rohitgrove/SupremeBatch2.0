public class LinkedList {
    public Node head = null;
    public Node tail = null;

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void printLLRev() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }

    public int size() {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        head.prev = newNode;
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
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int position, int data) {
        int size = size();
        if (position < 0 || position > (size + 1)) {
            throw new RuntimeException("Index is invalid");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (size + 1)) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);

            Node prev = head;
            while (position != 2) {
                prev = prev.next;
                position--;
            }

            Node curr = prev.next;
            prev.next = newNode;
            newNode.prev = prev;
            curr.prev = newNode;
            newNode.next = curr;
        }
    }

    public int deleteNode(int position) {
        if (head == null) {
            throw new RuntimeException("LL is empty");
        }

        int size = size();
        if (size < 1 && size < position) {
            throw new RuntimeException("Invalid position");
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        if (position == 1) {
            int val = head.data;
            head = head.next;
            head.prev = null;
            return val;
        } else if (position == size) {
            int val = tail.data;
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
            return val;
        } else {
            Node prevNode = head;
            while (position != 2) {
                prevNode = prevNode.next;
            }
            Node currNode = prevNode.next;
            Node nextNode = currNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            return currNode.data;
        }
    }
}

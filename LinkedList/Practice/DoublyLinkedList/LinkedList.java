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
        if (position < 1 || position > (size + 1)) {
            throw new RuntimeException("Invalid position. Position valid only 1 to length + 1");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (size + 1)) {
            insertAtTail(data);
        } else {
            Node newNode = new Node(data);

            Node curr = head;
            Node prev = head;

            while (position != 1) {
                prev = curr;
                curr = curr.next;
                position--;
            }

            prev.next = newNode;
            newNode.next = curr;
            newNode.prev = prev;
            curr.prev = newNode;
        }
    }

    public int deleteFromHead() {
        if (head == null) {
            throw new RuntimeException("Can't delete, because of empty linked list");
        }

        if (head == tail) {
            int val = head.data;
            head = null;
            tail = null;
            return val;
        } else {
            Node temp = head;

            head = head.next;
            head.prev = null;

            return temp.data;
        }
    }

    public int deleteFromTail() {
        if (head == null) {
            throw new RuntimeException("Can't delete, because of empty linked list");
        }

        if (head == tail) {
            int val = head.data;
            head = null;
            tail = null;
            return val;
        } else {
            int val = tail.data;
            Node prevNode = tail.prev;

            prevNode.next = null;
            tail = prevNode;

            return val;
        }
    }

    public int deleteNode(int position) {
        if (head == null) {
            throw new RuntimeException("LL is Empty");
        }

        int size = size();
        if (position < 1 || position > (size)) {
            throw new RuntimeException("position is invalid");
        }

        if (position == 1) {
            return deleteFromHead();
        } else if (position == size) {
            return deleteFromTail();
        } else {
            Node prvNode = head;
            Node currNode = head;
            while (position != 1) {
                prvNode = currNode;
                currNode = currNode.next;
                position--;
            }
            int val = currNode.data;
            Node nextNode = currNode.next;
            prvNode.next = nextNode;
            nextNode.prev = prvNode;
            return val;
        }
    }
}

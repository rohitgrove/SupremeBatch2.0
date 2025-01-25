public class LinkedList {
    public Node head = null;
    public Node tail = null;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void printRev() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }

    public int findLength() {
        int len = 0;
        Node temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
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

    public void insertAtMiddle(int position, int data) {
        int length = findLength();

        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid position. Position valid only 1 to length + 1");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (length + 1)) {
            insertAtTail(data);
        } else {
            // step1: create node
            Node newNode = new Node(data);
            // step2: set prev
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
            throw new RuntimeException("Cannot delete, coz LL is Empty");
        }

        int size = findLength();

        if (position < 1 || position > size) {
            throw new RuntimeException("Invalid position");
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        if (position == 1) {
            // delete from head
            int val = head.data;
            head = head.next;
            head.prev = null;
            return val;
        } else if (position == size) {
            // delete from tail
            int val = tail.data;
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
            return val;
        } else {
            // delete from middle

            // Step1: setPrevNode/CurrNode/NextNode
            Node prevNode = head;
            while (position != 2) {
                prevNode = prevNode.next;
                position--;
            }
            Node currNode = prevNode.next;
            Node nextNode = currNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            return currNode.data;
        }
    }
}

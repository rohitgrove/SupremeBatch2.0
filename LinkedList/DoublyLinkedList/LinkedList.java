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

    public int deleteNode1(int position) {
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

    public int deleteNode2(int position) {
        if (head == null) {
            throw new RuntimeException("LL is Empty");
        }

        int size = findLength();
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

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

    public int deleteAtHead() {
        if (head == null) {
            throw new RuntimeException("Linked List is empty");
        } else if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int deleteAtTail() {
        if (head == null) {
            throw new RuntimeException("Linked List is empty");
        } else if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        int val = curr.data;
        prev.next = null;
        tail = prev;

        return val;
    }

    public int deleteAtPosition(int index) {
        if (head == null) {
            throw new RuntimeException("Linked List is empty");
        }
        int len = getLength();
        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        } else if (index == 1) {
            return deleteAtHead();
        } else if (index == len) {
            return deleteAtTail();
        } else {
            Node prev = null;
            Node curr = head;
            while (index != 1) {
                index--;
                prev = curr;
                curr = curr.next;
            }
            int val = curr.data;

            prev.next = curr.next;
            curr.next = null;

            return val;
        }
    }

    public void deleteAtPositionByVal(int val) {
        if (head == null) {
            throw new RuntimeException("Linked List is empty");
        }

        if (head == tail) {
            head = tail = null;
        } else if (head.data == val) {
            deleteAtHead();
            return;
        } else if (tail.data == val) {
            deleteAtTail();
            return;
        } else {
            Node prev = null;
            Node curr = head;
            while (curr != null && curr.data != val) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = curr.next;
            curr.next = null;
        }
    }
}

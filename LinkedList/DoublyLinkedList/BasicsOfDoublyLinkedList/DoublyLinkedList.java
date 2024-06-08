public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void revPrint() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }

    public int findLength() {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        // LL is empty
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
        // LL is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            int len = findLength();
            if (position < 1 || position > len + 1) {
                throw new RuntimeException("Invalid Exeption. Valid Index is 1 to List size + 1");
            } else if (position == 1) {
                insertAtHead(data);
            } else if (position == len + 1) {
                insertAtTail(data);
            } else {
                // insert in middle
                // ste2: set prev and curr pointer
                Node prevNode = null;
                Node currNode = head;
                while (position != 1) {
                    position--;
                    prevNode = currNode;
                    currNode = currNode.next;
                }
                // step3:pointers update krre the
                prevNode.next = newNode;
                newNode.prev = prevNode;
                newNode.next = currNode;
                currNode.prev = newNode;
            }
        }
    }

    public int deleteAtHead() {
        if (head == null) { 
            throw new RuntimeException("Can not delete, coz ll is empty");
        } else if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }

    public int deleteAtTail() {
        if (head == null) { 
            throw new RuntimeException("Can not delete, coz ll is empty");
        } else if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = tail.data;
        Node prevNode = tail.prev;
        prevNode.next = null;
        tail.prev = null;
        tail = prevNode;
        return val;
    }

    public int deleteAtIndex(int position) {
        if (head == null) {
            throw new RuntimeException("Can not delete, coz ll is empty");
        } 

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        int len = findLength();
        if (position == 1) {
            // delete from head 
            return deleteAtHead();
        } else if (len == position) {
            // delete from tail
            return deleteAtTail();
        } else {
            // delete from middle
            Node prevNode = null;
            Node currNode = head;
            while (position != 1) {
                position--;
                prevNode = currNode;
                currNode = currNode.next;
            }
            Node nextNode = currNode.next;
            
            int val = currNode.data;

            prevNode.next = nextNode;
            currNode.prev = null;
            currNode.next = null;
            nextNode.prev = prevNode;

            return val;
        }
    }
}
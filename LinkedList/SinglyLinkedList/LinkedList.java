public class LinkedList {
    public Node head = null;
    public Node tail = null;

    public void insertAtHead(int data) {
        // create a new Node
        Node newNode = new Node(data);
        if (head == null) {
            // empty ll
            head = tail = newNode;
            return;
        }
        // attach new Node to head node
        newNode.next = head;
        // update head
        head = newNode;
    }

    public void insertAtTail(int data) {
        // step1: create new node
        Node newNode = new Node(data);
        if (head == null) {
            // empty LL
            // step2: single node h entire list me, that's why tail ko ispar karwado
            head = tail = newNode;
            return;
        }
        // Non-emptyLL
        // step2: tail node ko attach karo newNode se
        tail.next = newNode;
        // step3: update kar do tail ko
        tail = newNode;
    }

    public void insertAtPosition1(int data, int position) {
        // assumption: position ki value [1 to length + 1 tk]
        int length = getLength();
        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid position. Position valid only 1 to length + 1");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (length + 1)) {
            insertAtTail(data);
        } else {
            // insert at middle linked list
            // step1: create a new Node
            Node newNode = new Node(data);
            // Step 2: traverse prev curr to position
            Node prev = head;
            Node curr = head;
            while (position != 1) {
                prev = curr;
                curr = curr.next;
                position--;
            }

            // Step 3: attach prev to newNode
            prev.next = newNode;

            // Step 4: attach newNode to curr
            newNode.next = curr;
        }
    }

    public void insertAtPosition2(int data, int position) {
        int length = getLength();
        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid position. Position valid only 1 to length + 1");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (length + 1)) {
            insertAtTail(data);
        } else {
            // insert at middle of linked list
            // Step 1: create a new node
            Node newNode = new Node(data);

            // Step 2: traverse curr to position
            Node curr = head;
            while (position != 2) {
                curr = curr.next;
                position--;
            }

            // Step3: attach newNode to curr's next
            newNode.next = curr.next;
            // Step 4: attach curr to newNode
            curr.next = newNode;
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

    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int deleteNode(int position) {
        // empty list
        if (head == null) {
            throw new RuntimeException("Cannot delete, coz LL is Empty");
        }

        int size = getLength();

        if (position < 1 || position > size) {
            throw new RuntimeException("Invalid position");
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        // delete from head
        if (position == 1) {
            // first node ko delete kardo
            int val = head.data;
            head = head.next;
            return val;
        } else if (size == position) {
            // last delete ko delete kardo

            // find prev
            Node prev = head;
            while (prev.next != tail) {
                prev = prev.next;
            }
            int val = tail.data;
            // prev node ka link null karo
            prev.next = null;

            // update tail
            tail = prev;
            return val;
        } else {
            // middle me koi node ko delete krna hai

            // step1: set prev pointers
            Node prev = head;
            while (position != 2) {
                position--;
                prev = prev.next;
            }

            // step2: prev -> next me curr ka next add karo
            Node curr = prev.next;
            prev.next = curr.next;

            return curr.data;
        }
    }

    public void deleteNodeByValue(int value) {
        if (head == null) {
            throw new RuntimeException("Cannot delete, coz LL is Empty");
        }

        if (head == tail && head.data == value) {
            head = tail = null;
            return;
        }

        if (head.data == value) {
            head = head.next;
        } else if (tail.data == value) {
            Node prev = head;

            while (prev.next != tail) {
                prev = prev.next;
            }

            prev.next = null;
            tail = prev;
        } else {
            Node prev = head;

            while (prev.next != null && prev.next.data != value) {
                prev = prev.next;
            }
            Node curr = prev.next;
            if (curr != null) {
                prev.next = curr.next;
            }
        }
    }
}
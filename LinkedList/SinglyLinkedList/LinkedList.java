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
            throw new UnsupportedOperationException("Invalid position. Position valid only 1 to length + 1");
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
            Node prev = null;
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
            throw new UnsupportedOperationException("Invalid position. Position valid only 1 to length + 1");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == (length + 1)) {
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
}
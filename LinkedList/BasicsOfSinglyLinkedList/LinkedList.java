public class LinkedList {
    public Node head = null;
    public Node tail = null;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public int getLength() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public void insertAtHead(int data) {
        // Step 1 - create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2 - link to head
        newNode.next = head; // link

        // Step 3 - update head
        head = newNode;
    }

    public void insertAtTail(int data) {
        // Step 1: Create A new Node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Step 2: Connect with tail node
        tail.next = newNode;
        // Step 3: Update tail
        tail = newNode;
    }

    public void insertAtPosition(int data, int position) {
        // asumption: position ki value [1 to length+1 tk]
        int length = getLength();
        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid index. Valid index is 1 to list size + 1 position");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == length + 1) {
            insertAtTail(data);
        } else {
            // insert at middle of linked list

            // Step 1: create a new node
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
        // asumption: position ki value [1 to length+1 tk]
        int length = getLength();
        if (position < 1 || position > (length + 1)) {
            throw new RuntimeException("Invalid index. Valid index is 1 to list size + 1 position");
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == length + 1) {
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
}

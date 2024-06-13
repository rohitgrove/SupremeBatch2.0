public class LinkedList {
    public Node head;
    public Node tail;

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

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}

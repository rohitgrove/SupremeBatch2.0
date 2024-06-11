public class Main {
    public static Node head;
    public static Node tail;

    public static void insertAtHead(int data) {
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

    public static void main(String[] args) {
        PrintLinkedList pll = new PrintLinkedList();
        // AddOneToALL aota = new AddOneToALL();
        // insertAtHead(9);
        // insertAtHead(9);
        // insertAtHead(9);
        // pll.printLL(head);
        // aota.addOne(head);
        // pll.printLL(head);

        insertAtHead(5);
        insertAtHead(4);
        insertAtHead(3);
        insertAtHead(2);
        insertAtHead(1);

        RevereseKGroup rkg = new RevereseKGroup();
        pll.printLL(head);
        pll.printLL(rkg.reverseKGroup(head, 2));
    }
}
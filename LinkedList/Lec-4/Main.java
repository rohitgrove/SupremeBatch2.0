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
        // insertAtHead(70);
        // insertAtHead(60);
        // insertAtHead(50);
        // insertAtHead(40);
        // insertAtHead(30);
        // insertAtHead(20);
        // insertAtHead(10);
        // pll.printLL(head);
        // tail.next = head.next.next;
        // tail.next = head.next.next.next;

        // DetectFindStaringAndRemoveCycle dfsrc = new DetectFindStaringAndRemoveCycle();
        // System.out.println(dfsrc.getStartingPoint(head).data);
        // dfsrc.removeLoop(head);
        // pll.printLL(head);

        // AddOneToALL aota = new AddOneToALL();
        // insertAtHead(9);
        // insertAtHead(9);
        // insertAtHead(9);
        // pll.printLL(head);
        // head = aota.addOne(head);
        // pll.printLL(head);

        // ReverseKGroup rkg = new ReverseKGroup();
        // insertAtHead(5);
        // insertAtHead(4);
        // insertAtHead(3);
        // insertAtHead(2);
        // insertAtHead(1);
        // pll.printLL(head);
        // pll.printLL(rkg.reverseKGroup(head, 2));

        insertAtHead(4);
        insertAtHead(3);
        insertAtHead(3);
        insertAtHead(2);
        insertAtHead(2);
        insertAtHead(1);

        RemoveDuplicate rd = new RemoveDuplicate();
        pll.printLL(head);
        pll.printLL(rd.deleteDuplicates(head));
    }
}
public class DetectAndRemoveCycle {
    public static void printll(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static Node detectNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static Node removeLoop(Node head) {
        Node startingPoint = detectNode(head);
        if (startingPoint == null) {
            return head;
        }

        Node temp = startingPoint;
        while (temp.next != startingPoint) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixth = new Node(60);
        Node seventh = new Node(70);
        Node eigth = new Node(80);
        Node ninth = new Node(90);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eigth;
        eigth.next = ninth;
        ninth.next = fourth;
        Node head = first;
        printll(removeLoop(head));
    }
}

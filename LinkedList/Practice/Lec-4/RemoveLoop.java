public class RemoveLoop {
    public static Node detectCycle(Node head) {
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
        Node startingPoint = detectCycle(head);
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

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        printLL(removeLoop(head));
    }
}

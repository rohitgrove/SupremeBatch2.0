public class LinkedListCycle2 {
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
        System.out.println(detectCycle(head).data);
    }
}

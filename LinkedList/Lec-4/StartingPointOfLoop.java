public class StartingPointOfLoop {
    public static Node detectCycle(Node head) {
        // check loop
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        // yha phocha, iska mtlb slow and fast meet kr chuke h
        slow = head;

        // slow ans fast -> 1 step
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        // return starting point
        return slow;
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
        System.out.println(detectCycle(head).data);
    }
}

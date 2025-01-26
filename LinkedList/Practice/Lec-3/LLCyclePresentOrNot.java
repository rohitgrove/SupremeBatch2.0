import java.util.HashMap;

public class LLCyclePresentOrNot {
    private static boolean hasCycle(Node head) {
        HashMap<Node, Boolean> table = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            if (table.containsKey(temp)) {
                return true;
            }
            table.put(temp, true);
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixth = new Node(60);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = second;
        Node head = first;
        System.out.println(hasCycle(head));
    }

}
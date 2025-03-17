import java.util.HashMap;

public class LiskedListCycle {
    public static boolean hasCycle(Node head) {
        HashMap<Node, Boolean> mapping = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            // address check
            if (mapping.containsKey(temp)) {
                return true;
            }
            // node not visited before hand store
            mapping.put(temp, true);
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

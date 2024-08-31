import java.util.HashMap;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListIsCircular {
    public static boolean hasCycle(Node head) {
        HashMap<Node, Boolean> mapping = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            // address check
            if (mapping.containsKey(temp)) {
                return true;
            }
            // address store
            mapping.put(temp, true);
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node first = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(-4);

        Node head = first;
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        System.out.println(hasCycle(head));
    }    
}

public class DetectFindStaringAndRemoveCycle {
    public static Node getStartingPoint(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void removeLoop(Node head) {
        Node startingPoint = getStartingPoint(head);
        Node temp = startingPoint;
        while(temp.next != startingPoint) { 
            temp = temp.next;
        }

        temp.next = null;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); 
        ll.insertAtHead(70);
        ll.insertAtHead(60);
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.tail.next = ll.head.next.next;
        ll.tail.next = ll.head.next.next.next;
        removeLoop(ll.head);
        ll.printLL();
    }
}
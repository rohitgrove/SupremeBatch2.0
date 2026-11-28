public class RemoveNthNthNodeFromEndOfList {
    public static int getLength(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public static Node removeNthFromEnd(Node head, int n) {
        int size = getLength(head);
        int posFromTail = size - n - 1;
        Node temp = head;
        while (posFromTail > 0) {
            temp = temp.next;
            posFromTail--;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(1);
        ll.insertAtTail(2);
        ll.insertAtTail(3);
        ll.insertAtTail(4);
        ll.insertAtTail(5);
        ll.printLL(removeNthFromEnd(ll.head, 2));
    }
}

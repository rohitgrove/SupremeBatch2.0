public class RemoveDuplicatesInSortedLL {
    public static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;

        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                Node nextNode = temp.next;
                temp.next = nextNode.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(1);
        ll.insertAtTail(2);
        ll.insertAtTail(2);
        ll.insertAtTail(3);
        ll.insertAtTail(3);
        ll.insertAtTail(4);
        ll.printLL(deleteDuplicates(ll.head));
    }
}

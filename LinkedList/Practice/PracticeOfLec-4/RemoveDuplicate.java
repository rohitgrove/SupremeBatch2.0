public class RemoveDuplicate {
    public static Node deleteDuplicates(Node head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
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
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.printLL();
        ll.printLL(deleteDuplicates(ll.head));
    }
}

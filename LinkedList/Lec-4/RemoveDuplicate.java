public class RemoveDuplicate {
    public Node deleteDuplicates(Node head) {
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
}

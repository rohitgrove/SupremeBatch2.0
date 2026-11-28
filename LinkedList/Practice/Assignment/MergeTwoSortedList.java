public class MergeTwoSortedList {
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node ans = new Node(-1);
        Node it = ans;
        Node head1 = list1;
        Node head2 = list2;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                it.next = head1;
                head1 = head1.next;
                it = it.next;
            } else {
                it.next = head2;
                head2 = head2.next;
                it = it.next;
            }
        }

        if (head1 != null) {
            it.next = head1;
        }

        if (head2 != null) {
            it.next = head2;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(4);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(3);
        ll2.insertAtTail(4);
        ll2.printLL(mergeTwoLists(ll1.head, ll2.head));
    }
}

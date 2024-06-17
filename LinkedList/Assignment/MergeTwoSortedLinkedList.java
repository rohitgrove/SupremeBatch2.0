public class MergeTwoSortedLinkedList {
    public static Node mergeTwoLists(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node ans = new Node(-1);
        Node mptr = ans;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                mptr.next = left;
                mptr = left;
                left = left.next;
            } else {
                mptr.next = right;
                mptr = right;
                right = right.next;
            }
        }

        if (left != null) {
            mptr.next = left;
        }

        if (right != null) {
            mptr.next = right;
        }

        ans = ans.next;
        return ans;
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

        LinkedList ll3 = new LinkedList();
        ll3.head = mergeTwoLists(ll1.head, ll2.head);
        ll3.printLL();
    }    
}

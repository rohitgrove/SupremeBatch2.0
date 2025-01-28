public class MergeTwoSortedList {
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
            if (left.data < right.data) {
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

        return ans.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertAtHead(1);
        list1.insertAtTail(2);
        list1.insertAtTail(4);

        LinkedList list2 = new LinkedList();
        list2.insertAtHead(1);
        list2.insertAtTail(3);
        list2.insertAtTail(4);

        list2.printLL(mergeTwoLists(list1.head, list2.head));
    }
}

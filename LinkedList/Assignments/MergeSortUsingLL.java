public class MergeSortUsingLL {
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // break LL into tow halfes using mid
        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // Sort RE
        left = mergeSort(left);
        right = mergeSort(right);

        // merge both right and left LL
        return merge(left, right);
    }

    public static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        Node ans = new Node(-1);
        Node mtpr = ans;

        while (left != null && right != null) {
            if (left.data < right.data) {
                mtpr.next = left;
                mtpr = left;
                left = left.next;
            } else {
                mtpr.next = right;
                mtpr = right;
                right = right.next;
            }
        }

        if (left != null) {
            mtpr.next = left;
        }

        if (right != null) {
            mtpr.next = right;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtPosition(4, 1);
        ll1.insertAtPosition(2, 2);
        ll1.insertAtPosition(1, 3);
        ll1.insertAtPosition(3, 4);
        ll1.printLL(mergeSort(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtPosition(-1, 1);
        ll2.insertAtPosition(5, 2);
        ll2.insertAtPosition(3, 3);
        ll2.insertAtPosition(4, 4);
        ll2.insertAtPosition(0, 5);
        ll2.printLL(mergeSort(ll2.head));
    }
}

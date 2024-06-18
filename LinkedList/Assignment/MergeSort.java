public class MergeSort {
    public static Node findMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    
    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // break LL into halves mid node.
        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // sort RE
        left = sortList(head);
        right = sortList(right);

        // merge both right and left list
        Node result = merge(left, right);
        return result;
    }

    public static Node merge(Node left, Node right) { 
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        Node result = new Node(-1);
        Node ans = result;
        while (left != null && right != null) {
            if (left.data < right.data) {
                ans.next = left;
                ans = left;
                left = left.next;
            } else {
                ans.next = right;
                ans = right;
                right = right.next;
            }
        }

        if (left != null) {
            ans.next = left;
        }

        if (right != null) {
            ans.next = right;
        }

        return result.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(4);
        ll.insertAtTail(2);
        ll.insertAtTail(1);
        ll.insertAtTail(3);
        ll.printLL();
        ll.head = sortList(ll.head);
        ll.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(40);
        ll2.insertAtTail(20);
        ll2.insertAtTail(10);
        ll2.insertAtTail(30);
        ll2.insertAtTail(50);
        ll2.printLL();
        ll2.head = sortList(ll2.head);
        ll2.printLL();
    }    
}

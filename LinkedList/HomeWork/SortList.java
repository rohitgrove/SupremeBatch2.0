public class SortList {
    public static Node sortList(Node head) {
        return mergeSort(head);
    }

    public static Node getMid(Node head) {
        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        Node midNode = getMid(head);
        Node left = head;
        Node right = midNode.next;
        midNode.next = null; // cut the list

        // step 2. sort each half
        left = mergeSort(left);
        right = mergeSort(right);

        // step 3. merge l1 and l2
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
        Node temp = ans;
        // merge 2 sorted linked list
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        while (left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }

        while (right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }
        ans = ans.next;
        return ans;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(3);
        ll1.insertAtHead(1);
        ll1.insertAtHead(2);
        ll1.insertAtHead(4);
        ll1.printLL();
        ll1.printLL(mergeSort(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(0);
        ll2.insertAtHead(4);
        ll2.insertAtHead(3);
        ll2.insertAtHead(5);
        ll2.insertAtHead(-1);
        ll2.printLL();
        ll2.printLL(mergeSort(ll2.head));
    }
}

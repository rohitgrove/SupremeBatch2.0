public class SwappingNodeInALL {
    public static int lenItr(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static Node swapValuesM1(Node head, int k) {
        Node temp = head;
        int pos = (lenItr(head) - k) + 1;
        while (k != 1) {
            temp = temp.next;
            k--;
        }
        Node kthNodeFromStart = temp;
        temp = head;
        while (pos != 1) {
            temp = temp.next;
            pos--;
        }

        Node KthNodeFromEnd = temp;
        int tempdata = kthNodeFromStart.data;
        kthNodeFromStart.data = KthNodeFromEnd.data;
        KthNodeFromEnd.data = tempdata;
        return head;
    }

    public static int lenRec(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + lenRec(head.next);
    }

    public static Node swapPointerM2(Node head, int k) {
        // case 1
        if (head == null || head.next == null) {
            return head;
        }

        int len = lenRec(head);
        int lpos = k;
        int rpos = len - k + 1;

        if (rpos < lpos) {
            int temp = rpos;
            rpos = lpos;
            lpos = temp;
        }

        // case 2
        if (rpos == lpos) {
            return head;
        }

        // case 3
        if (len == 2) {
            Node nextNode = head.next;
            nextNode.next = head;
            head.next = null;
            head = nextNode;
            return head;
        }

        // case 4
        if (lpos == 1) {
            Node lp = null;
            Node ln = head;
            Node rp = head;
            for (int i = 0; i < rpos - 2; i++) {
                rp = rp.next;
            }
            Node rn = rp.next;
            Node rsave = rn.next;

            // swapping
            rn.next = ln.next;
            rp.next = ln;
            ln.next = rsave;
            head = rn;
            return head;
        }

        int noNodeBetweenSwapNodes = rpos - lpos - 1;
        // case 5
        if (noNodeBetweenSwapNodes == 0) {
            // ln and rn are adjecent
            Node lp = head;
            for (int i = 0; i < lpos - 2; i++) {
                lp = lp.next;
            }
            Node ln = lp.next;

            Node rp = head;
            for (int i = 0; i < rpos - 2; i++) {
                rp = rp.next;
            }
            Node rn = rp.next;
            Node rsave = rn.next;

            // swap
            lp.next = rp.next;
            rn.next = rp;
            rp.next = rsave;
            return head;
        } else {
            // case 6
            // no of Nodes between Swap Nodes >= 1
            Node lp = head;
            for (int i = 0; i < lpos - 2; i++) {
                lp = lp.next;
            }
            Node ln = lp.next;

            Node rp = head;
            for (int i = 0; i < rpos - 2; i++) {
                rp = rp.next;
            }
            Node rn = rp.next;
            Node rsave = rn.next;

            // swap
            lp.next = rn;
            rn.next = ln.next;
            rp.next = ln;
            ln.next = rsave;
            return head;
        }
    }

    public static Node swapNodes(Node head, int k) {
        return swapPointerM2(head, k);
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        ll1.printLL();
        ll1.head = swapNodes(ll1.head, 2);
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(7);
        ll2.insertAtTail(9);
        ll2.insertAtTail(6);
        ll2.insertAtTail(6);
        ll2.insertAtTail(7);
        ll2.insertAtTail(8);
        ll2.insertAtTail(3);
        ll2.insertAtTail(0);
        ll2.insertAtTail(9);
        ll2.insertAtTail(5);
        ll2.printLL();
        ll2.head = swapNodes(ll2.head, 5);
        ll2.printLL();
    }
}

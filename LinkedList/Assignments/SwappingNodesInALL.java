public class SwappingNodesInALL {
    public static int Len(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public static Node swapNodes(Node head, int k) {
        // Case 1
        if (head == null || head.next == null) {
            return head;
        }
        int len = Len(head);
        int lpos = k;
        int rpos = len - k + 1;

        if (rpos < lpos) {
            int temp = rpos;
            rpos = lpos;
            lpos = temp;
        }

        // case 2
        if (lpos == rpos) {
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
            // Node np = null;
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

        int noOfNodesBetweenSwapNodes = rpos - lpos - 1;
        // case 5
        if (noOfNodesBetweenSwapNodes == 0) {
            // ln and rn are adjacents
            Node lp = head;
            for (int i = 0; i < lpos - 2; i++) {
                lp = lp.next;
            }
            // Node ln = lp.next;

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
            // noOfNodesBetweenSwapNodes >= 1
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

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        swapNodes(ll1.head, 2);
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
        swapNodes(ll2.head, 5);
        ll2.printLL();
    }
}

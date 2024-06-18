public class InsertionOfTwoLL {
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA, b = headB;

        while (a.next != null && b.next != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        if (a.next == null && b.next == null && a != b) {
            return null;
        }

        if (a.next == null) {
            // B LL is Big ya equal hai
            // We need to find out how much bigger it is
            int blen = 0;
            while (b.next != null) {
                blen++;
                b = b.next;
            }

            while (blen-- > 0) {
                headB = headB.next;
            }
        } else {
            // A LL is Big
            // We need to find out how much bigger it is
            int alen = 0;
            while (a.next != null) {
                alen++;
                a = a.next;
            }

            while (alen-- > 0) {
                headA = headA.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node head1 = new Node(4);
        Node h1first = new Node(1);
        head1.next = h1first;

        ll.printLL(head1);

        Node head2 = new Node(5);
        Node h2first = new Node(6);
        Node h2second = new Node(1);

        head2.next = h2first;
        h2first.next = h2second;
        ll.printLL(head2);

        Node joinedNode1LL = new Node(8);
        Node joinedNode2LL = new Node(4);
        Node joinedNode3LL = new Node(5);
        
        joinedNode1LL.next = joinedNode2LL;
        joinedNode2LL.next = joinedNode3LL;

        h1first.next = joinedNode1LL;
        h2second.next = joinedNode1LL;

        ll.printLL(head1);
        ll.printLL(head2);

        System.out.println(getIntersectionNode(head1, head2).data);
    }
}

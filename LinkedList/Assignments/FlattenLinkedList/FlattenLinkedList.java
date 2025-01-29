public class FlattenLinkedList {
    public static void printLL(FNode head) {
        FNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " { ");
            FNode currChild = curr.bottom;
            while (currChild != null) {
                System.out.print(currChild.data + ", ");
                currChild = currChild.bottom;
            }
            System.out.println(" }");
            curr = curr.next;
        }
    }

    public static void printLL2(FNode head) {
        FNode currChild = head;
        while (currChild != null) {
            System.out.print(currChild.data + " -> ");
            currChild = currChild.bottom;
        }
        System.out.println("Null");
    }

    public static FNode merge(FNode left, FNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        FNode ans = new FNode(-1);
        FNode mtpr = ans;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                mtpr.bottom = left;
                mtpr = left;
                left = left.bottom;
            } else {
                mtpr.bottom = right;
                mtpr = right;
                right = right.bottom;
            }
        }

        if (left != null) {
            mtpr.bottom = left;
        }

        if (right != null) {
            mtpr.bottom = right;
        }

        return ans.bottom;
    }

    public static FNode flatten(FNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        FNode mergeLL = merge(head, flatten(head.next));

        return mergeLL;
    }

    public static void main(String[] args) {
        FNode first = new FNode(5);
        FNode second = new FNode(10);
        FNode third = new FNode(19);
        FNode fourth = new FNode(28);

        FNode head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        first.bottom = new FNode(7);
        first.bottom.bottom = new FNode(8);
        first.bottom.bottom.bottom = new FNode(30);

        second.bottom = new FNode(20);

        third.bottom = new FNode(22);
        third.bottom.bottom = new FNode(50);

        fourth.bottom = new FNode(35);
        fourth.bottom.bottom = new FNode(40);
        fourth.bottom.bottom.bottom = new FNode(45);
        printLL(head);

        printLL2(flatten(head));
    }
}

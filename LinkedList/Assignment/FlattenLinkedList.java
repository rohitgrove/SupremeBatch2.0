public class FlattenLinkedList {
    static class FNode {
        int data;
        FNode next;
        FNode bottom;

        FNode(int data) {
            this.data = data;
            next = null;
            bottom = null;
        }
    }

    public static FNode merge(FNode a, FNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        FNode ans;
        if (a.data < b.data) {
            ans = a;
            ans.bottom = merge(a.bottom, b);
        } else {
            ans = b;
            ans.bottom = merge(a, b.bottom);
        }

        return ans;
    }

    public static FNode flatten(FNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Merge this list with the list on the right
        root = merge(root, flatten(root.next));

        return root;
    }

    public static void main(String[] args) {
        FNode head = new FNode(5);
        FNode first = new FNode(10);
        FNode second = new FNode(19);
        FNode third = new FNode(28);
        head.next = first;
        first.next = second;
        second.next = third;

        head.bottom = new FNode(7);
        head.bottom.bottom = new FNode(8);
        head.bottom.bottom.bottom = new FNode(30);

        first.bottom = new FNode(20);

        second.bottom = new FNode(22);
        second.bottom.bottom = new FNode(50);

        third.bottom = new FNode(35);
        third.bottom.bottom = new FNode(40);
        third.bottom.bottom.bottom = new FNode(45);

        System.out.println("Original linked list:");
        printALL(head);
        System.out.println("Flattened linked list:");
        printLL(flatten(head));
    }

    public static void printLL(FNode head) {
        FNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.bottom; 
        }
        System.out.println("null"); 
    }

    public static void printALL(FNode head) {
        FNode temp = head;
        while (temp != null) {
            FNode temp2 = temp;
            while (temp2 != null) {
                System.out.print(temp2.data + " -> ");
                temp2 = temp2.bottom;
            }
            System.out.println("null");
            temp = temp.next;
        }
    }
}
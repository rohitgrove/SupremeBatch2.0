public class DLLtoBST {
    public static Node convertDLLtoBST(Node head[], int n) {
        // base case
        if (head == null || n <= 0) {
            return null;
        }

        // LNR
        // L
        Node leftSubtree = convertDLLtoBST(head, n / 2);

        // N
        Node root = head[0];
        root.left = leftSubtree;
        // head update
        head[0] = head[0].right;

        ///R
        Node rightSubtree = convertDLLtoBST(head, n - (n / 2) - 1);
        root.right = rightSubtree;
        return root;
    }

    public static Node sortedListToBST(Node head) {
        int n = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.right;
            n++;
        }

        return convertDLLtoBST(new Node[] { head }, n);
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        first.right = second;
        second.left = first;
        second.right = third;
        third.left = second;
        Node head = first;
        Traversals.levelOrder(sortedListToBST(head));
    }
}

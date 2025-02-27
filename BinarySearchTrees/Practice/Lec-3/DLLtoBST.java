public class DLLtoBST {
    public static Node convertDLLtoBST(Node head[], int n) {
        if (head == null || n <= 0) {
            return null;
        }

        Node leftSubTree = convertDLLtoBST(head, n / 2);
        
        Node root = head[0];
        root.left = leftSubTree;
        head[0] = head[0].right;

        Node rightSubTree = convertDLLtoBST(head, n - (n / 2) - 1);
        root.right = rightSubTree;
        return root;
    }

    public static Node sortedListToBST(Node head) {
        Node temp = head;
        int n = 0;
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

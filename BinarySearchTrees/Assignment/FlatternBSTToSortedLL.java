public class FlatternBSTToSortedLL {
    public static void inorder(Node root, Node[] prev) {
        if (root == null) {
            return;
        }

        inorder(root.left, prev);
        prev[0].left = null;
        prev[0].right = root;
        prev[0] = root;
        inorder(root.right, prev);
    }

    public static Node flatten(Node root) {
        Node dummy = new Node(-1);
        Node[] prev = { dummy };
        inorder(root, prev);
        prev[0].left = prev[0].right = null;
        return dummy.right;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root = ConstructTree.createTree(data);
        Traversals.levelOrderTraversal(root);
        printLL(flatten(root));
    }
}

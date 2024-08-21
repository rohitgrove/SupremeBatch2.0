public class BuildBSTUsingPreorder {
    static int idx = 0;

    public static Node build(int min, int max, int[] preOrder) {
        if (idx >= preOrder.length) {
            return null;
        }

        Node root = null;

        if (preOrder[idx] > min && preOrder[idx] < max) {
            root = new Node(preOrder[idx++]);
            root.left = build(min, root.data, preOrder);
            root.right = build(root.data, max, preOrder);
        }

        return root;
    }

    public static Node bstFromPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        return build(min, max, preorder);
    }

    public static void main(String[] args) {
        int preorder[] = { 8, 5, 1, 7, 10, 12 };
        Node root = bstFromPreorder(preorder);
        Traversals.levelOrderTraversal(root);
    }
}

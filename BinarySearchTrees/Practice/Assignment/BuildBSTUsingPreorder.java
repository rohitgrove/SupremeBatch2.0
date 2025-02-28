public class BuildBSTUsingPreorder {
    public static Node build(int[] idx, int min, int max, int[] preorder) {
        if (idx[0] >= preorder.length) {
            return null;
        }

        Node root = null;

        if (preorder[idx[0]] > min && preorder[idx[0]] < max) {
            root = new Node(preorder[idx[0]++]);
            root.left = build(idx, min, root.data, preorder);
            root.right = build(idx, root.data, max, preorder);
        }

        return root;
    }

    public static Node bstFromPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        int idx[] = { 0 };
        return build(idx, min, max, preorder);
    }

    public static void main(String[] args) {
        int preorder[] = { 8, 5, 1, 7, 10, 12 };
        Node root = bstFromPreorder(preorder);
        Traversals.levelOrder(root);
        Traversals.morrisTraversal(root);
    }
}

public class IsBinaryTreeHeap {
    public static int nodeCount(Node root) {
        if (root == null) {
            return 0;
        }
        int l = nodeCount(root.left);
        int r = nodeCount(root.right);
        return 1 + l + r;
    }

    public static boolean isCBT(Node root, int i, int n) {
        if (root == null) {
            return true;
        }
        if (i >= n) {
            return false;
        }

        return isCBT(root.left, 2 * i + 1, n) && isCBT(root.right, 2 * i + 2, n);
    }

    public static boolean isMaxOrder(Node root) {
        if (root == null) {
            return true;
        }

        // If the node is a leaf node, it's trivially true
        if (root.left == null && root.right == null) {
            return true;
        }

        // If the node has only left child
        if (root.left != null && root.right == null) {
            return root.data > root.left.data && isMaxOrder(root.left);
        }

        // If the node has both children
        if (root.left != null && root.right != null) {
            return root.data > root.left.data && root.data > root.right.data &&
                    isMaxOrder(root.left) && isMaxOrder(root.right);
        }

        // If the node has only right child (shouldn't occur in a heap but handling it)
        return false;
    }

    public static boolean isHeap(Node tree) {
        int n = nodeCount(tree);
        int i = 0;
        return isCBT(tree, i, n) && isMaxOrder(tree);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 40, -1, -1, 60, -1, -1, 30, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(arr);
        System.out.println(isHeap(root));
    }
}

public class CBTIsValidMaxHeapOrNot {
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

        boolean left = isMaxOrder(root.left);
        boolean right = isMaxOrder(root.right);

        int leftValue = root.left == null ? Integer.MIN_VALUE : root.left.data;
        int rightValue = root.right == null ? Integer.MIN_VALUE : root.left.data;
        return root.data > leftValue && root.data > rightValue && left && right;
    }

    public static boolean isHeap(Node root) {
        int n = nodeCount(root);
        int i = 0;
        return isCBT(root, i, n) && isMaxOrder(root);
    }

    public static void main(String[] args) {
        ConstructTreeBT ct = new ConstructTreeBT();
        int data1[] = { 100, 40, 10, 5, -1, -1, -1, 20, -1, -1, 50, 30, -1, -1, 34, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(isHeap(root1));

        ct.idx = 0;
        int data2[] = { 97, 46, 12, -1, -1, 3, 2, -1, -1, 4, -1, -1, 37, 7, -1, -1, 31, -1, -1 };
        Node root2 = ct.createTree(data2);
        System.out.println(isHeap(root2));
    }
}

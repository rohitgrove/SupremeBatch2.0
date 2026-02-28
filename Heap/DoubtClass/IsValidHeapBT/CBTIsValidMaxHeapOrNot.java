public class CBTIsValidMaxHeapOrNot {
    public static int nodecount(Node root) {
        if (root == null) {
            return 0;
        }
        int l = nodecount(root.left);
        int r = nodecount(root.right);
        return 1 + l + r;
    }

    public static boolean isCBT(Node root, int i, int n) {
        if (root == null) {
            return true;
        }
        if (i >= n)
            return false;
        return isCBT(root.left, 2 * i + 1, n) && isCBT(root.right, 2 * i + 2, n);
    }

    static boolean isMaxHeap(Node root) {
        if (root == null) {
            return true;
        }

        boolean l = isMaxHeap(root.left);
        boolean r = isMaxHeap(root.right);

        boolean ans;
        if (root.left == null && root.right == null)
            ans = true;
        else if (root.left != null && root.right == null) {
            ans = root.data > root.left.data;
        } else if (root.left != null && root.right == null) {
            ans = root.data > root.right.data;
        } else {
            ans = root.data > root.left.data && root.data > root.right.data;
        }
        return ans && l && r;
    }

    public static boolean isHeap(Node root) {
        int n = nodecount(root);
        int i = 0;
        return isCBT(root, i, n) && isMaxHeap(root);
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

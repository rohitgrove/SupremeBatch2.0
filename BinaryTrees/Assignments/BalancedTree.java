public class BalancedTree {
    static boolean isBalanced = true;
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        // check for is balanced?
        if (isBalanced && Math.abs(lh - rh) > 1) {
            isBalanced = false;
        }

        return Math.max(lh, rh) + 1;
    }

    public static boolean isBalanced(Node root) {
        height(root);
        return isBalanced;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(isBalanced(root1));
        int data2[] = { 1, 2, 3, 4, -1, -1, 4, -1, -1, 3, -1, -1, 2, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(isBalanced(root2));
        int data3[] = { 10, 20, 40, -1, -1, 50, -1, -1, 30, -1, 60, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(isBalanced(root3));
    }
}

public class FindHeightOfBalancedTree {
    static boolean isBalanced = true;

    public static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        // check for current node, is it balanced
        if (isBalanced && Math.abs(lh - rh) > 1) {
            isBalanced = false;
        }

        return Math.max(lh, rh) + 1;
    }

    public static boolean isBalanced(Node root) {
        findHeight(root);
        return isBalanced;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(isBalanced(root1));

        int data2[] = { 1, 2, 3, 4, -1, -1, 4, -1, -1, 3, -1, -1, 2, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(isBalanced(root2));
    }
}

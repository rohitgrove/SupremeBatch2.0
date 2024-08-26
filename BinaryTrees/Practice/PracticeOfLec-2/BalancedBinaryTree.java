public class BalancedBinaryTree {
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int diff = Math.abs(lh-rh);

        boolean currNodeAns = diff <= 1;

        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);

        return currNodeAns && leftAns && rightAns;
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

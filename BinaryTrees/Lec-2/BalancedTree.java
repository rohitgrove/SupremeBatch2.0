public class BalancedTree {
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight, rightheight) + 1;
    }

    public static boolean isBalanced(Node root) {
        // base case
        if (root == null) {
            return true;
        }

        // currNode
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int diff = Math.abs(leftheight - rightheight);

        boolean currNodeAns = (diff <= 1);

        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);

        return (currNodeAns && leftAns && rightAns);
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

public class DiameterOfBinaryTree {
    static int D = 0;
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        // diameter
        int currD = lh + rh;
        D = Math.max(currD, D);
        return Math.max(lh, rh) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        height(root);
        return D;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        Node root1 = ct.createTree(data1);
        ct.levelOrder(root1);
        System.out.println(diameterOfBinaryTree(root1));
        int data2[] = { 10, 11, 20, -1, -1, 12, 60, -1, -1, 80, -1, -1, 15, -1, 40, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        ct.levelOrder(root2);
        System.out.println(diameterOfBinaryTree(root2));
    }
}

public class DiameterOfBinaryTree {
    static int D = 0;
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int currD = lh + rh;
        D = Math.max(D, currD);

        return Math.max(rh, lh) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        height(root);
        return D;
    }

    public static void main(String[] args) {
        int data1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(diameterOfBinaryTree(root1));
        int data2[] = { 10, 20, 40, -1, -1, 50, 80, -1, -1, -1, 30, 60, -1, 90, -1, -1, 70, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(diameterOfBinaryTree(root2));
        int data3[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        ConstructTree ct3 = new ConstructTree();
        Node root3 = ct3.createTree(data3);
        System.out.println(diameterOfBinaryTree(root3));
    }
}

public class TransformToSumTree {
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            // leaf
            int temp = root.data;
            root.data = 0;
            return temp;
        }

        int lsum = sum(root.left);
        int rsum = sum(root.right);
        int temp = root.data;
        root.data = lsum + rsum;
        return root.data + temp;
    }

    public static void toSumTree(Node root) {
        sum(root);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 10, -2, 8, -1, -1, -4, -1, -1, 6, 7, -1, -1, 5, -1, -1 };
        Node root = ct.createTree(data);
        ct.inOrder(root);
        toSumTree(root);
        System.out.println();
        ct.inOrder(root);
    }
}

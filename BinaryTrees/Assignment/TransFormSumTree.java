public class TransFormSumTree {
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            // Leaf node
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
        int data[] = { 10, -2, 8, -1, -1, -4, -1, -1, 6, 7, -1, -1, -5, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        System.out.println("Before sum tree");
        ct.bfs(root);
        toSumTree(root);
        System.out.println("After sum tree");
        ct.bfs(root);
    }
}

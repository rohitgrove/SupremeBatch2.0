public class KthSmallestNumber {
    public static int solve(Node root, int k[]) {
        if (root == null) {
            return -1;
        }

        int leftAns = solve(root.left, k);
        if (leftAns != -1) {
            return leftAns;
        }

        k[0]--;
        if (k[0] == 0) {
            return root.data;
        }

        int rightAns = solve(root.right, k);
        return rightAns;
    }

    public static int kthSmallest(Node root, int k) {
        int K[] = {k};
        return solve(root, K);
    }

    public static void main(String[] args) {
        int data[] = { 30, 50, 70, 100, 120, 200, 300 };
        Node root = ConstructTree.bstFromInorder(data, 0, data.length - 1);
        Traversals.levelOrder(root);
        System.out.println(kthSmallest(root, 1));
    }
}

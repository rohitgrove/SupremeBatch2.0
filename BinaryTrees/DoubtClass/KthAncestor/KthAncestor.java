public class KthAncestor {
    public static Node solve(Node root, int[] k, int node, int[] ans) {
        if (root == null) {
            return null;
        }

        if (root.data == node) {
            return root;
        }

        if (ans[0] != -1) {
            // answer mil chuka hai toh aage mat jao
            return root;
        }

        Node left = solve(root.left, k, node, ans);
        Node right = solve(root.right, k, node, ans);

        // node yaha hai
        if (left == null && right == null) {
            return null;
        }

        k[0]--;

        if (k[0] == 0) {
            ans[0] = root.data;
        }

        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return right;
        }
    }

    public static int kthAncestor(Node root, int k, int node) {
        int ans[] = { -1 };
        int count[] = { k };
        solve(root, count, node, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, 8, -1, -1, 3, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(kthAncestor(root1, 4, 8));
        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(kthAncestor(root2, 2, 4));
    }
}

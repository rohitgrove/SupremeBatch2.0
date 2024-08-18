public class KthAncestor {
    static int ans = -1;
    static int count;
    public static Node solve(Node root, int node) {
        if (root == null) {
            return null;
        }

        if (root.data == node) {
            return root;
        }

        if (ans != -1) {
            // answer mil chuka hia toh aage mat jao
            return root;
        }

        Node l = solve(root.left, node);
        Node r = solve(root.right, node);

        // node yaha hogi
        if (l == null && r == null) {
            return null;
        }

        count--;
        if (count == 0) {
            ans = root.data;
        }

        if (l != null && r == null) {
            return l;
        } else if (l == null && r != null) {
            return r;
        } else {
            return root;
        }
    }
    
    public static int kthAncestor(Node root, int k, int node) {
        count = k;
        solve(root, node);
        return ans;
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        System.out.println(kthAncestor(root, 2, 4));
    }
}
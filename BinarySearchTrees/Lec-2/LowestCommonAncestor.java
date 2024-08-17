public class LowestCommonAncestor {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        // base case
        if (root == null) {
            return null;
        }

        // case 1: p and q both comes in left subtree of root node
        if (p.data < root.data && q.data < root.data) {
            Node leftAns = lowestCommonAncestor(root.left, p, q);
            return leftAns;
        }

        // case 2: p and q both comes in right subtree of root node
        if (p.data > root.data && q.data > root.data) {
            Node rightAns = lowestCommonAncestor(root.right, p, q);
            return rightAns;
        }

        // case 3:
        // p is in left subtree of root && q is on right subtree of root node
        if (p.data < root.data && q.data > root.data) {
            return root;
        }

        // case 4:
        // q is in left subtree of root && p is on right subtree of root node
        if (q.data < root.data && p.data > root.data) {
            return root;
        }

        return root;
    }

    public static void main(String[] args) {
        int data[] = { 6, 2, 8, 0, 4, 7, 9, 3, 5 };
        Node root = ConstructTree.createTree(data);

        Node p1 = root.left;
        Node q1 = root.right;
        System.out.println(lowestCommonAncestor(root, p1, q1).data);

        Node p2 = root.left;
        Node q2 = root.left.right;
        System.out.println(lowestCommonAncestor(root, p2, q2).data);
    }
}

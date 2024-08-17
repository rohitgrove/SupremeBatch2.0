public class LCAOfBST {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.data < root.data && q.data > root.data) {
            return root;
        }

        if (p.data > root.data && q.data < root.data) {
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

public class LowestCommonAncestor {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        if (p.data == root.data) {
            return p;
        }

        if (q.data == root.data) {
            return q;
        }

        Node leftAns = lowestCommonAncestor(root.left, p, q);
        Node rightAns = lowestCommonAncestor(root.right, p, q);

        if (leftAns == null && rightAns == null) {
            return null;
        } else if (leftAns != null && rightAns == null) {
            return leftAns;
        } else if (leftAns == null && rightAns != null) {
            return rightAns;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        int data1[] = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(lowestCommonAncestor(root1, root1.left, root1.right).data);
        System.out.println(lowestCommonAncestor(root1, root1.left, root1.left.right.right).data);
        int data2[] = { 10, 20, 40, -1, -1, 45, 60, 90, -1, -1, 70, -1, -1, 65, -1, -1, 30, 50, -1, -1, 55, -1, 85, -1,
                -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(lowestCommonAncestor(root2, root2.left.left, root2.left.right.right).data);
    }
}

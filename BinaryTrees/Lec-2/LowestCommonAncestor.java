public class LowestCommonAncestor {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        if (root.data == p.data) {
            return p;
        }

        if (root.data == q.data) {
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
        ConstructTree ct = new ConstructTree();
        int data1[] = { 10, 20, 40, -1, -1, 50, 80, -1, -1, 90, -1, -1, 30, 60, -1, -1, 70, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(lowestCommonAncestor(root1, root1.left.left, root1.left.right.right).data);
        int data2[] = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(lowestCommonAncestor(root2, root2.left, root2.right).data);
        System.out.println(lowestCommonAncestor(root2, root2.left, root2.left.right.right).data);
        int data3[] = { 10, 20, 40, -1, -1, 45, 60, 90, -1, -1, 70, -1, -1, 65, -1, -1, 30, 50, -1, -1, 55, -1, 85, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(lowestCommonAncestor(root3, root3.left.left, root3.left.right.right).data);
        System.out.println(lowestCommonAncestor(root3, root3.left.right.left.right, root3.left.right.right).data);
    }
}

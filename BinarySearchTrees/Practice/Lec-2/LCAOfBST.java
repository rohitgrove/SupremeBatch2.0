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

        if (p.data > root.data && q.data < root.data) {
            return root;
        }

        if (p.data < root.data && q.data > root.data) {
            return root;
        }

        return root;
    }

    public static void main(String[] args) {
        int data1[] = { 30, 50, 70, 100, 120, 200, 300 };
        Node root1 = ConstructTree.bstFromInorder(data1, 0, data1.length - 1);
        System.out.println(lowestCommonAncestor(root1, root1.left.left, root1.left.right).data);

        int data2[] = { 6, 2, 8, 0, 4, 7, 9, 3, 5 };
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(lowestCommonAncestor(root2, root2.left, root2.right).data);
        System.out.println(lowestCommonAncestor(root2, root2.left, root2.left.right).data);
    }
}

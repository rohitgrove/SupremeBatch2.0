public class LCAOfBST {
    public static Node lowestCommonAncestor1(Node root, Node p, Node q) {
        // base case
        if (root == null) {
            return null;
        }

        // case 1: p and q both comes in left subtree of root node
        if (p.data < root.data && q.data < root.data) {
            Node leftAns = lowestCommonAncestor1(root.left, p, q);
            return leftAns;
        }

        // case 2: p and q both comes in right subtree of root node
        if (p.data > root.data && q.data > root.data) {
            Node rightAns = lowestCommonAncestor1(root.right, p, q);
            return rightAns;
        }

        // case 3: p is in left subtree of root and q is in right subtree of root node
        if (p.data < root.data && q.data > root.data) {
            return root;
        }

        // case 4: q is in left subtree of root and p is in right subtree of root node
        if (p.data > root.data && q.data < root.data) {
            return root;
        }

        return root;
    }

    public static Node lowestCommonAncestor2(Node root, Node p, Node q) {
        // base case
        if (root == null) {
            return null;
        }

        // case 1: p and q both comes in left subtree of root node
        if (p.data < root.data && q.data < root.data) {
            Node leftAns = lowestCommonAncestor2(root.left, p, q);
            return leftAns;
        }

        // case 2: p and q both comes in right subtree of root node
        if (p.data > root.data && q.data > root.data) {
            Node rightAns = lowestCommonAncestor2(root.right, p, q);
            return rightAns;
        }

        return root;
    }

    public static void main(String[] args) {
        int data1[] = { 30, 50, 70, 100, 120, 200, 300 };
        Node root1 = ConstructTree.bstFromInorder(data1, 0, data1.length - 1);
        System.out.println(lowestCommonAncestor1(root1, root1.left.left, root1.left.right).data);
        System.out.println(lowestCommonAncestor2(root1, root1.left.left, root1.left.right).data);

        int data2[] = { 6, 2, 8, 0, 4, 7, 9, 3, 5 };
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(lowestCommonAncestor1(root2, root2.left, root2.right).data);
        System.out.println(lowestCommonAncestor2(root2, root2.left, root2.right).data);
        System.out.println(lowestCommonAncestor1(root2, root2.left, root2.left.right).data);
        System.out.println(lowestCommonAncestor2(root2, root2.left, root2.left.right).data);
    }
}

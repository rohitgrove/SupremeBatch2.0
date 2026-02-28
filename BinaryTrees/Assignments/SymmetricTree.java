public class SymmetricTree {
    public static boolean isMirror(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            return (p.data == q.data)
                && isMirror(p.left, q.right)
                && isMirror(p.right, q.left);
        }

        return false;
    }

    public static boolean isSymmetric(Node root) {
        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(isSymmetric(root1));
        System.out.println();
        int data2[] = { 1, 2, -1, 3, -1, -1, 2, -1, 3, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(isSymmetric(root2));
    }
}

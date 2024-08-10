public class SymmentricTree {
    public static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return (p.data == q.data)
                    && isSameTree(p.left, q.right)
                    && isSameTree(p.right, q.left);
        }
        
        return false;
    }

    public static boolean isSymmetric(Node root) {
        return isSameTree(root.left, root.right);
    }

    public static void main(String[] args) {
        int data1[] = { 1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root1 = ct.createTree(data1);
        System.out.println(isSymmetric(root1));

        int data2[] = { 1, 2, -1, 3, -1, -1, 2, -1, 3, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(isSymmetric(root2));
    }
}
